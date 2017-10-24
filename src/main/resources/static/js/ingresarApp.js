/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
ingresarApp= (function() {
    
    var username;
    return{
        saveName: function (){
            sessionStorage.setItem('username', document.getElementById('usuarioid').value);
            
        }
    };
})();

$(document).ready(function (){
    $("#login-button").click(function () {
        ingresarApp.saveName();
    });
});