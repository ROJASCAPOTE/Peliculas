/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

import Modelo.Connection.ConnectionBD;
import Modelo.idao.IAddressDAO;
import Modelo.vo.AddressVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class AddressDAO implements IAddressDAO {

    private ConnectionBD conn;

    AddressDAO(ConnectionBD conn) {
        this.conn = conn;
    }

    @Override
    public int registrar(AddressVO a) {
        int resultado = 0;
        String sql = "INSERT INTO  address(address, address2, district, city_id, postal_code, phone, last_update) VALUES(?,?,?,?,?,?,?)";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentTime = sdf.format(a.getLastUpdate());
        PreparedStatement st = null;
        try {
            st = conn.getConexion().prepareStatement(sql);
            st.setString(1, a.getAddress());
            st.setString(2, a.getAddress2());
            st.setString(3, a.getDistrict());
            st.setInt(4, a.getIdCity());
            st.setString(5, a.getCodePostal());
            st.setString(6, a.getPhone());
            st.setString(7, currentTime);
            st.executeUpdate();
            resultado = 1;
        } catch (SQLException ex) {
            System.out.println("Modelo.dao.AddressDAO.registrar()" + ex.getLocalizedMessage());
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
    public int actualizar(AddressVO a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(AddressVO a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AddressVO> obtenerTodos() {
        List<AddressVO> lista = null;
        String sql = "SELECT * FROM address";
        PreparedStatement st = null;
        try {
            st = conn.getConexion().prepareStatement(sql);
            lista = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                AddressVO address = new AddressVO();

                lista.add(address);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
        }

        return lista;
    }

    @Override
    public void getTableAddress(JTable address) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AddressVO obtener(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[][] getTableAddress() {
     int registros = 0;
        String sql = "SELECT address_id, address, district, city_id, Date(last_update) FROM address ";
        String cantidad = "Select count(*) as total from address ";

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

        Object[][] data = new String[registros][5];
        int i = 0;
        try {
            PreparedStatement pst = conn.getConexion().prepareStatement(sql);
            ResultSet resp = pst.executeQuery();
            while (resp.next()) {
                data[i][0] = resp.getString(1);
                data[i][1] = resp.getString(2);
                data[i][2] = resp.getString(3);
                data[i][3] = resp.getString(4);
                data[i][4] = resp.getString(5);
                i++;
            }
            resp.close();
            pst.close();
        } catch (SQLException e) {
        }
        return data;
    }

}
