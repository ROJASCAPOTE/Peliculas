/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

import Modelo.Connection.Connection;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER E5
 */
public class StaffDAO extends Connection{
    private DefaultTableModel tablemodel = new DefaultTableModel();
    
//    public DefaultTableModel getTableStaff(JTable table){
//        int registros = 0;
//        Statement stmt = null;
//        String[] columNames = {"ID", "Firts Name ", "Last Name", "Address", "Email", "Store", "Phone"};
//    }
}
