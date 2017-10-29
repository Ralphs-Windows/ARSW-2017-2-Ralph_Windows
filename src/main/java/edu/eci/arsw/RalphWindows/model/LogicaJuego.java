/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.RalphWindows.model;

import edu.eci.arsw.RalphWindows.persistence.RalphWindowsPersistence;
import edu.eci.arsw.RalphWindows.persistence.RalphWindowsPersistenceException;
import java.util.ArrayList;
import java.util.Collection;
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
    
    public LogicaJuego(int idsala) {
        id=idsala;
        equipos=new ConcurrentHashMap<>();
    }
    
    public ArrayList<Equipo> mover(Felix f){
        Equipo eq;
        if (!equipos.contains(f.getEq())) {
            eq = new Equipo(f.getEq());
            eq.getFelixs().put(f.getNum(), f);
            equipos.put(f.getEq(), eq);
        }else {
            eq=equipos.get(f.getEq());
            if (!eq.getFelixs().containsKey(f.getNum())) {
                eq.getFelixs().put(f.getNum(), f);
            }
        }
        eq.getFelixs().get(f.getNum()).setUbicacion(f.getUbicacion());
        ArrayList temp= new ArrayList<>();
        for(String ide: equipos.keySet()){
            eq=equipos.get(ide);
            for(Integer idf: eq.getFelixs().keySet()){
                temp.add(eq.getFelixs().get(idf));
            }
        }
        return temp;
    }
    public ventana[][] reparar(Felix jg,ventana[][] ventanas) throws RalphWindowsPersistenceException {
        Ubicacion u = jg.getUbicacion();
        //ventana[][] v = rph.getMapajuego(id);
        for (ventana[] ventan: ventanas) {
            for (int j = 0; j < ventan.length; j++) {
                ventana v=ventan[j];
                if (v.getUbicacion().colision(u.getXpos(), u.getYpos(), u.getAncho(), u.getAlto())) {
                    v.setEstado(v.getEstado() - 1);
                    Equipo e = equipos.get(jg.getEq());
                    e.setPuntos(e.getPuntos() + 10);
                }
            }
        }   
        return ventanas;
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
    public ArrayList information(String ideq) {
        ArrayList<Integer> temp=new ArrayList<>();
        Equipo eq=equipos.get(ideq);
        temp.add(eq.getPuntos());
        temp.add(eq.getVida());
        return temp;
    }
    public ConcurrentHashMap<String, Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ConcurrentHashMap<String, Equipo> equipos) {
        this.equipos = equipos;
    }
    
}
