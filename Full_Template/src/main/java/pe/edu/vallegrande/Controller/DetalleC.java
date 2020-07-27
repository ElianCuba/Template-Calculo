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
import pe.edu.vallegrande.Dao.Detalle_FacturaImpl;
import pe.edu.vallegrande.Model.Detalle_Factura;

/**
 *
 * @author josue
 */
@Named(value = "detalleC")
@SessionScoped
public class DetalleC implements Serializable {

    Detalle_Factura detalle;
    Detalle_FacturaImpl daoDetalle_Factura;
    List<Detalle_Factura> listDetalle_Factura;
    List<Detalle_Factura> filteredDetalle_Factura;

    public DetalleC() {
        detalle = new Detalle_Factura();
        daoDetalle_Factura = new Detalle_FacturaImpl();
        listDetalle_Factura = new ArrayList();
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
            daoDetalle_Factura.registrar(detalle);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Ingresado con éxito"));
            limpiar();
        } catch (Exception e) {
            System.out.println("Error al guardarC " + e.getMessage());
        }
    }

    public void actualizar() {
        try {
            daoDetalle_Factura.modificar(detalle);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización", "Se actualizo con éxito"));
        } catch (Exception e) {
            System.out.println("Error al actualizarC " + e.getMessage());
        }
    }

    public void eliminar(Detalle_Factura cliente) {
        try {
            daoDetalle_Factura.eliminar(cliente);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado", "Se eliminó con éxito"));
            listar();
        } catch (Exception e) {
            System.out.println("Error al eliminarC " + e.getMessage());
        }
    }

    public void limpiar() {
        detalle = new Detalle_Factura();
    }

    public void listar() {
        try {
            listDetalle_Factura = daoDetalle_Factura.listar();
        } catch (Exception e) {
            System.out.println("Error al  listar");
        }
    }

    public Detalle_Factura getDetalle_Factura() {
        return detalle;
    }

    public void setDetalle_Factura(Detalle_Factura detalle) {
        this.detalle = detalle;
    }

    public Detalle_FacturaImpl getDaoDetalle_Factura() {
        return daoDetalle_Factura;
    }

    public void setDaoDetalle_Factura(Detalle_FacturaImpl daoDetalle_Factura) {
        this.daoDetalle_Factura = daoDetalle_Factura;
    }

    public List<Detalle_Factura> getListDetalle_Factura() {
        return listDetalle_Factura;
    }

    public void setListDetalle_Factura(List<Detalle_Factura> listDetalle_Factura) {
        this.listDetalle_Factura = listDetalle_Factura;
    }

    public List<Detalle_Factura> getFilteredDetalle_Factura() {
        return filteredDetalle_Factura;
    }

    public void setFilteredDetalle_Factura(List<Detalle_Factura> filteredDetalle_Factura) {
        this.filteredDetalle_Factura = filteredDetalle_Factura;
    }

}
