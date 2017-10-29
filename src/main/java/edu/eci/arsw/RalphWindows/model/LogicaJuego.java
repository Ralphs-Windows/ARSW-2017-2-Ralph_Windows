/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.RalphWindows.model;


import edu.eci.arsw.RalphWindows.persistence.RalphWindowsPersistence;
import edu.eci.arsw.RalphWindows.persistence.RalphWindowsPersistenceException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author laura
 */
@Service
public class LogicaJuego {
    @Autowired
    RalphWindowsPersistence rph=null;
    
    /**
     * 
     */
    public LogicaJuego() {
    }
    /**
     * 
     * @param id
     * @param f
     * @return 
     * @throws edu.eci.arsw.RalphWindows.persistence.RalphWindowsPersistenceException 
     */
    public ArrayList<Equipo> mover(int id,Felix f) throws RalphWindowsPersistenceException{
        Equipo eq;
        SalaJuego s=rph.getSalas(id);
        
        if (!s.getEquipos().contains(f.getEq())) {
            eq = new Equipo(f.getEq());
            eq.getFelixs().put(f.getNum(), f);
            s.getEquipos().put(f.getEq(), eq);
        }else {
            eq=s.getEquipos().get(f.getEq());
            if (!eq.getFelixs().containsKey(f.getNum())) {
                eq.getFelixs().put(f.getNum(), f);
            }
        }
        eq.getFelixs().get(f.getNum()).setUbicacion(f.getUbicacion());
        ArrayList temp= new ArrayList<>();
        for(String ide: s.getEquipos().keySet()){
            eq=s.getEquipos().get(ide);
            for(Integer idf: eq.getFelixs().keySet()){
                temp.add(eq.getFelixs().get(idf));
            }
        }
        return temp;
    }
    /**
     * 
     * @param id
     * @param jg
     * @return 
     * @throws edu.eci.arsw.RalphWindows.persistence.RalphWindowsPersistenceException 
     */
    public ventana[][] reparar(int id,Felix jg) throws RalphWindowsPersistenceException {
        Ubicacion u = jg.getUbicacion();
        SalaJuego s=rph.getSalas(id);
        ventana[][] ventanas = rph.getMapajuego(id).getVentanas();
        for (ventana[] ventan: ventanas) {
            for (int j = 0; j < ventan.length; j++) {
                ventana v=ventan[j];
                if (v.getUbicacion().colision(u.getXpos(), u.getYpos(), u.getAncho(), u.getAlto())) {
                    v.setEstado(v.getEstado() - 1);
                    Equipo e =s.getEquipos().get(jg.getEq());
                    e.setPuntos(e.getPuntos() + 10);
                }
            }
        }   
        return ventanas;
    }
    /**
     * 
     * @param id
     * @return 
     * @throws edu.eci.arsw.RalphWindows.persistence.RalphWindowsPersistenceException 
     */
    public boolean terminar(int id)throws RalphWindowsPersistenceException {
        int cont = 0;
        int nventanas;
        ventana[][] v = rph.getMapajuego(id).getVentanas();
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
    /**
     * 
     * @param id
     * @param ideq
     * @return 
     */
    public ArrayList information(int id,String ideq) throws RalphWindowsPersistenceException {
        SalaJuego s=rph.getSalas(id);
        ArrayList<Integer> temp=new ArrayList<>();
        Equipo eq=s.getEquipos().get(ideq);
        temp.add(eq.getPuntos());
        temp.add(eq.getVida());
        return temp;
    }
    
}
