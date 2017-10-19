/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

apiclient= (function() {
    return{
        getMapa: function (callback){
           var getpromise = $.get("/juego/mapaJuego",callback);
            getpromise.then(
                    function () {
                        console.info("OK getMapajuego");
                        
                    },
                    function () {
                        alert("Error getMapajuego");
                    }
            );
            return getpromise;
        }
    };
})();