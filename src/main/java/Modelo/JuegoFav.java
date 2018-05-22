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
public class JuegoFav {

    private String Id;
    private String IdUsuario;
    private String IdJuego;
    private int HorasJugadas;

    public JuegoFav() {
    }

    public JuegoFav(String Id, String IdUsuario, String IdJuego, int HorasJugadas) {
        this.Id = Id;
        this.IdUsuario = IdUsuario;
        this.IdJuego = IdJuego;
        this.HorasJugadas = HorasJugadas;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
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

    public int getHorasJugadas() {
        return HorasJugadas;
    }

    public void setHorasJugadas(int HorasJugadas) {
        this.HorasJugadas = HorasJugadas;
    }

}
