/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global connectAndSubscribe, Stomp, apiclient,ingresarApp */

var api=apiclient;
salasApp = (function () {
    var username;
    var idsala;
    var stompClient;
    function equipo(equipo,num) {
        $("#equipo"+num+" tbody tr").remove();
        var eq = equipo.map(function (dato) {
            return "<tr><td>" + dato.username + "</td></tr>";
        });
        $("#equipo"+num+" tbody ").append(eq);
        
    }
    var connectAndSubscribe = function () {
        console.info('Connecting to WS...');
        var socket = new SockJS("/stompendpoint");
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe("/topic/equipo1."+idsala, function (data) {
                equipo(JSON.parse(data.body),1);
            });
            stompClient.subscribe("/topic/equipo2."+idsala, function (data) {
                equipo(JSON.parse(data.body),2);
            });
            stompClient.subscribe("/topic/juego/"+idsala, function (data) {
                var numj=JSON.parse(data.body);
                if(numj){
                    window.location.href = "SalaJuego.html";
                }
            });
            
        });
        
        
    };
     
    return {
        connectSala: function () {
            username = sessionStorage.getItem('username');
            $("#username1").text("Bienvenido "+username);
            api.getSala(function (sala){
                idsala=sala;
            }).then(function (){
                    api.getEquipo1(idsala,function (data){equipo(data,1);});
                    api.getEquipo2(idsala,function (data){equipo(data,2);});
                    sessionStorage.setItem('idroom',idsala);
                    connectAndSubscribe();
                    }
                );
            
            console.log(username);
        },
        addEquipo1: function () {
            sessionStorage.setItem('eq',"1");
            api.addEquipo1(idsala,username).then(
                    function(){
                        $("#e2").prop('disabled', true);
                        api.getEquipo1(idsala,function (data){sessionStorage.setItem('num',data.length);});
                    });
        },
        addEquipo2: function () {
            sessionStorage.setItem('eq',"2");
            api.addEquipo2(idsala,username).then(
                    function(){
                        $("#e1").prop('disabled', true);
                        api.getEquipo2(idsala,function (data){sessionStorage.setItem('num',data.length);});
                    });
        },
        disconnect: function () {
            if (stompClient !== null) {
                stompClient.disconnect();
                console.log("Disconnected");
            }
        }
    };
})();
$(document).ready(function(){
    $("#e1").click(function () {
        salasApp.addEquipo1();
        
    });
    $("#e2").click(function () {
        salasApp.addEquipo2();
    });
   
});



