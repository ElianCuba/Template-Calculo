/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.vallegrande.Dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.vallegrande.Model.Categoria;

/**
 *
 * @author josue
 */
public class CategoriaImpl extends Conexion implements ICRUD<Categoria> {

    @Override
    public void registrar(Categoria categoria) throws Exception {
        PreparedStatement ps;
        String sql = "insert into CATEGORIA"
                + " (NOMCAT,DESCAT,IDCAT)"
                + "values (?,?,?)";
        try {
            ps = this.conectar().prepareStatement(sql);
            
            ps.setString(1, categoria.getNOMCAT());
            ps.setString(2, categoria.getDESCAT());
            ps.setInt(3, categoria.getIDCAT());
            ps.executeUpdate();
            ps.close();
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en Registrar Cliente" + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificar(Categoria modelo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Categoria modelo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Categoria> listar() throws Exception {
        String sql = "SELECT * FROM CATEGORIA";
        List<Categoria> listado;
        Categoria cli;
        ResultSet rs;
        try {
            rs = conectar().createStatement().executeQuery(sql);
            listado = new ArrayList();
            while (rs.next()) {
                cli = new Categoria();
                cli.setIDCAT(rs.getInt("IDCAT"));
                cli.setNOMCAT(rs.getString("NOMCAT"));
                cli.setDESCAT(rs.getString("DESCAT"));
                listado.add(cli);
            }
            rs.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro al listar");
            throw e;
        } finally {
            this.cerrar();
        }
        return listado;
    }
}
