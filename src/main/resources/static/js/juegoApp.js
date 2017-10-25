/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global apiclient, idsala, Stomp */

var api=apiclient;
juegoApp=(function (){
    var vx=10;
    var vy=0;
    var stompClient;
    var idsala;
    var eq;
    var posx;
    var posy;
    var mirada;
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
        
    }
    function map(mapa) {
        for (var i = 0; i < mapa.length; i++) {
            for (var j = 0; j < mapa[i].length; j++) {
                console.log(j === mapa[i].length - 1);
                ventana(mapa[i][j], j === mapa[i].length - 1);
            }
        }
        felix(eq);
    }
    
    var connectAndSubscribe = function () {
        console.info('Connecting to WS...');
        var socket = new SockJS("/stompendpoint");
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe("/topic/juego/mover."+idsala, function (data) {
                var a=JSON.parse(data.body);
                felix(eq);
            });
            stompClient.subscribe("/topic/juego/reparar."+idsala, function (data) {
               
            });
            stompClient.subscribe("/topic/juego/mapa."+idsala, function (data) {
                mapa(JSON.parse(data.body));
                
            });
            
        });
    };
    function felix(eq){
        var canvas = document.getElementById("micanvas");
        var ctx = canvas.getContext("2d");
        var img = new Image();
        if (eq === "1") {
            img.src = "/img/personajes/felix1"+mirada+".png";
        } else if(eq==="2") {
            img.src = "/img/personajes/felix"+mirada+".png";
        }
        img.onload = function () {
            ctx.drawImage(img,posx,posy,55,70);
        };
    }
    return{
        init:function(){
            idsala=sessionStorage.getItem('idroom');
            eq=sessionStorage.getItem('eq');
            var canvas = document.getElementById("micanvas");
            alert(sessionStorage.getItem('eq')+"   "+eq);
            if(eq==="1"){
                posx=0;posy=canvas.height-70;mirada="R0";
            }else if(eq==="2"){
                posx=canvas.width-55;posy=canvas.height-70;mirada="L0";
                
            }
            connectAndSubscribe();
            $(document).keydown(function (event) {
                var keypress=event.keyCode;
                /*repare*/
                if(keypress===77){
                    
                }
                /*der*/
                else if(keypress===37){
                    posx+=10;
                    stompClient.send("/topic/juego/mover."+idsala,{},JSON.parse({'x':100,'y':100}));
                }
                /*up*/
                else if(keypress===38){
                    posx+=10;
                    stompClient.send("/topic/juego/mover."+idsala,{},JSON.parse({'x':100,'y':100}));
                }
                /*iz*/
                else if(keypress===39){
                    posx-=10;
                    stompClient.send("/topic/juego/mover."+idsala,{},JSON.parse({'x':100,'y':100}));
                }
                /*down*/
                else if(keypress===40){
                    posy+=10;
                    stompClient.send("/topic/juego/mover."+idsala,{},JSON.parse({'x':100,'y':100}));
                }
            });
            api.getMapa(map);
        }
    };
})();

