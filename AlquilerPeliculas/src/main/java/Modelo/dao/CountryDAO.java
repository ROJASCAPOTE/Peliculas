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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER E5
 */
public class CountryDAO implements ICountryDAO {

    private ConnectionBD conn;

    CountryDAO(ConnectionBD conn) {
        this.conn = conn;
    }

    @Override
    public int registrar(CountryVO a) {
        int resultado = 0;
        String sql = "INSERT INTO country VALUES(? ,?, ?)";
        PreparedStatement st = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentTime = sdf.format(a.getLastUpdate());
        try {
            st = conn.getConexion().prepareStatement(sql);
            st.setInt(1, a.getIdContry());
            st.setString(2, a.getCountry());
            st.setString(3, currentTime);
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
        List<CountryVO> lista = null;
        String sql = "SELECT * FROM country";
        PreparedStatement st = null;
        try {
            st = conn.getConexion().prepareStatement(sql);
            lista = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CountryVO country = new CountryVO();
                country.setIdContry(rs.getInt(1));
                country.setCountry(rs.getString(2));
                country.setLastUpdate(rs.getDate(3));
                lista.add(country);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
        }

        return lista;

    }

    @Override
    public int getCantidaPaises() {
        String sql = "SELECT count(*) as total FROM country";
        PreparedStatement st = null;
        ResultSet rs = null;
        int numero = 0;
        try {
            st = conn.getConexion().prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                numero = rs.getInt("total") + 1;
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
        }
        return numero;
    }

    @Override
    public void getTableCountry(JTable country) {
        PreparedStatement stmt;
        ResultSet rs;
        String sql = "SELECT country_id, country, Date(last_update)  FROM country";
        try {
            stmt = conn.getConexion().prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                DefaultTableModel modelo = (DefaultTableModel) country.getModel();
                modelo.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3)
                });
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
        }
    }

    @Override
    public CountryVO obtener(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
