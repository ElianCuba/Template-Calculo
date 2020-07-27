/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.vallegrande.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pe.edu.vallegrande.Model.Cliente;

/**
 *
 * @author josue
 */
public class ClienteImpl extends Conexion implements ICRUD<Cliente> {

    @Override
    public void registrar(Cliente cliente) throws Exception {
        try {
            String sql = "insert into CLIENTE"
                    + " (NOMCLI,APEPATCLI,APEMATCLI,DIRCLI,TELFCLI)"
                    + "values (?,?,?,?,?)";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, cliente.getNOMCLI());
            ps.setString(2, cliente.getAPEPATCLI());
            ps.setString(3, cliente.getAPEMATCLI());
            ps.setString(4, cliente.getDIRCLI());
            ps.setString(5, cliente.getTELFCLI());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Registrar " + e);
        } finally {
            this.cerrar();
        }

    }

    @Override
    public void modificar(Cliente cliente) throws Exception {
        try {
            String sql = "update CLIENTE set  NOMCLI=?,APEPATCLI=?,APEMATCLI=?,DIRCLI=?,TELFCLI=? WHERE IDCLI=?";
            try (PreparedStatement ps = this.conectar().prepareStatement(sql)) {
                ps.setString(1, cliente.getNOMCLI());
                ps.setString(2, cliente.getAPEPATCLI());
                ps.setString(3, cliente.getAPEMATCLI());
                ps.setString(4, cliente.getDIRCLI());
                ps.setString(5, cliente.getTELFCLI());
                ps.setInt(6, cliente.getIDCLI());
                System.out.println("id:"+ cliente.getIDCLI());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error al modificar " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void eliminar(Cliente cliente) throws Exception {
        try {
            String sql = "delete from CLIENTE where IDCLI =?";
            try (PreparedStatement ps = this.conectar().prepareStatement(sql)) {
                ps.setInt(1, cliente.getIDCLI());
                ps.executeUpdate();
            }
            System.out.println("xd");
        } catch (SQLException e) {
            System.out.println("Error al eliminar actividad " + e);
        } finally {
            this.cerrar();
        }
    }

    @Override
    public List<Cliente> listar() throws Exception {
        List<Cliente> listado;
        Cliente cli;
        String sql = "SELECT * FROM CLIENTE";
        try {

            listado = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cli = new Cliente();
                cli.setIDCLI(rs.getInt("IDCLI"));
                cli.setNOMCLI(rs.getString("NOMCLI"));
                cli.setAPEPATCLI(rs.getString("APEPATCLI"));
                cli.setAPEMATCLI(rs.getString("APEMATCLI"));
                cli.setDIRCLI(rs.getString("DIRCLI"));
                cli.setTELFCLI(rs.getString("TELFCLI"));
                listado.add(cli);
            }
            st.close();
            rs.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro al listar");
            throw e;
        } finally {
            this.cerrar();
        }
        return listado;
    }

    private int obtenerId(int id) {
        ResultSet rs;
        try {
            String sql = "SELECT IDCLI FROM cliente WHERE NOMCLI=? and APEPATCLI=? and APEMATCLI=?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("IDCLI");
            }
            rs.close();
            return 0;
        } catch (Exception e) {
            System.out.println("Error al obtenerId " + e);
            return 0;
        }

    }

}
