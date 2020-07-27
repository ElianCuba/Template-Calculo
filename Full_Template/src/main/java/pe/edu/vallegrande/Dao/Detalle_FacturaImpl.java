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
import pe.edu.vallegrande.Model.Detalle_Factura;

/**
 *
 * @author josue
 */
public class Detalle_FacturaImpl extends Conexion implements ICRUD<Detalle_Factura> {

    @Override
    public void registrar(Detalle_Factura detalle) throws Exception {
        try {
            int idf = this.obtenerIdF(detalle.getCODFAC());
            int idp = this.obtenerIdP(detalle.getIDPROD());
            String sql = "insert into detalle (CODFAC=?, IDPROD=?,CANTDET,PRECTOTDET) values (?, ?, ?, ?, ?)";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, detalle.getCANTDET());
            ps.setDouble(2, detalle.getSUBTOTDET());
            ps.setInt(3, idf);
            ps.setInt(4, idp);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al guardar" + e);
        }
    }

    @Override
    public void modificar(Detalle_Factura detalle) throws Exception {
        try {
            int idf = this.obtenerIdF(detalle.getCODFAC());
            int idp = this.obtenerIdP(detalle.getIDPROD());
            String sql = "update Detalle_Factura set CANTDET =?,SUBTOTDET =? where CODFAC =?,IDPROD =?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, detalle.getCANTDET());
            ps.setDouble(2, detalle.getSUBTOTDET());
            ps.setInt(3, idf);
            ps.setInt(4, idp);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al actualizar " + e);
        }
    }

    @Override
    public void eliminar(Detalle_Factura detalle) throws Exception {
        try {
            String sql = "delete from Detalle_Factura where IDPROD =? , CODFAC=?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, detalle.getCODFAC());
            ps.setInt(2, detalle.getIDPROD());

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al eliminar " + e);
        }
    }

    @Override
    public List<Detalle_Factura> listar() throws Exception {
        List<Detalle_Factura> lista;
        Detalle_Factura detalle;
        String sql = "SELECT * FROM Detalle_Factura";
        try {
            lista = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                detalle = new Detalle_Factura();
                detalle.setCODFAC(rs.getInt("CODFAC"));
                detalle.IDPRODTD.setIDPROD(rs.getInt("IDPROD"));
                detalle.IDPRODTD.setNOMPROD(rs.getString("NOMPROD"));
                detalle.IDPRODTD.setPRECPROD(rs.getDouble("PRECPROD"));
                detalle.setCANTDET(rs.getInt("CANTDET"));
                detalle.setSUBTOTDET(rs.getInt("SUBTOTDET"));
                
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

    private int obtenerIdF(int idf) {
        ResultSet rs;
        try {
            String sql = "select CODFAC from detalle where IDPROD=?, NOMCAT =? and DESCAT =?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, idf);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("CODFAC");
            }
            rs.close();
            return 0;
        } catch (Exception e) {
            System.out.println("Error al obtenerId " + e);
            return 0;
        }
    }

    private int obtenerIdP(int idp) {
        ResultSet rs;
        try {
            String sql = "select IDPROD from detalle where CODFAC=?, CANTDET=? and SUBTOTDET=?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, idp);
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
