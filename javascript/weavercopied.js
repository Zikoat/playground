"use strict";
var height = 3;
var width = 3;

var input =  [["a","b","c"],["a","c","b"]];
var output = [["b","a","c"],["c","b","a"]];

var field = [];

var solutions = [];

for(var i = 0; i < height; i++) {
  field[i] = [];
  for(var j = 0; j < width; j++) {
    field[i][j] = 0;
  }
}

function cloneArray(arr) {
  // Deep copy arrays. Going one level deep seems to be enough.
  var clone = [];
  for (i=0; i<arr.length; i++) {
    clone.push( arr[i].slice(0) )
  }

  clone.forEach(function(curArray, i) {
    clone[i] = cloneArray(curArray[i]);
  });
  return clone;
}

// dir 0 = y = i
// dir 1 = x = j
function calcLine(dir, index){
  var color = input[dir][index];
  var y = 0; var x = 0
  if(dir == 1){y = index;}
  else if (dir == 0) {x = index;}
  while(y <= height && x <= width) {

    if(dir == 0 && field[y][x] == 1) {dir = 1;}
    else if(dir == 1 && field[y][x] == 1) {dir = 0;};

    // console.log(x.toString() + " " + y.toString());

    if((y == height-1 && dir == 0) || (x == width-1 && dir == 1)){
      if(dir == 0) {index = x;}
      else if(dir == 1) {index = y;};

      var colorOut = output[dir][index];
      // console.log(color + " " + colorOut)
      return (color == colorOut);
      break;
    };

    if(dir == 0) y++;
    else if(dir == 1) x++;
  }
}

for(i = 0; i < Math.pow(2, width * height); i++) {
  var bool = true;
  var binaryString = i.toString(2);
  var zeroesToAdd = width*height - binaryString.length;
  for(var j = 0; j < zeroesToAdd; j++) {
    binaryString = '0' + binaryString;
  }

  binaryString.split("").forEach(function(binaryChar, i) {
    field[ Math.floor(i / width) ][i % width] = parseInt(binaryChar);
  });

  for(var dir = 0; dir <= 1; dir++) {
    if(dir == 0){var maxIndex = height -1;}
    else if(dir == 1){var maxIndex = width -1;}
    else {console.log("error: dir unexpected")}

    var index = 0;
    while((index < maxIndex)) {
      if(calcLine(dir, index) == false){
        bool = false;
      }
      index++;
    }
  }


}

solutions.map(function(solution) {
  solution.moves = solution.binaryString.split("").map(function(string) {
    return parseInt(string);
  }).reduce(function(prev, cur) {
    return prev+cur;
  });
  return solution;
}).sort(function(a, b) {
  return a.moves - b.moves;
});

console.log(solutions);
