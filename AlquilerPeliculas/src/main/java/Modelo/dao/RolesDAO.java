/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

import Modelo.vo.RolVO;
import Modelo.Connection.ConnectionBD;
import Modelo.idao.IRolesDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class RolesDAO extends ConnectionBD implements IRolesDao {

    @Override
    public int registrar(RolVO rol) {
        int resultado = 0;
        String sql = "INSERT INTO rol(nomCorto, descripcion) VALUES(? ,?)";
        PreparedStatement st = null;
        try {
            this.conectar();
            st = this.conexion.prepareStatement(sql);
            st.setString(1, rol.getNomCorto());
            st.setString(2, rol.getDescripcion());
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
    public int actualizar(RolVO rol) {
        int resultado = 0;
        String sql = "UPDATE rol SET nomCorto, descripcion WHERE idRol=?";
        PreparedStatement st = null;
        try {
            this.conectar();
            st = this.conexion.prepareStatement(sql);
            st.setInt(1, rol.getIdRol());
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
    public int eliminar(RolVO rol) {
        int resultado = 0;
        String sql = "DELETE FROM rol WHERE idRol=?";
        PreparedStatement st = null;
        try {
            this.conectar();
            st = this.conexion.prepareStatement(sql);
            st.setInt(1, rol.getIdRol());
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
    public List<RolVO> obtenerTodos() {
        List<RolVO> lista = null;
        String sql = "SELECT * FROM rol";
        PreparedStatement st = null;
        try {
            this.conectar();
            st = this.conexion.prepareStatement(sql);
            lista = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                RolVO rol = new RolVO();
                rol.setIdRol(rs.getInt(1));
                rol.setNomCorto(rs.getString(2));
                rol.setDescripcion(rs.getString(3));
                lista.add(rol);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
        }

        return lista;
    }

}
