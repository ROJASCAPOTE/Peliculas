/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

import Modelo.Connection.ConnectionBD;
import Modelo.idao.IStoreDAO;
import Modelo.vo.StoreVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER E5
 */
public class StoreDAO implements IStoreDAO {

    private DefaultTableModel tablemodel = new DefaultTableModel();

    private ConnectionBD conn;

    public StoreDAO(ConnectionBD conn) {
        this.conn = conn;
    }

    @Override
    public int grtCodigoStore() {
        String sql = "SELECT count(*) as total FROM store";
        PreparedStatement st = null;
        int cant = 0;
        try {
            st = conn.getConexion().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                cant = rs.getInt("total") + 1;
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
        }
        return cant;
    }

    @Override
    public int registrar(StoreVO a) {
        return 0;
    }

    @Override
    public int actualizar(StoreVO a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(StoreVO a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<StoreVO> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StoreVO obtener(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
