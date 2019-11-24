var sha256=function r(o){function e(r,o){return r>>>o|r<<32-o}for(var t,n,a=Math.pow,h=a(2,32),f="",c=[],C=8*o.length,g=r.h=r.h||[],i=r.k=r.k||[],d=i.length,u={},A=2;d<64;A++)if(!u[A]){for(t=0;t<313;t+=A)u[t]=A;g[d]=a(A,.5)*h|0,i[d++]=a(A,1/3)*h|0}for(o+="";o.length%64-56;)o+="\0";for(t=0;t<o.length;t++){if((n=o.charCodeAt(t))>>8)return;c[t>>2]|=n<<(3-t)%4*8}for(c[c.length]=C/h|0,c[c.length]=C,n=0;n<c.length;){var l=c.slice(n,n+=16),s=g;for(g=g.slice(0,8),t=0;t<64;t++){var v=l[t-15],S=l[t-2],p=g[0],m=g[4],k=g[7]+(e(m,6)^e(m,11)^e(m,25))+(m&g[5]^~m&g[6])+i[t]+(l[t]=t<16?l[t]:l[t-16]+(e(v,7)^e(v,18)^v>>>3)+l[t-7]+(e(S,17)^e(S,19)^S>>>10)|0);(g=[k+((e(p,2)^e(p,13)^e(p,22))+(p&g[1]^p&g[2]^g[1]&g[2]))|0].concat(g))[4]=g[4]+k|0}for(t=0;t<8;t++)g[t]=g[t]+s[t]|0}for(t=0;t<8;t++)for(n=3;n+1;n--){var w=g[t]>>8*n&255;f+=(w<16?0:"")+w.toString(16)}return f};
var sha1 = function(r){function o(r,o){return r<<o|r>>>32-o}function e(r){var o,e="";for(o=7;o>=0;o--)e+=(r>>>4*o&15).toString(16);return e}var t,n,a,h,f,c,C,g,i,d=new Array(80),u=1732584193,A=4023233417,l=2562383102,s=271733878,v=3285377520,S=(r=function(r){r=r.replace(/\r\n/g,"\n");for(var o="",e=0;e<r.length;e++){var t=r.charCodeAt(e);t<128?o+=String.fromCharCode(t):t>127&&t<2048?(o+=String.fromCharCode(t>>6|192),o+=String.fromCharCode(63&t|128)):(o+=String.fromCharCode(t>>12|224),o+=String.fromCharCode(t>>6&63|128),o+=String.fromCharCode(63&t|128))}return o}(r)).length,p=new Array;for(n=0;n<S-3;n+=4)a=r.charCodeAt(n)<<24|r.charCodeAt(n+1)<<16|r.charCodeAt(n+2)<<8|r.charCodeAt(n+3),p.push(a);switch(S%4){case 0:n=2147483648;break;case 1:n=r.charCodeAt(S-1)<<24|8388608;break;case 2:n=r.charCodeAt(S-2)<<24|r.charCodeAt(S-1)<<16|32768;break;case 3:n=r.charCodeAt(S-3)<<24|r.charCodeAt(S-2)<<16|r.charCodeAt(S-1)<<8|128}for(p.push(n);p.length%16!=14;)p.push(0);for(p.push(S>>>29),p.push(S<<3&4294967295),t=0;t<p.length;t+=16){for(n=0;n<16;n++)d[n]=p[t+n];for(n=16;n<=79;n++)d[n]=o(d[n-3]^d[n-8]^d[n-14]^d[n-16],1);for(h=u,f=A,c=l,C=s,g=v,n=0;n<=19;n++)i=o(h,5)+(f&c|~f&C)+g+d[n]+1518500249&4294967295,g=C,C=c,c=o(f,30),f=h,h=i;for(n=20;n<=39;n++)i=o(h,5)+(f^c^C)+g+d[n]+1859775393&4294967295,g=C,C=c,c=o(f,30),f=h,h=i;for(n=40;n<=59;n++)i=o(h,5)+(f&c|f&C|c&C)+g+d[n]+2400959708&4294967295,g=C,C=c,c=o(f,30),f=h,h=i;for(n=60;n<=79;n++)i=o(h,5)+(f^c^C)+g+d[n]+3395469782&4294967295,g=C,C=c,c=o(f,30),f=h,h=i;u=u+h&4294967295,A=A+f&4294967295,l=l+c&4294967295,s=s+C&4294967295,v=v+g&4294967295}return(i=e(u)+e(A)+e(l)+e(s)+e(v)).toLowerCase()}
var password = "";
$(document).ready(() => {
  $("#password").on("keypress", function(e) {
    if (e.which == 13) {
      $.ajax({
        type: "GET",
        headers: {
          'authorization': sha1($(this).val())
        },
        url: "/admin/api/authenticated",
        success: function(msg) {
          $(".content").animate({
            opacity: 1
          }, 500);
          $("#password").animate({
            opacity: 0
          }, 500);
          password = $("#password").val();
          $("#password").val("")
        },
        error: function(err) {
          window.close()
        }
      });
    }
  });
});