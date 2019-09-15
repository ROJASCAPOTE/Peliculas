/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

import Modelo.Connection.ConnectionBD;
import Modelo.vo.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER E5
 */
public class StoreDAO extends ConnectionBD {

    private DefaultTableModel tablemodel = new DefaultTableModel();

    public DefaultTableModel getTableAddress() {
        int registros = 0;
        Statement stmt = null;
        String[] columNames = {"ID", "Address", "Address 2 ", "District", "City", "Postal code", "Phone"};
        //obtenemos la cantidad de registros existentes en la tabla y se almacena en la variable "registros"
        try {
            stmt = this.getConexion().createStatement();
            String sql = "SELECT count(*) as total FROM address";
            ResultSet cantidad = stmt.executeQuery(sql);
            cantidad.next();
            registros = cantidad.getInt("total");
            stmt.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        //se crea una matriz con tantas filas y columnas que necesite
        Object[][] data = new String[registros][7];
        try {
            stmt = this.getConexion().createStatement();
            String sql2 = "SELECT a.address_id, a.address, a.address2, a.district, c.city, a.postal_code, a.phone  FROM address as a inner join city as c on (a.city_id = c.city_id)";
            ResultSet res = stmt.executeQuery(sql2);
            int i = 0;
            while (res.next()) {
                data[i][0] = res.getString(1);
                data[i][1] = res.getString(2);
                data[i][2] = res.getString(3);
                data[i][3] = res.getString(4);
                data[i][4] = res.getString(5);
                data[i][5] = res.getString(6);
                data[i][6] = res.getString(7);
                i++;
            }
            stmt.close();
            this.tablemodel.setDataVector(data, columNames);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return this.tablemodel;
    }

    public DefaultTableModel obtenerDireccion(String direccion) {
        String sq1 = "SELECT count(*) FROM address as a inner join city as c on (a.city_id = c.city_id) "
                + " WHERE address='" + direccion + "'";

        String sql2 = "SELECT a.address_id, a.address, a.address2, a.district, c.city, a.postal_code, a.phone"
                + " FROM address as a inner join city as c on (a.city_id = c.city_id)  WHERE  address like '%" + direccion + "%'";

        int registros = 0;
        Statement stmt = null;
        String[] columNames = {"ID", "Address", "Address 2 ", "District", "City", "Postal code", "Phone"};
        try {
            stmt = this.getConexion().createStatement();
            String sql = "SELECT count(*) as total FROM address";
            ResultSet cantidad = stmt.executeQuery(sql);
            cantidad.next();
            registros = cantidad.getInt("total");
            stmt.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        //se crea una matriz con tantas filas y columnas que necesite
        Object[][] data = new String[registros][7];
        try {
            stmt = this.getConexion().createStatement();
            ResultSet respuesta = stmt.executeQuery(sql2);
            int i = 0;
            while (respuesta.next()) {
                data[i][0] = respuesta.getString(1);
                data[i][1] = respuesta.getString(2);
                data[i][2] = respuesta.getString(3);
                data[i][3] = respuesta.getString(4);
                data[i][4] = respuesta.getString(5);
                data[i][5] = respuesta.getString(6);
                data[i][6] = respuesta.getString(7);
                i++;
            }
            stmt.close();
            this.tablemodel.setDataVector(data, columNames);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return this.tablemodel;
    }
    
}
