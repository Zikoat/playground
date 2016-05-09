window.onload = function() {
    'use strict';

    var canvas = document.getElementById("myCanvas");
    var ctx = canvas.getContext("2d");

    canvas.width  = window.innerWidth;
    canvas.height = window.innerHeight;

    ctx.beginPath();
    ctx.rect(10,10, 100,100);
    ctx.fillStyle = "#ff0000";
    ctx.fill();
    ctx.closePath();
    console.log(ctx);
};
