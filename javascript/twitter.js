"use strict";
var Twitter = require("twitter");
var fs = require('fs');
var path = require('path');

var client = new Twitter({
  consumer_key: "A6Xi38ayZszEuCsezbLwz4uQ3",
  consumer_secret: "Tfp5F4q7iCQwCAJvz4UGU3H4lRz1Yq3SxDmXl10oVqIzCxNijV",
  access_token_key: "2492963694-dhVwcJ6pVEXXVP6skZXu0JGolqGoddlYBqNHojg",
  access_token_secret: "QF9RCEkqSZe1SrJDWa2VkZYn8I17lAJlPhbDJWPIoEA47"
});

var friends = JSON.parse( fs.readFileSync( "/home/zik/workspace/JavaScript/ids.json"));

console.log(friends["MajorLeagueWobs"]["ids"].length);

function getFollowers(screenName) {
  client.get("following/ids.json", {screen_name: "MajorLeagueWobs"}, function(err, data) {
    if(err) throw err;
    console.log(JSON.parse(data)["ids"].length);
    friends[screenName] = JSON.parse(data);
    fs.writeFileSync(path.join(__dirname, "ids.json")
    /*fs.writeFile(path.join(__dirname, screenName, '-folllowing-ids.json'),

    JSON.stringify(data), function(err) {
      if(err) throw err;
      console.log("Done!");
    });*/


  };
}
