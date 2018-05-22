/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.arip.websocket.chat;

import java.util.ArrayList;

/**
 *
 * @author william
 */
public class Usuario {
    
    private String username;
    private ArrayList<Message> mensajes;

    public Usuario(String username, ArrayList<Message> mensajes) {
        this.username = username;
        this.mensajes = mensajes;
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<Message> getMensajes() {
        return mensajes;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMensajes(ArrayList<Message> mensajes) {
        this.mensajes = mensajes;
    }
    
    public void addMensaje(Message m){
        this.mensajes.add(m);
    }
    
    
}
