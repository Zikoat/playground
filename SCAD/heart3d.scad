
// fn is recommended = x*4 + 2 (6,10,14,18,22,126)
// 10 is best
$fn = 14;

//radius
size = 12;

// how high it bounces
bounce = 20;

// how many degrees of rotation, and how many times it should do this through a loop
rotation = 180;
rotationTimes = 3;

pi = 3.14159265359;

// lock view
$vpt = [0,0,bounce/2];

/////////////////////////////////////////////////////////////
// IMPLEMENTING BOUNCE
// try to use 1 variable between 0-1, and make the function go up and down
function bounce () = 3;

// square function for bounce, implements 1 bounce over the entire period
// (-$t*($t-1))*bounce*4

//sine function for bounce, lags, implements multiple bounces
// floor(sin($t*10)*50+60)

translate([0,0,(-$t*($t-1))*bounce*4])
rotate([0,0,$t*180])

//////////////////////////////////////////////////////////

color("red", 1)
union(){
    intersection() {
        rotate(a=45, v = [1,0,0])
            cylinder(r = size, h = size*2, center = true);

        rotate(a=-45, v = [1,0,0])
            cylinder( r = size, h = size*2, center = true);
    };

    for(i = [-1:2:1]){
        rotate(a=45*i, v = [1,0,0])
        union(){
            cylinder(r = size, h = size, center = false);
            
            translate([0,0,size]) 
            sphere(size);
        }
    }
}
