$vpt = [0,0,0];

// edges on the star
ticks = 5;

// how long the edges should be (in mm)
length = 30;

thickness = 1.0;
wideness = 1.0;

color("gold")
for ( i = [ 1 : ticks ] ){
    rotate( 360 / ticks * i, [ 0, 1, 0 ] )
    scale( [ wideness, thickness, 1 ] )
    cylinder( length, 10, 0, $fn = 4 );
}