/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.vallegrande.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.vallegrande.Model.Producto;

/**
 *
 * @author josue
 */
public class ProductoImpl extends Conexion implements ICRUD<Producto> {

    @Override
    public void registrar(Producto modelo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Producto modelo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Producto modelo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Producto> listar() throws Exception {
    String sql = "SELECT * FROM PRODUCTO";
        List<Producto> listado;
        Producto prod;
        ResultSet rs;
        try {
            rs = this.conectar().createStatement().executeQuery(sql);
            listado = new ArrayList();
            while (rs.next()) {
                prod = new Producto();
                prod.setIDPROD(rs.getInt("IDPROD"));
                prod.setNOMPROD(rs.getString("NOMPROD"));
                prod.setPRICPROD(rs.getDouble("PRICPROD"));
                prod.setSTOCK(rs.getInt("STOCK"));
                prod.setIDCAT(rs.getInt("IDCAT"));
                listado.add(prod);
            }
            rs.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return listado;   
    }    
}
