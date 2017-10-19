/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global apiclient */

var api=apiclient;
juegoApp=(function (){
    var vx=10;
    var vy=0;
    function ventana(tupla,val){
        var canvas = document.getElementById("micanvas");
        var ctx = canvas.getContext("2d");
        var img = new Image();
        img.src = "/img/ventana"+tupla.elem1+"/"+tupla.elem2+".png";
        img.onload = function () {
            ctx.drawImage(img,vx, vy);
            vx+=canvas.width/5;
            if(val){
                vy+=img.height;
                vx=0;
            }
        };
        
    }/**
    function felix1(){
        var canvas = document.getElementById("micanvas");
        var ctx = canvas.getContext("2d");
        var img = new Image();
        img.src = "/img/personajes"+tupla.elem1+"/"+tupla.elem2+".png";
    }
    function felix2(){
        var canvas = document.getElementById("micanvas");
        var ctx = canvas.getContext("2d");
        var img = new Image();
        img.src = "/img/ventana"+tupla.elem1+"/"+tupla.elem2+".png";
    }*/
    return{
        init:function(){
            $(document).keydown(function (event) {
                var keypress=event.keyCode;
                /*repare*/
                if(keypress===77){}
                /*der*/
                else if(keypress===37){}
                /*up*/
                else if(keypress===38){}
                /*iz*/
                else if(keypress===39){}
                /*down*/
                else if(keypress===40){}
            });
            api.getMapa(function (mapa){
                for (var i = 0;  i< mapa.length; i++) {
                    for (var j = 0;  j< mapa[i].length; j++){
                        console.log(j===mapa[i].length-1);
                        ventana(mapa[i][j],j===mapa[i].length-1);
                    }
                }
            });
            
        }
    };
})();

