/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.vallegrande.Controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import pe.edu.vallegrande.Dao.ProductoImpl;
import pe.edu.vallegrande.Model.Producto;

/**
 *
 * @author josue
 */
@Named(value = "productC")
@SessionScoped
public class ProductC implements Serializable {

 private Producto modelo;
    private ProductoImpl dao;
    private List<Producto> listaProducto;
    private Producto selectedClient;

    public ProductC() {
         dao = new ProductoImpl();
        modelo = new Producto();
        //daoBuscar = new AutoCompleteImpl();
    }
    
    
    public void registrar() throws Exception {
        try {
            dao.registrar(modelo);
            limpiar();
            listaProducto = null;
            System.out.println("Registro, completo...");
        } catch (Exception e) {
            System.out.println("No se pudo realizar el Registro...");
            throw e;
        }
    }

    public void modificar() throws Exception {
        try {
            dao.modificar(selectedClient);
            listaProducto = null;
            limpiar();
            System.out.println("Actualizacion, completa...");
        } catch (Exception e) {
            System.out.println("No se pudo Actualizar el Registro...");
            throw e;
        }
    }
public void eliminar() throws Exception {
        try {
            dao.eliminar(selectedClient);
            limpiar();
            listaProducto = null;
            System.out.println("Eliminacion, completado...");
            limpiar();
        } catch (Exception e) {
            System.out.println("Falló eliminacion ...");
            throw e;
        }
    }
    
    public void limpiar() throws Exception {
        try {
            modelo = new Producto();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void listar() {
        try {

            listaProducto = dao.listar();

        } catch (Exception e) {
            System.out.println("Error al listar" + e);
        }

    }

    public Producto getModelo() {
        return modelo;
    }

    public void setModelo(Producto modelo) {
        this.modelo = modelo;
    }

    public ProductoImpl getDao() {
        return dao;
    }

    public void setDao(ProductoImpl dao) {
        this.dao = dao;
    }

    public List<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public Producto getSelectedClient() {
        return selectedClient;
    }

    public void setSelectedClient(Producto selectedClient) {
        this.selectedClient = selectedClient;
    }   
}
