/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Modelo.CalificacionJuego;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oscar
 */
public class CalificacionJuegos implements IBaseDatos<CalificacionJuego> {

    private Tx<CalificacionJuego> tx;

    public CalificacionJuegos() {
        this.tx = new Tx();
    }

    @Override
    public List<CalificacionJuego> findAll() {
        CalificacionJuego c= new CalificacionJuego(null,-1,-1);
        ArrayList<CalificacionJuego> est = tx.Select(c);
        return est;
    }

    @Override
    public boolean insert(CalificacionJuego a) {
        boolean r = false;
        r = tx.insert(a);
        return r;
    }

    @Override
    public boolean update(CalificacionJuego a) {
        boolean r = false;
        CalificacionJuego c= new CalificacionJuego(a.getNickname(),a.getIdJuego(),-1);
        r = tx.update(a, c);
        return r;
    }

    @Override
    public boolean delete(CalificacionJuego t) {
        boolean r = false;
        r = tx.delete(t);
        return r;
    }
    
    public List<CalificacionJuego> find(String nick, int idcomentario) {
        CalificacionJuego c= new CalificacionJuego(nick,idcomentario,-1);
        ArrayList<CalificacionJuego> est = tx.Select(c);
        return est;
    }

    
    public double Likes(int id) {
        CalificacionJuego c= new CalificacionJuego(null,id,-1);
        ArrayList<CalificacionJuego> est = tx.Select(c);
        int j=0;
        double promedio=0;
        for (int i = 0; i < est.size(); i++) {
            j+=est.get(i).getCalificacion();
            
        }
        
        if(est.size() != 0){
            promedio=(double)j/(est.size());
        }
        
        return promedio;
    }

}
