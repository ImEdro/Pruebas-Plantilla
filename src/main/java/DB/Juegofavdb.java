/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Modelo.JuegoFav;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author willy
 */
public class Juegofavdb implements IBaseDatos<JuegoFav> {

    private Tx<JuegoFav> tx;

    public Juegofavdb() {
        this.tx = new Tx();
    }

    @Override
    public List<JuegoFav> findAll() {
        JuegoFav u = new JuegoFav(null, null, null, -1);
        ArrayList<JuegoFav> est = tx.Select(u);
        return est;
    }

    @Override
    public boolean insert(JuegoFav a) {
        boolean r = false;
        if(!repetido(a)){
        r = tx.insert(a);
        }
        return r;
    }

    @Override
    public boolean update(JuegoFav a) {
        boolean r = false;
        JuegoFav u = new JuegoFav(a.getId(), null, null, -1);
        r = tx.update(a, u);
        return r;
    }

    @Override
    public boolean delete(JuegoFav t) {
        boolean r = false;
        r = tx.delete(t);
        return r;
    }
    

    public List<JuegoFav> findbyidUsuario(String id) {
        JuegoFav u = new JuegoFav(null, id, null, -1);
        ArrayList<JuegoFav> est = tx.Select(u);
        return est;
    }
    
    public boolean repetido(JuegoFav a){
        JuegoFav u = new JuegoFav(null,a.getIdUsuario() , a.getIdJuego(), -1);
        ArrayList<JuegoFav> est = tx.Select(u);
        if(est.size()==0){
            return false;
        }else{
            return true;
        }
        
    }
}
