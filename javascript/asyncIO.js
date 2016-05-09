var fs = require("fs");

function getLines(path) {
  fs.readFile(path, function callback(err, contents) {
    var lines = contents.toString().split("\n").length - 1;
    console.log(lines);
  })
}


getLines(process.argv[2]);
//function callback (err, data) {
//  if (err) console.log(data);
//}
