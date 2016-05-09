// simple custom polybowl

radius = 30;
sides = 8;
thickness = 1.5;

//////////////////////////////////////////////
// RENDERS

linear_extrude( height=50, twist=30, slices=50, scale=1.3)
    polyShape( solid=false );

//////////////////////////////////////////////
// MODULES

module polyShape(){
    difference(){
        //start with outside shape
        offset( r=5, $fn=48)
            circle( r=radius, $fn=sides );
        //take away inside shape
        if(solid==false){
            offset( r=5-thickness, $fn=48)
                circle( r=radius, $fn=sides );
        }
    }
}