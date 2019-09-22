/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

import Modelo.Connection.ConnectionBD;

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
    private CityDAO city;
    private ConnectionBD conn;

    public MYSQLDaoManager(ConnectionBD conn) {
        this.conn = conn;
    }

    @Override
    public AddressDAO getAddressDAO() {
        if (adrress == null) {
            adrress = new AddressDAO(conn);
        }
        return adrress;
    }

    @Override
    public CountryDAO getCountryDAO() {
        if (country == null) {
            country = new CountryDAO(conn);
        }
        return country;
    }

    @Override
    public RolesDAO gatRlosDAO() {
        if (roles == null) {
            roles = new RolesDAO(conn);
        }
        return roles;
    }

    @Override
    public StaffDAO getStaffDAO() {
        if (staff == null) {
            staff = new StaffDAO(conn);
        }
        return staff;
    }

    @Override
    public StoreDAO getStoreDAO() {
        if (store == null) {
            store = new StoreDAO(conn);
        }
        return store;
    }

    @Override
    public CityDAO getCityDAO() {
        if (city == null) {
            city = new CityDAO(conn);
        }
        return city;
    }

}
