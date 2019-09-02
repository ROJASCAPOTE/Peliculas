package Modelo.vo;

public class StoreVO {

    private int idManagerStaff;
    private int idAddress;

    public StoreVO() {
        this.idManagerStaff = 0;
        this.idAddress = 0;
    }

    public int getIdManagerStaff() {
        return idManagerStaff;
    }

    public void setIdManagerStaff(int idManagerStaff) {
        this.idManagerStaff = idManagerStaff;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }
}
