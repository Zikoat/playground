"use strict";
var height = 2;
var width = 1;

var input =  [["orange"],["red","yellow"]];
var output = [["yellow"],["orange","red"]];

var field = [];

var solutions = [];

for(var i = 0; i < height; i++) {
  field[i] = [];
  for(var j = 0; j < width; j++) {
    field[i][j] = 0;
  }
}

function cloneArray(arr) {
  return arr.map(function(deepArr) {
    return deepArr.slice();
  });
}

// dir 0 = y = i
// dir 1 = x = j
function calcLine(dir, index){
  var color = input[dir][index];
  var y = 0; var x = 0
  if(dir == 1){y = index;}
  else if (dir == 0) {x = index;}
  while(true/*y <= height && x <= width*/) {

    if(dir == 0 && field[y][x] == 1) {dir = 1;}
    else if(dir == 1 && field[y][x] == 1) {dir = 0;};

    // console.log(x.toString() + " " + y.toString());

    if((y == height-1 && dir == 0) || (x == width-1 && dir == 1)){
      if(dir == 0) {index = x;}
      else if(dir == 1) {index = y;};
      var outBool = false;

      var colorOut = output[dir][index];
      if(Array.isArray(colorOut)){

        for(var i = 0; i < colorOut.length; i++){
          if(color == colorOut[i]) {
            outBool = true;
            //console.log("found exit")
            return (outBool);
            break;
          }
        }
      } else {return (color == colorOut)}


      break;
    };

    if(dir == 0) y++;
    else if(dir == 1) x++;
  }
}

for(i = 0; i < Math.pow(2, width * height); i++) {
  var bool = false;
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
    while((index <= maxIndex)) {
      if(calcLine(dir, index)){
        bool = true;
      }
      index++;
    }
  }
  if(bool){
    solutions.push({
      binaryString: binaryString,
      field: cloneArray(field)
    });
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
}).forEach(function(solution) {
  console.log("Moves required: " + solution.moves);
  console.log("Field:");
  solution.field.forEach(function(row) {
    console.log(row);
  });

  console.log('\n\n')
})
