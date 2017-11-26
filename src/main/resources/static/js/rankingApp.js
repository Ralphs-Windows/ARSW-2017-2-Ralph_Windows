/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global connectAndSubscribe, Stomp, apiclient,ingresarApp */

var api=apiclient;
rankingApp = (function () {
    return {
        getPuntajes: function(){
            api.getPuntajes(function (jugadores){
                alert("entra");
                $("#rank tbody tr").remove();
                var pt = jugadores.map(function (jugador) {
                return "<tr><td>" + jugador.username + "</td><td>" + jugador.score + "</td></tr>";
                });
                $("#rank tbody").append(pt);
            });
        }
    };
})();
