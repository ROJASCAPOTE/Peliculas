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
public interface DAOManager {

    AddressDAO getAddressDAO();

    CountryDAO getCountryDAO();

    RolesDAO gatRlosDAO();

    StaffDAO getStaffDAO();

    StoreDAO getStoreDAO();

    CityDAO getCityDAO();
}
