/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

import Modelo.Connection.Connection;
import Modelo.vo.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ACER E5
 */
public class StoreDAO extends Connection {

    public ArrayList<AddressVO> consultListStore() {
        ArrayList<AddressVO> addressList = new ArrayList<>();
        Statement stmt = null;
        AddressVO addressVO;
        try {
            stmt = this.getConexion().createStatement();
            String sql = "SELECT * FROM address";
            ResultSet resultado = stmt.executeQuery(sql);

            while (resultado.next()) {
                addressVO = new AddressVO();
                addressVO.setIdAddress(resultado.getInt("address_id"));
                addressVO.setAddress(resultado.getString("address"));
                addressVO.setAddress2(resultado.getString("address2"));
                addressVO.setDistrict(resultado.getString("district"));
                addressVO.setIdCity(resultado.getInt("city_id"));
                addressVO.setCodePostal(resultado.getString("postal_code"));
                addressVO.setPhone(resultado.getString("phone"));
                addressList.add(addressVO);
            }

        } catch (Exception e) {
            System.out.println("Error en la consulta de address: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {

            }
        }
        return addressList;
    }
}
