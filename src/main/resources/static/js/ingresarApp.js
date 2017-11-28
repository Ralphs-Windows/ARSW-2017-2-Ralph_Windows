/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global apiclient */

var api=apiclient;
ingresarApp= (function() {
    
    var username;
    
    return{
        registro: function (){
            username=document.getElementById('usuarioid').value;
            if(username!=="" && username!==null){
                api.registerUser(username).then(function(u){
                sessionStorage.setItem('username', document.getElementById('usuarioid').value);
                window.location.href = "menu.html";
            })
            }else{
                Error("Digite un nombre valido: "+username);
            }
        },
        saveName: function (){
            username=document.getElementById('usuarioid').value;
            if(username!=="" && username!==null){
                api.getUser(username,function(u){
                sessionStorage.setItem('username', document.getElementById('usuarioid').value);
                window.location.href = "menu.html";
            });
            }else{
                Error("Digite un nombre valido el nombre digitado es: "+username);
            }
        }
    };
})();

$(document).ready(function (){
    $("#login-button").click(function () {
        ingresarApp.saveName();
    });
    $("#reg-button").click(function () {
        ingresarApp.registro();
    });
});