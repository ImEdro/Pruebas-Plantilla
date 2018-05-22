/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;



/**
 *
 * @author willy
 */
public class Comentario {

    private int Id;
    private String IdUsuario;
    private String IdJuego;
    private String Coment;
    private String Calificacion;
    private Date Fecha;

    public Comentario() {
    }

    public Comentario(int Id, String IdUsuario, String IdJuego, String Coment, String Calificacion, Date Fecha) {
        this.Id = Id;
        this.IdUsuario = IdUsuario;
        this.IdJuego = IdJuego;
        this.Coment = Coment;
        this.Calificacion = Calificacion;
        this.Fecha = Fecha;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(String IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getIdJuego() {
        return IdJuego;
    }

    public void setIdJuego(String IdJuego) {
        this.IdJuego = IdJuego;
    }

    public String getComent() {
        return Coment;
    }

    public void setComent(String Coment) {
        this.Coment = Coment;
    }

    public String getCalificacion() {
        return Calificacion;
    }

    public void setCalificacion(String Calificacion) {
        this.Calificacion = Calificacion;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }
    
    
}
