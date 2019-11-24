if (location.search && !document.cookie) {
  let token = location.search.substring(7,location.search.length)
  document.cookie = token;
}