/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ACER E5
 */
public class Connection {

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
    private java.sql.Connection conn = null;

    /**
     * Constructor de clase
     */
    public Connection() {
        this.url = "jdbc:mysql://localhost:3306/" + this.db + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        try {
            //obtenemos el driver de para mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtenemos la conexión
            conn = DriverManager.getConnection(this.url, this.user, this.password);
            if (conn != null) {
                System.out.println("OK base de datos " + this.db + " listo");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    public java.sql.Connection getConexion() {
        return this.conn;
    }

}
