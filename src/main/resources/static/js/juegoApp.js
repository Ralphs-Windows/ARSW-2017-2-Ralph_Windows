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
    var h=55;
    var w=70;
    var mirada=0;
    var dir;
    var num;
    function ventana(tupla,val){
        var canvas = document.getElementById("ventanas");
        var ctx = canvas.getContext("2d");
        var img = new Image();
        img.onload = function () {
            tupla.ubicacion.xpos=vx;
            tupla.ubicacion.ypos=vy;
            tupla.ubicacion.ancho=img.width;
            tupla.ubicacion.alto=img.height;
            ctx.drawImage(img,vx, vy);
            vx+=canvas.width/5;
            if(val){
                vy+=img.height;
                vx=0;
            }
        };
        img.src = "/img/ventana"+tupla.estado+"/"+tupla.num+".png";
        return tupla;
    }
    function map(mapa) {
        for (var i = 0; i < mapa.length; i++) {
            for (var j = 0; j < mapa[i].length; j++) {
                ventana(mapa[i][j], j === mapa[i].length - 1);
            }
        }
    }
    var connectAndSubscribe = function () {
        console.info('Connecting to WS...');
        var socket = new SockJS("/stompendpoint");
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe("/topic/juego/mover."+idsala, function (data) {
                var a=JSON.parse(data.body);
                var canvas = document.getElementById("pjs");
                canvas.width=canvas.width;canvas.height=canvas.height;
                felix(a.ubicacion,a.eq,a.dir);
                
            });
            stompClient.subscribe("/topic/juego/reparar."+idsala, function (data) {
                var ventanas=JSON.parse(data.body);
                var canvas = document.getElementById("ventanas");
                canvas.width=canvas.width;canvas.height=canvas.height;
                map(ventanas);
            });
            stompClient.subscribe("/topic/juego/mapainit."+idsala, function (data) {
                var ventanas=JSON.parse(data.body);
                map(ventanas);
            });
            
        });
    };
    function felix(ubicacion,eq,mirada){
        var canvas = document.getElementById("pjs");
        var ctx = canvas.getContext("2d");
        var img = new Image();
        if (eq === "1") {
            img.src = "/img/personajes/felix1"+mirada+".png";
        } else if(eq==="2") {
            img.src = "/img/personajes/felix"+mirada+".png";
        }
        img.onload = function () {
            ctx.drawImage(img,ubicacion.xpos,ubicacion.ypos,ubicacion.alto,ubicacion.ancho);
        };
    }
    function felixinitial() {
        var canvas = document.getElementById("pjs");
        var ctx = canvas.getContext("2d");
        var img = new Image();
        var img2 = new Image();
        img.src = "/img/personajes/felix1R" + mirada + ".png";
        img2.src = "/img/personajes/felixL" + mirada + ".png";
        img.onload = function () {
            ctx.drawImage(img, 0, canvas.height - w, h, w);
        };
        img2.onload = function () {
            ctx.drawImage(img2, canvas.width - h, canvas.height - w, h, w);
        };
        if(eq==="1"){
            posx=0;
            posy=canvas.height - w;
        }else if(eq==="2"){
            posx=canvas.width - h;
            posy=canvas.height - w;
        }
    }
    var pos=function () {
        if(mirada>3){mirada=0;}
        stompClient.send("/topic/juego/mover."+idsala,{},JSON.stringify({"ubicacion":{"xpos":posx,"ypos":posy,"ancho":w,"alto":h},"eq":eq,"dir":dir+mirada,"num":num}));
    };
    return{
        init:function(){
            connectAndSubscribe();
            alert("Oprima la tecla enter para empezar");
            eq=sessionStorage.getItem('eq');
            num=sessionStorage.getItem('num');
            console.info(eq+" "+num);
            idsala=sessionStorage.getItem('idroom');
            $(document).keydown(function (event) {
                var keypress=event.keyCode;
                /*repare*/
                if(keypress===77){
                    
                }
                /*iz*/
                else if(keypress===37){
                    posx-=15;mirada+=1;dir="L";
                    pos();
                }
                /*up*/
                else if(keypress===38){
                    posy-=h;mirada=3;
                    pos();
                }
                /*der*/
                else if(keypress===39){
                    posx+=15;mirada+=1;dir="R";
                    pos();
                }
                /*down*/
                else if(keypress===40){
                    posy+=h;mirada=3;
                    pos();
                }
                else if(keypress===13){
                    api.getMapa(idsala,function (data){stompClient.send("/topic/juego/mapainit."+idsala,{},JSON.stringify(data));});
                }   
            });
            /*api.getMapa(idsala,mapinitial).then(function(){api.setMapa(idsala,updatem);});*/
            felixinitial();
            
        }
    };
})();

