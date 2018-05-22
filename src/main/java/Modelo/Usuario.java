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
public class Usuario {

    private String Nickname;
    private String Nombre;
    private String Email;
    private String Password;
    private Date FechaNacimiento;
    private String ExperienciaVideojuegos;
    private String HorasPromedioJuego;
    private String Pais;
    private String PlataformasVideojuegos;
    private String Idiomas;
    private String DiasJuego;
    private String HorarioJuego;
    private String GenerosJuego;

    public Usuario() {
    }

    public Usuario(String Nickname, String Nombre, String Email, String Password, Date FechaNacimiento, String ExperienciaVideojuegos, String HorasPromedioJuego, String Pais, String PlataformasVideojuegos, String Idiomas, String DiasJuego, String HorarioJuego, String GenerosJuego) {
        this.Nickname = Nickname;
        this.Nombre = Nombre;
        this.Email = Email;
        this.Password = Password;
        this.FechaNacimiento = FechaNacimiento;
        this.ExperienciaVideojuegos = ExperienciaVideojuegos;
        this.HorasPromedioJuego = HorasPromedioJuego;
        this.Pais = Pais;
        this.PlataformasVideojuegos = PlataformasVideojuegos;
        this.Idiomas = Idiomas;
        this.DiasJuego = DiasJuego;
        this.HorarioJuego = HorarioJuego;
        this.GenerosJuego = GenerosJuego;
    }

   
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String Nickname) {
        this.Nickname = Nickname;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getExperienciaVideojuegos() {
        return ExperienciaVideojuegos;
    }

    public void setExperienciaVideojuegos(String ExperienciaVideojuegos) {
        this.ExperienciaVideojuegos = ExperienciaVideojuegos;
    }

    public String getHorasPromedioJuego() {
        return HorasPromedioJuego;
    }

    public void setHorasPromedioJuego(String HorasPromedioJuego) {
        this.HorasPromedioJuego = HorasPromedioJuego;
    }

    public String getPlataformasVideojuegos() {
        return PlataformasVideojuegos;
    }

    public void setPlataformasVideojuegos(String PlataformasVideojuegos) {
        this.PlataformasVideojuegos = PlataformasVideojuegos;
    }

    public String getIdiomas() {
        return Idiomas;
    }

    public void setIdiomas(String Idiomas) {
        this.Idiomas = Idiomas;
    }

    public String getDiasJuego() {
        return DiasJuego;
    }

    public void setDiasJuego(String DiasJuego) {
        this.DiasJuego = DiasJuego;
    }

    public String getHorarioJuego() {
        return HorarioJuego;
    }

    public void setHorarioJuego(String HorarioJuego) {
        this.HorarioJuego = HorarioJuego;
    }

    public String getGenerosJuego() {
        return GenerosJuego;
    }

    public void setGenerosJuego(String GenerosJuego) {
        this.GenerosJuego = GenerosJuego;
    }

}
