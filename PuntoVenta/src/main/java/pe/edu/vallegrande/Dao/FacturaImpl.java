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

/**
 *
 * @author josue
 */
public class FacturaImpl extends Conexion implements ICRUD<Factura> {

    @Override
    public void registrar(Factura factura) throws Exception {
        try {
            String sql = "insert into Factura (CODFAC, IDCLI, FECHFAC,IDPAG) values (?, ?, ?, ?)";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, factura.getCODFAC());
            ps.setInt(2, factura.getIDCLI());
            ps.setDate(3, (Date) factura.getFECHFAC());
            ps.setInt(4, factura.getIDPAG());
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
            String sql = "update Factura set IDCLI =?, FECHFAC =?,IDPAG = ? where CODFAC =?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, factura.getIDCLI());
            ps.setDate(2, (Date) factura.getFECHFAC());
            ps.setInt(3, factura.getIDPAG());;
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
        String sql = "select * from Factura";
        try {
            lista = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                factura = new Factura();
                factura.setCODFAC(rs.getInt("CODFAC"));
                factura.setIDCLI(rs.getInt("NOMCAT"));
                factura.setFECHFAC(rs.getDate("DESCAT"));
                factura.setIDPAG(rs.getInt("DESCAT"));
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
            String sql = "select CODFAC,IDCLI,IDPAG from factura where FECHFAC=?;";
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
