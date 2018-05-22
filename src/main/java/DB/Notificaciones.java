/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Modelo.Notificacion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author willy
 */
public class Notificaciones implements IBaseDatos<Notificacion>{
    
    private Tx<Notificacion> tx;

    public Notificaciones() {
        this.tx = new Tx();
    }

    @Override
    public List<Notificacion> findAll() {
        Notificacion u = new Notificacion(null, null, null, null, null, null);
        ArrayList<Notificacion> est = tx.Select(u);
        return est;
    }

    @Override
    public boolean insert(Notificacion a) {
        boolean r = false;
        r = tx.insert(a);
        return r;
    }

    @Override
    public boolean update(Notificacion a) {
        boolean r = false;
       Notificacion u = new Notificacion(a.getId(), null, null, null, null, null);
        r = tx.update(a, u);
        return r;
    }

    @Override
    public boolean delete(Notificacion t) {
        boolean r = false;
        r = tx.delete(t);
        return r;
    }
    
    
    public List<Notificacion> findByIdUsuario(String id) {
        Notificacion u = new Notificacion(null, id, null, null, null, null);
        ArrayList<Notificacion> est = tx.Select(u);
        return est;
    }
    
    public Notificacion findRepetido(Notificacion n) {
        Notificacion u = new Notificacion(null, n.getIdUsurario(), null, null, null, n.getSolicitud());
        ArrayList<Notificacion> est = tx.Select(u);
        if(est.size()!=0){
            return est.get(0);
        }
        return null;
    }
}
