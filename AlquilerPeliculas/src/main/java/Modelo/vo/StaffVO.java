/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.vo;

import java.util.Date;

public class StaffVO {

    private String firstName;
    private String lastName;
    private int idAddress;
    private String ruta;
    private String email;
    private int idStore;
    private boolean active;
    private String username;
    private String password;
    private int roiId;
    private Date lastUpdate;

    public StaffVO() {
        this.firstName = "";
        this.lastName = "";
        this.idAddress = 0;
        this.ruta = "";
        this.email = "";
        this.idStore = 0;
        this.active = true;
        this.username = "";
        this.password = "";
        this.roiId = 0;
        this.lastUpdate = null;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int idStore) {
        this.idStore = idStore;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoiId() {
        return roiId;
    }

    public void setRoiId(int roiId) {
        this.roiId = roiId;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}
