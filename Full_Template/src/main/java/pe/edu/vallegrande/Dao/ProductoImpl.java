/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.vallegrande.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pe.edu.vallegrande.Model.Producto;

/**
 *
 * @author josue
 */
public class ProductoImpl extends Conexion implements ICRUD<Producto> {

    @Override
    public void registrar(Producto producto) throws Exception {
        try {
            String sql = "insert into producto (NOMPROD, DESCPPROD,PRECPROD,STOCK) values (?, ?, ?,?)";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, producto.getNOMPROD());
            ps.setString(2, producto.getDESCPPROD());
            ps.setDouble(3, producto.getPRECPROD());
            ps.setInt(4, producto.getSTOCK());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al guardar" + e);
        }
    }

    ;
    

    @Override
    public void modificar(Producto producto) throws Exception {
        try {
            int id = this.obtenerId(producto.getIDPROD());
            String sql = "update Producto set NOMPROD =?, DESCPPROD =?,PRECPROD =?,STOCK =? where IDPROD =?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, producto.getNOMPROD());
            ps.setString(2, producto.getDESCPPROD());
            ps.setDouble(3, producto.getPRECPROD());
            ps.setInt(4, producto.getSTOCK());
            ps.setInt(5, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al actualizar " + e);
        }
    }

    @Override
    public void eliminar(Producto producto) throws Exception {
        try {
            String sql = "delete from Producto where IDPROD =?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, producto.getIDPROD());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al eliminar " + e);
        }
    }

    @Override
    public List<Producto> listar() throws Exception {

        String sql = "SELECT * FROM PRODUCTO";
        List<Producto> listado;
        Producto prod;
        try {
            listado = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                prod = new Producto();
                prod.setIDPROD(rs.getInt("IDPROD"));
                prod.setNOMPROD(rs.getString("NOMPROD"));
                prod.setDESCPPROD(rs.getString("DESCPPROD"));
                prod.setPRECPROD(rs.getDouble("PRECPROD"));
                prod.setSTOCK(rs.getInt("STOCK"));
                listado.add(prod);
            }
            st.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("Error al listar producto " + e);
            return null;
        } finally {
            this.cerrar();
        }
        return listado;
    }

    private int obtenerId(int id) {
        ResultSet rs;
        try {
            String sql = "select IDPROD from producto where NOMPROD =? and PRECPROD =? and STOCK =? and DESCPPROD =?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("IDPROD");
            }
            rs.close();
            return 0;
        } catch (Exception e) {
            System.out.println("Error al obtenerId " + e);
            return 0;
        }

    }
}
