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
    private String url;
    /**
     * variable para trabajar con la conexion a la base de datos
     */
    protected Connection conexion;

    private Statement sentencia;
    private ResultSet resultado;

    private static Connection connect;
    private static ConnectionBD instance;

    private ConnectionBD() {
        this.url = "jdbc:mysql://localhost:3306/" + this.db + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(this.url, this.user, this.password);
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    public static ConnectionBD getInstance() {
        //Esto servira para que solo se haga una vez garantizando el patron singleton
        if (instance == null) {
            System.out.println("Se crea la instancia solo una vez garantizanco el patron Singleton");
            instance = new ConnectionBD();
        }

        return instance;

    }

    public Connection getConexion() {
        return conexion;
    }

   

}
