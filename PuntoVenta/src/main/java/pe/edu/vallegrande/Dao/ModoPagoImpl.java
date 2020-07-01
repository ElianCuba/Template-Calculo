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
import pe.edu.vallegrande.Model.ModoPago;

/**
 *
 * @author josue
 */
public class ModoPagoImpl extends Conexion implements ICRUD<ModoPago> {

    @Override
    public void registrar(ModoPago modo) throws Exception {
        try {
            String sql = "insert into modo ( IDPAG,NOMPAG, DETALPAG) values (?, ?, ?)";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, modo.getIDPAG());
            ps.setString(2, modo.getNOMPAG());
            ps.setString(3, modo.getDETALPAG());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al guardar" + e);
        }
    }

    @Override
    public void modificar(ModoPago modo) throws Exception {
        try {
            int id = this.obtenerId(modo.getIDPAG());
            String sql = "update ModoPago set NOMPAG =?, DETALPAG =? where IDPAG =?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, modo.getNOMPAG());
            ps.setString(2, modo.getDETALPAG());
            ps.setInt(3, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al actualizar " + e);
        }
    }

    @Override
    public void eliminar(ModoPago modo) throws Exception {
        try {
            String sql = "delete from ModoPago where IDPAG =?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, modo.getIDPAG());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al eliminar " + e);
        }
    }

    @Override
    public List<ModoPago> listar() throws Exception {
        List<ModoPago> lista;
        ModoPago modo;
        String sql = "select * from ModoPago";
        try {
            lista = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                modo = new ModoPago();
                modo.setIDPAG(rs.getInt("IDPAG"));
                modo.setNOMPAG(rs.getString("NOMPAG"));
                modo.setDETALPAG(rs.getString("DETALPAG"));
                lista.add(modo);
            }
            st.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("Error al listar modo " + e);
            return null;
        }
        return lista;
    }

    private int obtenerId(int id) {
        ResultSet rs;
        try {
            String sql = "select IDPAG from modo where NOMPAG =? and DETALPAG =?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("IDPAG");
            }
            rs.close();
            return 0;
        } catch (Exception e) {
            System.out.println("Error al obtenerId " + e);
            return 0;
        }

    }

}
