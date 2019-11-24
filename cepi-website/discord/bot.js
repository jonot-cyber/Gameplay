const Discord    = require('discord.js');
const client     = new Discord.Client();
const fs         = require('fs').promises;
const config = {
  prefix: "%"
}
const bot = new Discord.Client()

client.on('ready', () => {
  console.log(`Logged in as ${client.user.tag}!`);
});

client.on('message', async message => {
  if(message.author.bot) return;
  if(message.content.indexOf(config.prefix) !== 0) return;
  const args = message.content.slice(config.prefix.length).trim().split(/ +/g);
  const command = args.shift().toLowerCase();
  if (command === "ping") {
    const m = await message.channel.send("Ping?");
    m.edit(`Pong! Latency is ${m.createdTimestamp - message.createdTimestamp}ms. API Latency is ${Math.round(client.ping)}ms`);
  }
  if (command === "changelog") {
    let data = JSON.parse(await fs.readFile("changelog.json", "utf8"))
    let embed = {
      embed: {
        title: `${data[0].name}`,
        description: `Made on ${data[0].date}`,
        url: "https://discordapp.com",
        color: 16347478,
        timestamp: "2019-11-10T19:54:07.835Z",
        footer: {
          icon_url: "https://cdn.discordapp.com/embed/avatars/0.png",
          text: "Cepi"
        },
        author: {
          name: message.author.name,
          url: "https://discordapp.com",
          icon_url: "https://cdn.discordapp.com/embed/avatars/0.png"
        },
        fields: [
        ]
      }
    }
    data[0].changes.forEach(i => {
      embed.embed.fields.push({name: i.type.toUpperCase(), value: i.content})
    })
    message.channel.send(embed);
    
  }
    
});
client.login(process.env.CLIENT_TOKEN);

module.exports = client;