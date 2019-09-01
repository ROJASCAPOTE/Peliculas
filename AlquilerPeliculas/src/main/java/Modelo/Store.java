package Modelo;

public class Store {

    private int idManagerStaff;
    private int idAddress;

    public Store() {
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
