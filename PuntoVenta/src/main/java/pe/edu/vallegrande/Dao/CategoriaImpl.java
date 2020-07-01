/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.vallegrande.Dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        try {
            String sql = "insert into categoria (IDCAT,NOMCAT, DESCAT) values (?, ?, ?)";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, categoria.getIDCAT());
            ps.setString(2, categoria.getNOMCAT());
            ps.setString(3, categoria.getDESCAT());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al guardar" + e);
        }
    }

    @Override
    public void modificar(Categoria categoria) throws Exception {
        try {
            int id = this.obtenerId(categoria.getIDCAT());
            String sql = "update Categoria set NOMCAT =?, DESCAT =? where IDCAT =?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, categoria.getNOMCAT());
            ps.setString(2, categoria.getDESCAT());
            ps.setInt(3, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al actualizar " + e);
        }
    }

    @Override
    public void eliminar(Categoria categoria) throws Exception {
        try {
            String sql = "delete from Categoria where IDCAT =?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, categoria.getIDCAT());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al eliminar " + e);
        }
    }

    @Override
    public List<Categoria> listar() throws Exception {
        List<Categoria> lista;
        Categoria categoria;
        String sql = "SELECT * FROM CATEGORIA";
        try {
            lista = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                categoria = new Categoria();
                categoria.setIDCAT(rs.getInt("IDCAT"));
                categoria.setNOMCAT(rs.getString("NOMCAT"));
                categoria.setDESCAT(rs.getString("DESCAT"));
                lista.add(categoria);
            }
            st.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("Error al listar categoria " + e);
            return null;
        }
        return lista;
    }

    private int obtenerId(int id) {
        ResultSet rs;
        try {
            String sql = "select IDCAT from categoria where NOMCAT =? and DESCAT =?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("IDCAT");
            }
            rs.close();
            return 0;
        } catch (Exception e) {
            System.out.println("Error al obtenerId " + e);
            return 0;
        }

    }

}
