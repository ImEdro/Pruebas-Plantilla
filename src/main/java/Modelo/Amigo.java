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
public class Amigo {

    private String Id;
    private String IdUser1;
    private String IdUser2;

    public Amigo(){
    }

    public Amigo(String Id, String IdUser1, String IdUser2) {
        this.Id = Id;
        this.IdUser1 = IdUser1;
        this.IdUser2 = IdUser2;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getIdUser1() {
        return IdUser1;
    }

    public void setIdUser1(String IdUser1) {
        this.IdUser1 = IdUser1;
    }

    public String getIdUser2() {
        return IdUser2;
    }

    public void setIdUser2(String IdUser2) {
        this.IdUser2 = IdUser2;
    }
    
}
