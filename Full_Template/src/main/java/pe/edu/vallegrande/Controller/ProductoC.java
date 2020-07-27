/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.vallegrande.Controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import pe.edu.vallegrande.Dao.ProductoImpl;
import pe.edu.vallegrande.Model.Producto;

/**
 *
 * @author josue
 */
@Named(value = "productoC")
@SessionScoped
public class ProductoC implements Serializable {

    Producto producto;
    ProductoImpl daoProducto;
    List<Producto> listProducto;
    List<Producto> filteredProducto;

    public ProductoC() {
        producto = new Producto();
        daoProducto = new ProductoImpl();
        listProducto = new ArrayList();
    }

    @PostConstruct
    public void inicio() {
        try {
            listar();
        } catch (Exception e) {
            System.out.println("Error al listar " + e.getMessage());
        }
    }

    public void guardar() {
        try {
            daoProducto.registrar(producto);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Ingresado con éxito"));
            limpiar();
        } catch (Exception e) {
            System.out.println("Error al guardar " + e.getMessage());
        }
    }

    public void actualizar() {
        try {
            daoProducto.modificar(producto);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización", "Se actualizo con éxito"));
        } catch (Exception e) {
            System.out.println("Error al actualizarC " + e.getMessage());
        }
    }

    public void eliminar() {
        try {
            daoProducto.eliminar(producto);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado", "Se eliminó con éxito"));
            listar();
        } catch (Exception e) {
            System.out.println("Error al eliminarC " + e.getMessage());
        }
    }

    public void limpiar() {
        producto = new Producto();
    }

    public void listar() {
        try {
            listProducto = daoProducto.listar();
        } catch (Exception e) {
            System.out.println("Error al  listar");
        }
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ProductoImpl getDaoProducto() {
        return daoProducto;
    }

    public void setDaoProducto(ProductoImpl daoProducto) {
        this.daoProducto = daoProducto;
    }

    public List<Producto> getListProducto() {
        return listProducto;
    }

    public void setListProducto(List<Producto> listProducto) {
        this.listProducto = listProducto;
    }

    public List<Producto> getFilteredProducto() {
        return filteredProducto;
    }

    public void setFilteredProducto(List<Producto> filteredProducto) {
        this.filteredProducto = filteredProducto;
    }
}
