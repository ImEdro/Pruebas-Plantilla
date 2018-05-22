/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Modelo.Amigo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author willy
 */
public class Amigos implements IBaseDatos<Amigo> {

    private Tx<Amigo> tx;

    public Amigos() {
        this.tx = new Tx();
    }

    @Override
    public List<Amigo> findAll() {
        Amigo a = new Amigo(null, null, null);
        ArrayList<Amigo> est = tx.Select(a);
        return est;
    }

    @Override
    public boolean insert(Amigo a) {
        boolean r = false;
        r = tx.insert(a);
        return r;
    }

    @Override
    public boolean update(Amigo a) {
        boolean r = false;
        Amigo a2 = new Amigo(a.getId(), null, null);
        r = tx.update(a, a2);
        return r;
    }

    @Override
    public boolean delete(Amigo t) {
        boolean r = false;
        r = tx.delete(t);
        return r;
    }
    
    public List<Amigo> findByIdUsuario(String id) {
        Amigo a = new Amigo(null, id, null);
        ArrayList<Amigo> est = tx.Select(a);
        return est;
    }
    
    public Amigo findamigos(String id,String id2) {
        Amigo a = new Amigo(null, id, id2);
        ArrayList<Amigo> est = tx.Select(a);
        if(est.size()!=0){
            return est.get(0);
        }
        return null;
    }
}
