// lock view to center
 $vpt = [0,0,0];

$fn=4;

// edges on the star
ticks = 6;

// how long the edges should be (in mm)
length = 30;

// how thick and wide the ticks should be
thickness = 1;
wideness = 1;

module halfSnowTick () {
	rotate( [ 0, 0, 0 ] )
	union () {
		translate([5,0,0])
		square( [5,1], center = true );
		
		*translate([5,0,0])
		square( [10,1], center = true );
		
		translate([3,0,1])
		rotate([0,-45,0])
		square( [3,1], center = true );
		
		*translate([1.6,0,1])
		rotate([90,-45,0])
		square( [4,1], center = true );
		
		rotate([45,0,0])
		translate([5,0,0])
		rotate([0,90,0])
		cylinder(h=3, r1=sqrt(2)/2, r2=2, center=false);
		
	}
}

for ( i = [ 0 : ticks ] ){
    rotate( 360 / ticks * i, [ 0, 1, 0 ] )
    scale( [ wideness, thickness, 1 ] )
	color("gold")
    halfSnowTick();
	
	mirror([0,0,1])
	rotate( 360 / ticks * i, [ 0, 1, 0 ] )
    scale( [ wideness, thickness, 1 ] )
	color("gold")
    halfSnowTick();
	
	
}
