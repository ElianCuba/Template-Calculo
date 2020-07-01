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
import pe.edu.vallegrande.Model.Detalle;

/**
 *
 * @author josue
 */
public class DetalleImpl extends Conexion implements ICRUD<Detalle> {

    @Override
    public void registrar(Detalle detalle) throws Exception {
        try {
            String sql = "insert into detalle (IDDET,CODFAC, IDPROD,CANTDET,PRICTOTDET) values (?, ?, ?, ?, ?)";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, detalle.getIDDET());
            ps.setInt(2, detalle.getCODFAC());
            ps.setInt(3, detalle.getIDPROD());
            ps.setInt(4, detalle.getCANTDET());
            ps.setDouble(5, detalle.getPRICTOTDET());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al guardar" + e);
        }
    }

    @Override
    public void modificar(Detalle detalle) throws Exception {
        try {
            int id = this.obtenerId(detalle.getIDDET());
            String sql = "update Detalle set CODFAC=?, IDPROD=?,CANTDET=?,PRICTOTDET=? where IDDET =?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, detalle.getCODFAC());
            ps.setInt(2, detalle.getIDPROD());
            ps.setInt(3, detalle.getCANTDET());
            ps.setDouble(4, detalle.getPRICTOTDET());
            ps.setInt(5, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al actualizar " + e);
        }
    }

    @Override
    public void eliminar(Detalle detalle) throws Exception {
        try {
            String sql = "delete from Detalle where IDDET =?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, detalle.getIDDET());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al eliminar " + e);
        }
    }

    @Override
    public List<Detalle> listar() throws Exception {
        List<Detalle> lista;
        Detalle detalle;
        String sql = "SELECT * FROM detalle";
        try {
            lista = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                detalle = new Detalle();
                detalle.setIDDET(rs.getInt("IDDET"));
                detalle.setCODFAC(rs.getInt("CODFAC"));
                detalle.setCANTDET(rs.getInt("CANTDET"));
                detalle.setPRICTOTDET(rs.getInt("PRICTOTDET"));
                detalle.setIDPROD(rs.getInt("IDPROD"));
                lista.add(detalle);
            }
            st.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("Error al listar detalle " + e);
            return null;
        }
        return lista;
    }

    private int obtenerId(int id) {
        ResultSet rs;
        try {
            String sql = "select IDCAT from detalle where NOMCAT =? and DESCAT =?";
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
