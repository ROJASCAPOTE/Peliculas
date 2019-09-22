/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

import Modelo.Connection.ConnectionBD;
import Modelo.idao.ICityDAO;
import Modelo.vo.CityVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER E5
 */
public class CityDAO implements ICityDAO {

    private ConnectionBD conn;

    public CityDAO(ConnectionBD conn) {
        this.conn = conn;
    }

    @Override
    public int registrar(CityVO a) {
        int resultado = 0;
        String sql = "INSERT INTO city VALUES(? ,?, ?, ?)";
        PreparedStatement st = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentTime = sdf.format(a.getLastUpdate());
        try {
            st = conn.getConexion().prepareStatement(sql);
            st.setInt(1, a.getIdCity());
            st.setString(2, a.getCity());
            st.setInt(3, a.getCountryVO().getIdContry());
            st.setString(4, currentTime);
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
    public int actualizar(CityVO a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(CityVO a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CityVO> obtenerTodos() {
        List<CityVO> lista = null;
        String sql = "SELECT city_id, city FROM city";
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.getConexion().prepareStatement(sql);
            lista = new ArrayList<>();
            rs = st.executeQuery();
            while (rs.next()) {
                CityVO cityVO = new CityVO();
                cityVO.setIdCity(Integer.parseInt(rs.getString(1)));
                cityVO.setCity(rs.getString(2));
                lista.add(cityVO);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
        }

        return lista;
    }

    @Override
    public int getCantidadCity() {
        String sql = "SELECT count(*) as total FROM city";
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
    public CityVO obtener(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[][] getTableCity() {
        int registros = 0;
        String sql = "SELECT city_id, city, country_id, Date(last_update) FROM city ";
        String cantidad = "Select count(*) as total from city ";

        try {
            PreparedStatement pstm = conn.getConexion().prepareStatement(cantidad);
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        Object[][] data = new String[registros][4];
        int i = 0;
        try {
            PreparedStatement pst = conn.getConexion().prepareStatement(sql);
            ResultSet resp = pst.executeQuery();
            while (resp.next()) {
                data[i][0] = resp.getString(1);
                data[i][1] = resp.getString(2);
                data[i][2] = resp.getString(3);
                data[i][3] = resp.getString(4);
                i++;
            }
            resp.close();
            pst.close();
        } catch (SQLException e) {
        }
        return data;
    }

}
