/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global connectAndSubscribe, Stomp*/

var salasApp = (function () {
    var nameuser = "hola";
    var idroom=null;
    var stompClient = null;
    var suscriberoom=null;
    var connectAndSubscribe = function () {
        console.info('Connecting to WS...');
        var socket = new SockJS("/stompendpoint");
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe("/topic/rooms", function (data) {
                var val=JSON.parse(data.body);
                var idsala= val.map(function (sala){
                    return "<tr><td>" + sala+ "</td>\n\
                            <td><button type='button' onclick=salasApp.connectSala('"+sala+"')>Unirse</td></tr>";
                });
                $("#menutable table tbody tr").remove();
                $("#menutable table tbody").append(idsala);
                
            });
            suscriberoom=stompClient.subscribe("/topic/room."+idroom, function (data) {
                var val=JSON.parse(data.body);
                var idsala= val.map(function (usuario){
                    return "<tr><td>" + usuario+ "</td></tr>";
                });
                $("#menutable2 table tbody tr").remove();
                $("#menutable2 table tbody").append(idsala);
            });
            stompClient.subscribe("", function (data) {

            });
            stompClient.send("/app/rooms");
        });
        
    };
    
            
    return {
        connectSala: function (room) {
           if(idroom!==null){
                if(idroom!==room){
                    $("menutable2 table tbody tr").remove();
                    suscriberoom.unsubscribe(room);
                    idroom=room;
                }
            }else{
                idroom=room;
                connectAndSubscribe().then(stompClient.send("/app/room."+idroom, {}, JSON.stringify(nameuser)));
                
            }
        },
        saveName: function (){
            nameuser = $('#usuario').val();
        },
        getSalas:function (){
            connectAndSubscribe();
        },
        disconnectSala: function () {
            stompClient.send("/app/room."+idroom, {}, JSON.stringify(nameuser));
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
    $("#login-button").click(function () {
        salasApp.saveName();
    });
    $("#l").click(function () {
        salasApp.disconnectSala();
    });
   
});



