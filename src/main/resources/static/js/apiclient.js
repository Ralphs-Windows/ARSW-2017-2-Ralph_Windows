/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

apiclient= (function() {
    return{
        getMapa: function (idsala,callback){
           var getpromise = $.get("/juego/"+idsala+"/mapajuego",callback);
            getpromise.then(
                    function () {
                        console.info("OK getMapajuego");
                        
                    },
                    function () {
                        alert("Error getMapajuego");
                    }
            );
            return getpromise;
        },
        setMapa: function (idsala,v){
            for (var i = 0;i <v.length; i++) {
                for (var j = 0; j < v[i].length; j++) {
                }
            }
            console.log(JSON.stringify(v));
           var putpromise =$.ajax({
                url: "/juego/"+idsala+"/updatemapajuego",
                type: 'PUT',
                data: JSON.stringify(v),
                contentType: "application/json"
            });
            putpromise.then(
                    function () {
                        console.info("OK setMapajuego");
                    },
                    function () {
                        alert("Error setMapajuego");
                    }
            );
            return putpromise;
        },
        getSala:function (callback){ 
            var getpromise = $.get("/juego/Sala",callback);
            getpromise.then(
                    function () {
                        console.info("OK getSalaDisponible");
                        
                    },
                    function () {
                        alert("Error getSalaDisponible");
                    }
            );
            return getpromise;
        },
        getEquipo1:function (idsala,callback){ 
            var getpromise = $.get("/juego/"+idsala+"/equipo1",callback);
            getpromise.then(
                    function () {
                        console.info("OK getEquipo1");
                        
                    },
                    function () {
                        alert("Error getEquipo1");
                    }
            );
            return getpromise;
        },
        getEquipo2:function (idsala,callback){ 
            var getpromise = $.get("/juego/"+idsala+"/equipo2",callback);
            getpromise.then(
                    function () {
                        console.info("OK getEquipo2");
                        
                    },
                    function () {
                        alert("Error getEquipo2");
                    }
            );
            return getpromise;
        },
        addEquipo1:function (idsala,jugador){ 
            var putpromise =$.ajax({
                url: "/juego/"+idsala+"/equipo1",
                type: 'PUT',
                data: JSON.stringify({username:jugador}),
                contentType: "application/json"
            });
            putpromise.then(
                    function () {
                        
                        console.info("OK putEquipo1");
                        
                    },
                    function () {
                        alert("Error putEquipo1");
                    }
            );
            return putpromise;
        },
        addEquipo2:function (idsala,jugador){ 
            var putpromise =$.ajax({
                url: "/juego/"+idsala+"/equipo2",
                type: 'PUT',
                data: JSON.stringify({username:jugador}),
                contentType: "application/json"
            });
            putpromise.then(
                    function () {
                        console.info("OK putEquipo2");
                        
                    },
                    function () {
                        alert("Error putEquipo2");
                    }
            );
            return putpromise;
        }
        
    };
})();