/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author willy
 */
public class Usuarios implements IBaseDatos<Usuario> {

    private Tx<Usuario> tx;

    public Usuarios() {
        this.tx = new Tx();
    }

    @Override
    public List<Usuario> findAll() {
        Usuario u = new Usuario(null, null, null, null, null, null, null, null, null, null, null, null, null);
        ArrayList<Usuario> est = tx.Select(u);
        return est;
    }

    @Override
    public boolean insert(Usuario a) {
        boolean r = false;
        r = tx.insert(a);
        return r;
    }

    @Override
    public boolean update(Usuario a) {
        boolean r = false;
       Usuario u = new Usuario(a.getNickname(), null, null, null, null, null, null, null, null, null, null, null, null);
        r = tx.update(a, u);
        return r;
    }

    @Override
    public boolean delete(Usuario t) {
        boolean r = false;
        r = tx.delete(t);
        return r;
    }
    
    public Usuario buscar(String email, String cont) {
        Usuario e = null;
        Usuario u = new Usuario( null, null, email, cont, null, null, null, null, null, null, null, null, null);
        ArrayList<Usuario> est = tx.Select(u);
        if (est.size() != 0) {
            e = est.get(0);
        }
        return e;
    }
    
    public Usuario buscar2(String email) {
       Usuario e = null;
        Usuario u = new Usuario( null, null, email, null, null, null, null, null, null, null, null, null, null);
        ArrayList<Usuario> est = tx.Select(u);
        if (est.size() != 0) {
            e = est.get(0);
        }
        return e;
    }
    
     public Usuario FindById(String id) {
       Usuario e = null;
        Usuario u = new Usuario(id, null, null, null, null, null, null, null, null, null, null, null, null);
        ArrayList<Usuario> est = tx.Select(u);
        if (est.size() != 0) {
            e = est.get(0);
        }
        return e;
    }
    
    public boolean isAcountExists(String usuario, String password){
         System.out.println("2u: "+ usuario +" c: "+password);
        Usuario us = buscar(usuario, password);
        if (us != null) {
            return true;
        }
        return false;
    }

    //Metodo para consultar si el email recibido ya esta registrado
    public boolean isEmailRegistered(String usuario) {
        Usuario us = buscar2(usuario);
        if (us != null) {
            return true;
        }
        return false;
    }
    
    //crear Usuario Nuevo
    public boolean createUsuario(String nick,String nombre,String email,String pass){  
        Usuario u = new Usuario( nick, nombre, email, pass, null,null, null, null, null, null, null, null, null);
        if(!insert(u)){
            return false;
        }
        return true;
    }
    
}
