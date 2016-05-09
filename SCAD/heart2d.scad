    

$fn = 12;

size = 10;
bounce = 20;
rotation = 180;

translate([0,0,(-$t*($t-1))*bounce*4])
rotate([0,0,$t*rotation])

color("red")
rotate(a=[90,-45,90])

union(){

	square([size*2,size*2], center=true);

translate([0,size,0])
circle(size);

translate([size,0,0])
circle(size);
}