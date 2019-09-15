/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

/**
 *
 * @author ACER E5
 */
public class MYSQLDaoManager implements DAOManager {

    private AddressDAO adrress;
    private CountryDAO country;
    private RolesDAO roles;
    private StaffDAO staff;
    private StoreDAO store;

    @Override
    public AddressDAO getAddressDAO() {
        if (adrress == null) {
            adrress = new AddressDAO();
        }
        return adrress;
    }

    @Override
    public CountryDAO getCountryDAO() {
        if (country == null) {
            country = new CountryDAO();
        }
        return country;
    }

    @Override
    public RolesDAO gatRlosDAO() {
        if (roles == null) {
            roles = new RolesDAO();
        }
        return roles;
    }

    @Override
    public StaffDAO getStaffDAO() {
        if (staff == null) {
            staff = new StaffDAO();
        }
        return staff;
    }

    @Override
    public StoreDAO getStoreDAO() {
        if (store == null) {
            store = new StoreDAO();
        }
        return store;
    }

}
