/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

import Modelo.Connection.ConnectionBD;
import Modelo.idao.IStaffDAO;
import Modelo.vo.StaffVO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER E5
 */
public class StaffDAO implements IStaffDAO {

    private ConnectionBD conn;

    StaffDAO(ConnectionBD conn) {
        this.conn = conn;
    }

    @Override
    public int grtCodigo() {
        String sql = "SELECT count(*) as total FROM staff";
        PreparedStatement st = null;
        int numero = 0;
        try {
            st = conn.getConexion().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
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
    public int registrar(StaffVO a) {
        int resultado = 0;
        String sql = "INSERT INTO staff(first_name, last_name, address_id, picture, email, store_id, active, username, password, last_update) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement st = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentTime = sdf.format(a.getLastUpdate());
        FileInputStream fis = null;
        try {
            st = conn.getConexion().prepareStatement(sql);
            st.setString(1, a.getFirstName());
            st.setString(2, a.getLastName());
            st.setInt(3, a.getIdAddress());
            File file = new File(a.getRuta());
            fis = new FileInputStream(file);
            st.setBinaryStream(4, fis, (long) file.length());
            st.setString(5, a.getEmail());
            st.setInt(6, a.getIdStore());
            st.setBoolean(7, a.isActive());
            st.setString(8, a.getUsername());
            st.setString(9, a.getPassword());
            st.setString(10, currentTime);
            st.executeUpdate();
            resultado = 1;
        } catch (FileNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código :"
                    + "\n " + ex.getMessage());
            System.out.println("Modelo.dao.StaffDAO.registrar()" + ex.getMessage());
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
    public int actualizar(StaffVO a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(StaffVO a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<StaffVO> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    RolVO convertir(ResultSet rs) throws SQLException {
//        int idRol = rs.getInt(1);
//        String nombreCorto = rs.getString(2);
//        String descripcion = rs.getString(3);
//        RolVO p = new RolVO(idRol, nombreCorto, descripcion);
//        return p;
//
//    }
//
//    public List<RolVO> obtenerTodos() {
//        con.conectar();
//        Statement stmt = null;
//        List<RolVO> listRol = new ArrayList<>();
//        String sql = "SELECT * FROM rol";
//        try {
//            stmt = con.getConexion().createStatement();
//            ResultSet resultado = stmt.executeQuery(sql);
//            while (resultado.next()) {
//                listRol.add(convertir(resultado));
//            }
//        } catch (SQLException ex) {
//
//        } finally {
//            try {
//                if (stmt != null) {
//                    stmt.close();
//                }
//            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null, "Código :" + ex.getErrorCode()
//                        + "\n " + ex.getMessage());
//            }
//            if (con.getConexion() != null) {
//                con.desconectar();
//            }
//        }
//        return listRol;
//    }
    @Override
    public StaffVO obtener(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
