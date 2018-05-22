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
public class Juego {

    private String Id;
    private String Nombre;
    private String Desarrollador;
    private String Calificacion;
    private String FechaLanzamiento;
    private String Descripcion;
    private String Plataforma;
    private String Idiomas;
    private String Genero;
    private String Imagen;

    public Juego() {
    }

    public Juego(String Id, String Nombre, String Desarrollador, String Calificacion, String FechaLanzamiento, String Descripcion, String Plataforma, String Idiomas, String Genero, String Imagen) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Desarrollador = Desarrollador;
        this.Calificacion = Calificacion;
        this.FechaLanzamiento = FechaLanzamiento;
        this.Descripcion = Descripcion;
        this.Plataforma = Plataforma;
        this.Idiomas = Idiomas;
        this.Genero = Genero;
        this.Imagen = Imagen;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        this.Imagen = imagen;
    }

    
    
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDesarrollador() {
        return Desarrollador;
    }

    public void setDesarrollador(String Desarrollador) {
        this.Desarrollador = Desarrollador;
    }

    public String getCalificacion() {
        return Calificacion;
    }

    public void setCalificacion(String Calificacion) {
        this.Calificacion = Calificacion;
    }

    public String getFechaLanzamiento() {
        return FechaLanzamiento;
    }

    public void setFechaLanzamiento(String FechaLanzamiento) {
        this.FechaLanzamiento = FechaLanzamiento;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getPlataforma() {
        return Plataforma;
    }

    public void setPlataforma(String Plataforma) {
        this.Plataforma = Plataforma;
    }

    public String getIdiomas() {
        return Idiomas;
    }

    public void setIdiomas(String Idiomas) {
        this.Idiomas = Idiomas;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

}
