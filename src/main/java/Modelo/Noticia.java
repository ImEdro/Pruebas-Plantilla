/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Oscar
 */
public class Noticia {
    
    private String Id;
    private String Titulo;
    private String Texto;
    private String Imagen;
    
    
    public Noticia() {
        
    }
    
    public Noticia(String Id, String Titulo, String Texto,String Imagen) {
        this.Id = Id;
        this.Titulo = Titulo;
        this.Texto = Texto;
        this.Imagen = Imagen;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String Texto) {
        this.Texto = Texto;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }


};