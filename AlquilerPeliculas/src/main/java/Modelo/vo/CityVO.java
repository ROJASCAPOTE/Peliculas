/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.vo;

import java.util.Date;

public class CityVO {

    private int idCity;
    private String city;
    private CountryVO countryVO;
    private Date lastUpdate;

    public CityVO() {
        this.idCity = 0;
        this.city = "";
        this.countryVO = null;
        this.lastUpdate = null;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public CountryVO getCountryVO() {
        return countryVO;
    }

    public void setCountryVO(CountryVO countryVO) {
        this.countryVO = countryVO;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return idCity + " - " + city;
    }

}
