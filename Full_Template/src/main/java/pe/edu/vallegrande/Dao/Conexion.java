/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.vallegrande.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private Connection cnx;

    public Connection conectar() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cnx = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=FACTURACION;user=sa; password=admins");
        } catch (SQLException e) {
            System.out.println("ERROR" + e.getMessage());
        }
        return cnx;
    }

    public void cerrar() throws SQLException {
        if (cnx != null) {
            cnx.close();
        }
    }
}
