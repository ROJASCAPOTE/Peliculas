package Modelo.vo;

import java.util.Date;

public class AddressVO {

    private int idAddress;
    private String address;
    private String address2;
    private String district;
    private int idCity;
    private String codePostal;
    private String phone;
    private Date lastUpdate;

    public AddressVO() {
        this.idAddress = 0;
        this.address = "";
        this.address2 = "";
        this.district = "";
        this.idCity = 0;
        this.codePostal = "";
        this.phone = "";
        this.lastUpdate = null;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return address + " - " + district;
    }

}
