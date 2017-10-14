/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global connectAndSubscribe, Stomp */


salasApp = (function () {
    var name;
    var connectAndSubscribe = function () {
        console.info('Connecting to WS...');
        var socket = new SockJS('/stomp');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe("", function (data) {
            });
            stompClient.subscribe("", function (data) {

            });
            stompClient.subscribe("", function (data) {

            });
        });
    };
    return {
        connectSala: function () {
            connectAndSubscribe();
        },

        disconnectSala: function () {

        }
    };
    

})();
saveName = function () {
    alert("clic ");
        open("menu.html", "_self");
        // name = $('#usuario').val();
    };
//$(document).ready(function () {
//     $("#login-button").click(function () {
//       salasApp.saveName();
// });
// });



