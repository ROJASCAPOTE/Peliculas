/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author ACER E5
 */
public class Country {
    private int idContry;
    private String country;

    public Country() {
        this.idContry=0;
        this.country="";
    }

    public Country(int idContry, String country) {
        this.idContry = idContry;
        this.country = country;
    }

    public int getIdContry() {
        return idContry;
    }

    public void setIdContry(int idContry) {
        this.idContry = idContry;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    
}
