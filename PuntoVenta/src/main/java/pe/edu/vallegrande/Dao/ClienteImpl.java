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
import pe.edu.vallegrande.Model.Cliente;

/**
 *
 * @author josue
 */
public class ClienteImpl extends Conexion implements ICRUD<Cliente> {

    @Override
    public void registrar(Cliente cliente) throws Exception {
        PreparedStatement ps;
        String sql = "insert into CLIENTE"
                + " (NOMCLI,APEPATCLI,APEMATCLI,FECNACCLI,DIRCLI,TELFCLI,EMAILCLI,IDCLI)"
                + "values (?,?,?,?,?,?,?,?)";
        try {
            ps = this.conectar().prepareStatement(sql);
            
            ps.setString(1, cliente.getNOMCLI());
            ps.setString(2, cliente.getAPEPATCLI());
            ps.setString(3, cliente.getAPEMATCLI());
            ps.setDate(4, (Date) cliente.getFECNACCLI());//cliente.getFECNACPER()            
            ps.setString(5, cliente.getDIRCLI());   
            ps.setInt(6, (int) cliente.getTELFCLI()); 
            ps.setString(7, cliente.getEMAILCLI()); 
            ps.setInt(8, cliente.getIDCLI());
            ps.executeUpdate();
            ps.close();
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en Registrar Cliente" + e.getMessage());
        } finally {
            this.cerrar();
        }
    }


    @Override
    public void modificar(Cliente modelo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Cliente modelo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> listar() throws Exception {
       String sql = "SELECT * FROM CLIENTE";
        List<Cliente> listado;
        Cliente cli;
        ResultSet rs;
        try {
            rs = conectar().createStatement().executeQuery(sql);
            listado = new ArrayList();
            while (rs.next()) {
                cli = new Cliente();
                cli.setIDCLI(rs.getInt("IDCLI"));
                cli.setNOMCLI(rs.getString("NOMCLI"));
                cli.setAPEPATCLI(rs.getString("APEPATCLI"));
                cli.setAPEMATCLI(rs.getString("APEMATCLI"));
                cli.setFECNACCLI(rs.getDate("FECNACCLI"));
                cli.setDIRCLI(rs.getString("DIRCLI"));
                cli.setTELFCLI(rs.getInt("TELFCLI"));
                cli.setEMAILCLI(rs.getString("EMAILCLI"));
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
