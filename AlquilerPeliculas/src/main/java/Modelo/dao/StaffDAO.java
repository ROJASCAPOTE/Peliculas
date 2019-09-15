/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

import Modelo.Connection.ConnectionBD;
import Modelo.idao.IStaffDAO;
import Modelo.vo.StaffVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ACER E5
 */
public class StaffDAO extends ConnectionBD implements IStaffDAO {

    @Override
    public int grtCodigo() {
        String sql = "SELECT count(*) as total FROM staff";
        PreparedStatement st = null;
        int numero = 0;
        try {
            this.conectar();
            st = this.conexion.prepareStatement(sql);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
