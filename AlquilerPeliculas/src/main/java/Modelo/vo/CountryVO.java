/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.vo;

import java.util.Date;

/**
 *
 * @author ACER E5
 */
public class CountryVO {

    private int idContry;
    private String country;
    private Date lastUpdate;

    public CountryVO() {
        this.idContry = 0;
        this.country = "";
        this.lastUpdate = null;
    }

    public CountryVO(int idContry, String country, Date lastUpdate) {
        this.idContry = idContry;
        this.country = country;
        this.lastUpdate = lastUpdate;
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

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return  country;
    }

}
