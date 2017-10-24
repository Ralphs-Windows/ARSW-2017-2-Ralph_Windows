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
    var connectAndSubscribe = function () {
        console.info('Connecting to WS...');
        var socket = new SockJS("/stompendpoint");
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe("/topic/"+idsala+"/equipos", function (data) {
                var equipos=JSON.parse(data.body);
                $("#menutable2 table tbody tr").remove();
                var eq=equipos[0].map(function (dato){
                    return "<tr><td>"+dato.username+"</td><td></td></tr>"
                });
                $("#menutable2 table tbody").append(eq);
                var eq=equipos[1].map(function (dato){
                    return "<tr><td></td><td>"+dato.username+"</td></tr>"
                });
                $("#menutable2 table tbody ").append(eq);
                
            });
            stompClient.subscribe("/topic/room."+idsala, function (data) {
                var val=JSON.parse(data.body);
                var idsala= val.map(function (usuario){
                    return "<tr><td>" + usuario+ "</td></tr>";
                });
                $("#menutable2 table tbody tr").remove();
                $("#menutable2 table tbody").append(idsala);
            });
            
        });
        
        
    };
     
    return {
        connectSala: function () {
            username = sessionStorage.getItem('username');
            api.getSala(function (sala){
                idsala=sala;
                connectAndSubscribe();
            })
            console.log(username);
        },
        addEquipo1: function () {
            api.addEquipo1(idsala,username);
        },
        addEquipo2: function () {
            api.addEquipo2(idsala,username);
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
        /*$(this).prop('disabled', true);*/
        
    });
    $("#e2").click(function () {
        salasApp.addEquipo2();
        /*$(this).prop('disabled', true);*/
    });
   
});



