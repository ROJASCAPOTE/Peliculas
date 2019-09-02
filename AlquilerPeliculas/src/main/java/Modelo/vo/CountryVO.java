/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.vo;

/**
 *
 * @author ACER E5
 */
public class CountryVO {
    private int idContry;
    private String country;

    public CountryVO() {
        this.idContry=0;
        this.country="";
    }

    public CountryVO(int idContry, String country) {
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
