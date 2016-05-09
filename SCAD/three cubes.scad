brightness = 1.0;

translate([0, 0, 0])
color([brightness, 0.0, 0.0]) 
cube( [10,20,30], center=true );

translate([0, -30, 0])
color([0.0, brightness, 0.0]) 
cube( [10,20,30], center=true );

translate([0, 30, 0])
color([0.0, 0.0, brightness]) 
cube( [10,20,30], center=true );