const express         = require('express');
const app             = express();
const server          = require('http').createServer(app);
const port            = process.env.PORT || 3000;
const cors            = require('cors');
const compression     = require('compression');
const redirectToHTTPS = require('./lib/https');
const hbs             = require('hbs');
const fs              = require('fs').promises;
const Ddos            = require('ddos');
const btoa            = require('btoa');
const fetch           = require('node-fetch');
const client          = require('./discord/bot');
const crypto          = require('./lib/minicrypto')

const CLIENT_ID = process.env.CLIENT_ID;
const CLIENT_SECRET = process.env.CLIENT_SECRET;
const redirect = encodeURIComponent('https://cepi.glitch.me/ready');
const catchAsync = fn => ((req, res, next) => {
    const routePromise = fn(req, res, next);
    if (routePromise.catch) routePromise.catch(err => next(err));
  }
);

var ddos = new Ddos({burst: 10, limit: 15})

// express middlewares
app.use(redirectToHTTPS([/localhost:(\d{4})/], [/\/dynmap/], 301));
app.use(compression());
app.use(express.static('public'));
app.use(cors());
app.use(ddos.express);

hbs.registerPartials(__dirname + '/modules/partials');
app.set('view engine', 'hbs');

// default routing
app.get("/", async (request, response) => response.render('index'));
app.get("/changelog", async (request, response) => response.render('changelog'));
app.get("/dynmap", async (request, response) => {
  if (request.protocol != 'https') response.render("dynmap");
  else response.redirect("http://cepi.glitch.me/dynmap")
});
app.get("/map", async (request, response) => response.redirect('http://cepi.glitch.me/dynmap'));
app.get("/apply", async (request, response) => response.render('application'));
app.get("/docs", async (request, response) => response.render('docs'));
app.get("/documentation", async (request, response) => response.render('docs'));
app.get("/discord", async (request, response) => response.redirect('https://discord.gg/cnz52Cm'))

app.get('/login', async (req, res) => res.redirect(`https://discordapp.com/api/oauth2/authorize?client_id=${CLIENT_ID}&scope=identify&response_type=code&redirect_uri=${redirect}`));
app.get('/ready', catchAsync(async (req, res) => {
  if (!req.query.code) throw new Error('NoCodeProvided');
  const code = req.query.code;
  const creds = btoa(`${CLIENT_ID}:${CLIENT_SECRET}`);
  const response = await fetch(`https://discordapp.com/api/oauth2/token?grant_type=authorization_code&code=${code}&redirect_uri=${redirect}`,
    {
      method: 'POST',
      headers: {
        Authorization: `Basic ${creds}`,
      },
    });
  const json = await response.json();
  res.redirect(`/?token=${json.access_token}`);
}));

app.get("/api/changelog", async (request, response) => response.json(JSON.parse(await fs.readFile("changelog.json", "utf8"))))

app.get("/admin/panel", async (request, response) => response.render("admin"))

app.use((request, response, next) => {
  if (request.headers.authorization == crypto.sha1(process.env.PASSWORD)) next();
  else return response.status(403).json({ error: 'Unauthorized' });
})
app.get("/admin/api/authenticated", async (request, response) => response.json({success: "Authorized"}))

app.use((request, response, next) => {
  if (
    (request.headers.authorization == process.env.PASSWORD)
    &&
    (request.headers.hash == crypto.sha256(process.env.PASSWORD)
    &&
    (request.headers.signature == crypto.sha1(process.env.PASSWORD))
    )) next();
  else return response.status(418).json({ error: "I'm a teapot." });
})
app.post("/admin/api/changelog", async (request, response) => {
  response.json({"Hey!": "Hu!"});
});

// listen to the server
server.listen(port, () => console.log('Server listening at port %d', port))

fs.readFile("changelog.json", "utf8").then(i => {
  app.locals.changelog = i;
  hbs.localsAsTemplateData(app);
})

hbs.registerHelper('each', (context, options) => {
  var ret = "";
  if (typeof context !== "string") null;
  else context = JSON.parse(context)
  for (var i=0, j=context.length; i<j; i++) ret = ret + options.fn(context[i]);

  return ret;
});
