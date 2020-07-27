/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.vallegrande.Dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pe.edu.vallegrande.Model.Factura;
import pe.edu.vallegrande.Model.Sevice.serv;

/**
 *
 * @author josue
 */
public class FacturaImpl extends Conexion implements ICRUD<Factura> {

    @Override
    public void registrar(Factura factura) throws Exception {
        try {
            String sql = "insert into Factura (CODFAC, IDCLI, FECHFAC,TOTFAC,DESCFAC,IGV,TOTPAGFAC) values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, factura.getCODFAC());
            ps.setInt(2, factura.getIDCLI());
            ps.setDate(3, serv.Util2Sql(factura.getFECHFAC()));
            ps.setDouble(4, factura.getTOTFAC());
            ps.setDouble(5, factura.getDESCFAC());
            ps.setDouble(6, factura.getIGV());
            ps.setDouble(7, factura.getTOTPAGFAC());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al guardar" + e);
        }
    }

    @Override
    public void modificar(Factura factura) throws Exception {
        try {
            int cod = this.obtenerId(factura.getCODFAC());
            String sql = "update Factura set IDCLI=?, FECHFAC=?,TOTFAC=?,DESCFAC=?,IGV=?,TOTPAGFAC =? where CODFAC =?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, factura.getIDCLI());
            ps.setDate(2, (Date) factura.getFECHFAC());
            ps.setDouble(3, factura.getTOTFAC());
            ps.setDouble(4, factura.getDESCFAC());
            ps.setDouble(5, factura.getIGV());
            ps.setDouble(6, factura.getTOTPAGFAC());
            ps.setInt(7, factura.getCODFAC());

            ps.setInt(4, cod);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al actualizar " + e);
        }
    }

    @Override
    public void eliminar(Factura factura) throws Exception {
        try {
            String sql = "delete from Factura where CODFAC =?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, factura.getCODFAC());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al eliminar " + e);
        }
    }

    @Override
    public List<Factura> listar() throws Exception {
        List<Factura> lista;
        Factura factura;
        String sql = "select * from FACTURA";
        try {
            lista = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                factura = new Factura();
                factura.setCODFAC(rs.getInt("CODFAC"));
                factura.setFECHFAC(rs.getDate("FECHFAC"));
                factura.IDCLIFAC.setNOMCLI(rs.getString("NOMCLI"));
                factura.IDCLIFAC.setAPEPATCLI(rs.getString("APEPATCLI"));
                factura.IDCLIFAC.setAPEMATCLI(rs.getString("APEMATCLI"));
                factura.setTOTFAC(rs.getDouble("TOTFAC"));
                factura.setDESCFAC(rs.getDouble("DESCFAC"));
                factura.setIGV(rs.getDouble("IGV"));
                factura.setTOTPAGFAC(rs.getDouble("TOTPAGFAC"));
                lista.add(factura);
            }
            st.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("Error al listar factura " + e);
            return null;
        }
        return lista;
    }

    private int obtenerId(int cod) {
        ResultSet rs;
        try {
            String sql = "select CODFAC from producto where IDCLI=? and  FECHFAC=?and TOTFAC=? and IDCAT =?  and DESCFAC =? IGV=?,TOTPAGFAC=?;";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, cod);
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

}
