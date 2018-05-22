/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Modelo.CalificacionComentario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author william
 */
public class CalificacionComentarios implements IBaseDatos<CalificacionComentario> {

    private Tx<CalificacionComentario> tx;

    public CalificacionComentarios() {
        this.tx = new Tx();
    }

    @Override
    public List<CalificacionComentario> findAll() {
        CalificacionComentario c= new CalificacionComentario(null,-1,-1);
        ArrayList<CalificacionComentario> est = tx.Select(c);
        return est;
    }

    @Override
    public boolean insert(CalificacionComentario a) {
        boolean r = false;
        r = tx.insert(a);
        return r;
    }

    @Override
    public boolean update(CalificacionComentario a) {
        boolean r = false;
        CalificacionComentario c= new CalificacionComentario(a.getNickname(),a.getIdComentario(),-1);
        r = tx.update(a, c);
        return r;
    }

    @Override
    public boolean delete(CalificacionComentario t) {
        boolean r = false;
        r = tx.delete(t);
        return r;
    }
    
    public List<CalificacionComentario> find(String nick, int idcomentario) {
        CalificacionComentario c= new CalificacionComentario(nick,idcomentario,-1);
        ArrayList<CalificacionComentario> est = tx.Select(c);
        return est;
    }

    
    public int Likes(int id) {
        CalificacionComentario c= new CalificacionComentario(null,id,-1);
        ArrayList<CalificacionComentario> est = tx.Select(c);
        int j=0;
        for (int i = 0; i < est.size(); i++) {
            if(est.get(i).getCalificacion()==1){
                j++;
            }
        }
        return j;
    }
    
    public int NoLikes(int id) {
        CalificacionComentario c= new CalificacionComentario(null,id,-1);
        ArrayList<CalificacionComentario> est = tx.Select(c);
        int j=0;
        for (int i = 0; i < est.size(); i++) {
            if(est.get(i).getCalificacion()==0){
                j++;
            }
        }
        return j;
    }
    
}
