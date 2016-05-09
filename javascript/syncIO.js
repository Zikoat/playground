var fs = require("fs");
var file = undefined;

var path = __dirname + "json.txt";

function getData(callback) {
  fs.readFile(path, function doneReading(err, data) {
    file = JSON.parse(data);
    callback();
  })
}

function logMyData(){
  console.log(file.name)
}

getData(logMyData);

//function callback (err, data) {
//  if (err) console.log(data);
//}
