/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.vallegrande.Dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Conexion {

    protected static Connection cnx = null;

    public static Connection conectar() throws Exception {

        InputStream inputStream = Conexion.class.getClassLoader().getResourceAsStream("properties/db.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            String user = properties.getProperty("user");
            String pwd = properties.getProperty("pwd");
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            Class.forName(driver).newInstance();
            cnx = DriverManager.getConnection(url, user, pwd);
            System.out.println("fulll  conexión");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            System.out.println("Error de conexión" + e.getMessage());
        }
        return cnx;
    }

    public void cerrar() throws Exception {
        try {
            if (cnx != null) {
                cnx.close();
                System.out.println("Cerrado");
            }
        } catch (SQLException e) {
            throw e;
        }
    }

   public static void main(String[] args) {
        String connectionUrl
                = "jdbc:sqlserver://localhost:1433;"
                + "database=PUNTOVENTA;"
                + "user=sa;"
                + "password=admins;";
        try (Connection connection = DriverManager.getConnection(connectionUrl);) {
            // Code here.
            System.out.println("xdSiii");
        } // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("falloooo");
        }
    }
}
