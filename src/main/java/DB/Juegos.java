/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Modelo.Juego;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author willy
 */
public class Juegos implements IBaseDatos<Juego> {

    private Tx<Juego> tx;

    public Juegos() {
        this.tx = new Tx();
    }

    @Override
    public List<Juego> findAll() {
        Juego u = new Juego(null, null, null, null, null, null, null, null, null,null);
        ArrayList<Juego> est = tx.Select(u);
        return est;
    }

    @Override
    public boolean insert(Juego a) {
        boolean r = false;
        r = tx.insert(a);
        return r;
    }

    @Override
    public boolean update(Juego a) {
        boolean r = false;
        Juego u = new Juego(a.getId(), null, null, null, null, null, null, null, null,null);
        r = tx.update(a, u);
        return r;
    }

    @Override
    public boolean delete(Juego t) {
        boolean r = false;
        r = tx.delete(t);
        return r;
    }
    
    public List<Juego> top(){
        Juego juego = new Juego(null, null, null, null, null, null, null, null, null,null);
        ArrayList<Juego> top = tx.Select(juego);
        for (int i = 0; i < top.size(); i++) {
            Juego min = top.get(i);
            for (int j = 0; j < top.size(); j++) {
                Double t=Double.parseDouble(top.get(j).getCalificacion().trim());
                Double m=Double.parseDouble(min.getCalificacion().trim());
                if (t<m) {
                    top.set(i, top.get(j));
                    top.set(j, min);
                    min = top.get(i);
                }
            }
        }
        return top;
    }

     public List<Juego> findbyId(String id) {
        Juego u = new Juego(id, null, null, null, null, null, null, null, null,null);
        ArrayList<Juego> est = tx.Select(u);
         System.out.println(est.get(0).getImagen());
        return est;
    }

}
