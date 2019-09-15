/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER E5
 */
public class ConnectionBD {

    /* DATOS PARA LA CONEXION */
    /**
     * base de datos por defecto es test
     */
    private String db = "sakila";
    /**
     * usuario
     */
    private String user = "root";
    /**
     * contraseña de MySql
     */
    private String password = "12345";
    /**
     * Cadena de conexion
     */
    private String url = "jdbc:mysql://localhost3306/" + db;
    /**
     * variable para trabajar con la conexion a la base de datos
     */
    protected Connection conexion;

    private Statement sentencia;
    private ResultSet resultado;

    /**
     * Constructor de clase
     */
    public ConnectionBD() {

    }

    public boolean conectar() {
        boolean conectado = false;
        this.url = "jdbc:mysql://localhost:3306/" + this.db + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(this.url, this.user, this.password);
            conectado = true;
            System.out.println("Clase conexión: conexión exitosa");
            sentencia = conexion.createStatement();
            if (conexion != null) {
                System.out.println("OK base de datos " + this.db + " listo");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return conectado;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void cerrar() {
        if (conexion != null) {
            try {
                if (conexion.isClosed()) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean desconectar() {
        boolean desconecta = false;
        try {
            conexion.close();
            desconecta = true;
            System.out.println("Clase conexión: desconexión exitosa");
        } catch (SQLException e) {
            System.out.println("Error en método desconectar: " + e.getMessage());
        }
        return desconecta;
    }

    public ResultSet RealizarConsulta(String query) {
        try {
            resultado = sentencia.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error en RealizarConsulta: " + e.getMessage());
        }
        return resultado;
    }

    public void IngresarDatos(String query) {
        try {
            sentencia.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Error en IngresarDatos: " + e.getMessage());
        }
    }

    public boolean agregarDatosBD(String query) {

        boolean realizado;
        try {
            realizado = true;
            sentencia.executeLargeUpdate(query);
        } catch (SQLException e) {
            realizado = false;
            JOptionPane.showMessageDialog(null, e.getMessage().substring(26, 76), "Error", JOptionPane.ERROR_MESSAGE);
            //System.out.println(e.getMessage().substring(26,76));
        }
        return realizado;
    }

    public boolean eliminarDatos(String query) {
        boolean eliminado;
        try {
            sentencia.execute(query);
            eliminado = true;
        } catch (SQLException e) {
            eliminado = false;
            System.out.println(e.getMessage().substring(26, 32));
        }
        return eliminado;
    }

    public boolean actualizarDatos(String query) {
        boolean realizado;
        try {
            sentencia.execute(query);
            realizado = true;
        } catch (SQLException e) {
            realizado = false;
            System.out.println(e.getMessage());
        }
        return realizado;
    }

}
