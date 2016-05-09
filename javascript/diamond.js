var text = "";
var size=20;
for(var i=0; i<size; i++){
	for(var j=size; j>i; j--){
		text+=" ";
	}
	text+="O"
	for(j=0; j<i; j++){
		text+="OO"
	}
	text+="\n";
}
console.log(text);