/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.RalphWindows.model;

import edu.eci.arsw.RalphWindows.persistence.RalphWindowsPersistence;
import edu.eci.arsw.RalphWindows.persistence.RalphWindowsPersistenceException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author laura
 */
public class LogicaJuego {
    private final int id;
    private ConcurrentHashMap<String,Equipo> equipos;
    @Autowired
    RalphWindowsPersistence rph;
    
    public LogicaJuego(int idsala,String eq1,String eq2) {
        id=idsala;
        equipos=new ConcurrentHashMap<>();
        Equipo e1=new Equipo(eq1);
        Equipo e2=new Equipo(eq2);
        equipos.put(eq1,e1);
        equipos.put(eq2,e2);
    }
    
    public ArrayList<Equipo> mover(Felix jg){
        ArrayList<Equipo> tmp=new ArrayList<>();
        for(String k : equipos.keySet()){
            tmp.add(equipos.get(k));
        }
        return tmp;
    }
    public ventana[][] reparar(Felix jg) throws RalphWindowsPersistenceException {
        Ubicacion u = jg.getUbicacion();
        ventana[][] v = rph.getMapajuego(id);
        for (ventana[] v1 : v) {
            for (int j = 0; j < v1.length; j++) {
                if (v1[j].getUbicacion().colision(u.getXpos(), u.getYpos(), u.getAncho(), u.getAlto())) {
                    v1[j].setEstado(v1[j].getEstado() - 1);
                    Equipo e = equipos.get(jg.getEq());
                    e.setPuntos(e.getPuntos() + 10);
                }
            }
        }   
        return rph.getMapajuego(id);
    }
    public boolean terminar()throws RalphWindowsPersistenceException {
        int cont = 0;
        int nventanas;
        ventana[][] v = rph.getMapajuego(id);
        nventanas = v.length * v[0].length;
        for (ventana[] v1 : v) {
            for (int j = 0; j < v1.length; j++) {
                if (v1[j].getEstado() == 0) {
                    cont += 1;
                }
            }
        }
        return cont == nventanas;
    }
    public ConcurrentHashMap<String, Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ConcurrentHashMap<String, Equipo> equipos) {
        this.equipos = equipos;
    }
    
}
