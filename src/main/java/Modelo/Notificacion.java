/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author willy
 */
public class Notificacion {

    private String Id;
    private String IdUsurario;
    private String RecomendacionJuego;
    private String RecomendacionAmigo;
    private String Noticia;
    private String Solicitud;

    public Notificacion(){
    }
    
    public Notificacion(String Id, String IdUsurario, String RecomendacionJuego, String RecomendacionAmigo, String Noticia, String Solicitud) {
        this.Id = Id;
        this.IdUsurario = IdUsurario;
        this.RecomendacionJuego = RecomendacionJuego;
        this.RecomendacionAmigo = RecomendacionAmigo;
        this.Noticia = Noticia;
        this.Solicitud = Solicitud;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getIdUsurario() {
        return IdUsurario;
    }

    public void setIdUsurario(String IdUsurario) {
        this.IdUsurario = IdUsurario;
    }

    public String getRecomendacionJuego() {
        return RecomendacionJuego;
    }

    public void setRecomendacionJuego(String RecomendacionJuego) {
        this.RecomendacionJuego = RecomendacionJuego;
    }

    public String getRecomendacionAmigo() {
        return RecomendacionAmigo;
    }

    public void setRecomendacionAmigo(String RecomendacionAmigo) {
        this.RecomendacionAmigo = RecomendacionAmigo;
    }

    public String getNoticia() {
        return Noticia;
    }

    public void setNoticia(String Noticia) {
        this.Noticia = Noticia;
    }

    public String getSolicitud() {
        return Solicitud;
    }

    public void setSolicitud(String Solicitud) {
        this.Solicitud = Solicitud;
    }
    
    
}
