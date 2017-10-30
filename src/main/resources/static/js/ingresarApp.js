/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ingresarApp= (function() {
    
    var username;
    return{
        saveName: function (){
            username=document.getElementById('usuarioid').value;
            if(username!=="" && username!==null){
                sessionStorage.setItem('username', document.getElementById('usuarioid').value);
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
});