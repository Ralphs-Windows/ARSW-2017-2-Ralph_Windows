/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global connectAndSubscribe*/

var salasApp = (function () {
    var nameuser = null;
    var stompClient = null;
    var connectAndSubscribe = function () {
        console.info('Connecting to WS...');
        var socket = new SockJS("/stompendpoint");
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe("/topic/rooms", function (data) {
                var val=JSON.parse(data.body);
                var idsala= val.map(function (id){
                    return "<tr><td>" + id+ "</td></tr>";
                });
                $("#imagenmenu").append("<table>\n\
                                            <thead>\n\
                                                <tr>\n\
                                                    <th>Identificador de sala</th>\n\
                                                </tr>\n\
                                            </thead>\n\
                                            <tbody>"+idsala+"</tbody>\n\
                                        </table>");
                
            });
            stompClient.subscribe("/topic/room."+"", function (data) {

            });
            stompClient.subscribe("", function (data) {

            });
        });
    };
    return {
        connectSala: function () {
        },
        saveName: function (){
            nameuser = $('#usuario').val();
        },
        getSalas:function (){
            connectAndSubscribe();
        },
        disconnectSala: function () {
            stompClient.send("/app/rooms");
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



