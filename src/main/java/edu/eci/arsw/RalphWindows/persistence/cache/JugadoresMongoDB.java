/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.RalphWindows.persistence.cache;

import edu.eci.arsw.RalphWindows.model.Jugador;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author laura
 */
public interface JugadoresMongoDB extends MongoRepository <Jugador,String>{
    
    public Jugador findByUsername(String id);

    //@Query("{ 'firstname' : ?0 }")
    @Query("{\"score\": {\"$gte\": ?0}}")
    List<Jugador> findByScore(int score);
    
}
