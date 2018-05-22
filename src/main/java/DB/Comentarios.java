/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Modelo.Comentario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author willy
 */
public class Comentarios implements IBaseDatos<Comentario> {

    private Tx<Comentario> tx;

    public Comentarios() {
        this.tx = new Tx();
    }

    @Override
    public List<Comentario> findAll() {
        Comentario c= new Comentario(-1, null, null, null, null, null);
        ArrayList<Comentario> est = tx.Select(c);
        return est;
    }

    @Override
    public boolean insert(Comentario a) {
        boolean r = false;
        r = tx.insert(a);
        return r;
    }

    @Override
    public boolean update(Comentario a) {
        boolean r = false;
       Comentario c= new Comentario(a.getId(), null, null, null, null, null);
        r = tx.update(a, c);
        return r;
    }

    @Override
    public boolean delete(Comentario t) {
        boolean r = false;
        r = tx.delete(t);
        return r;
    }
    
    
     public List<Comentario> findbyIdJuego(String id) {
        Comentario c= new Comentario(-1, null, id, null, null, null);
        ArrayList<Comentario> est = tx.Select(c);
        return est;
    }
    
}