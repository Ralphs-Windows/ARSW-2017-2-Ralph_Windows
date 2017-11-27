/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/* global apiclient */

var api=apiclient;
perfilApp = (function () {
    return {
        perfil: function(){
            api.getPerfil(sessionStorage.getItem('username'),function (jugador){
                $("#subtitulo").html("<h1>Mi Perfil</h1>");
                $("#jugador").html("<br><h2>Nombre de usuario: "+jugador.username+"</h2>\n\
                                    <br><h2>Puntaje de usuario: "+jugador.score+"</h2>");
                
            });
        }
    };
})();
$(document).ready(function (){
    perfilApp.perfil();
});