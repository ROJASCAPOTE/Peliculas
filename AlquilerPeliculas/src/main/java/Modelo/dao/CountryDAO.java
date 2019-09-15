/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

import Modelo.Connection.ConnectionBD;
import Modelo.idao.ICountryDAO;
import Modelo.vo.CountryVO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER E5
 */
public class CountryDAO extends ConnectionBD implements ICountryDAO {

    

    @Override
    public int registrar(CountryVO a) {
        int resultado = 0;
        String sql = "INSERT INTO country(country, lastupdate) VALUES(? ,?)";
        PreparedStatement st = null;
        java.sql.Date lastUpdate;
        try {
            this.conectar();
            st = this.conexion.prepareStatement(sql);
            st.setString(1, a.getCountry());
            
            st.executeUpdate();
            resultado = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código :" + ex.getErrorCode()
                    + "\n " + ex.getMessage());
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Código :" + ex.getErrorCode()
                        + "\n " + ex.getMessage());
            }
            this.cerrar();
        }
        return resultado;
    }

    @Override
    public int actualizar(CountryVO a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(CountryVO a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CountryVO> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
