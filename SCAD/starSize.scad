// lock view to center
// $vpt = [0,0,0];

// edges on the star
ticks = 6;

// how long the edges should be (in mm)
size = 30;

// how thick and wide the ticks should be
thickness = 0.3;
wideness = 0.3;

for ( i = [ 0 : ticks ] ){
    rotate( 360 / ticks * i, [ 0, 1, 0 ] )
    scale( [ wideness, thickness, 1 ] )
	color("gold")
    cylinder( size, size, 0, $fn = 4 );
}
