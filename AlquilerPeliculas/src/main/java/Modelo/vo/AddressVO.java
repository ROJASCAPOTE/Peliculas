
package Modelo.vo;
public class AddressVO {
    private String address;
    private String address2;
    private String district;
    private int idCity;
    private String codePostal;

    public AddressVO() {
        this.address="";
        this.address2="";
        this.idCity=0;
        this.codePostal="";
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

    @Override
    public String toString() {
        return "AddressVO{" + "address=" + address + ", address2=" + address2 + ", district=" + district + ", idCity=" + idCity + ", codePostal=" + codePostal + '}';
    }
    
}
