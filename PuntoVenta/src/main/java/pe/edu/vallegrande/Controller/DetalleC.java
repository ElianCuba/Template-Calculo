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
import pe.edu.vallegrande.Dao.DetalleImpl;
import pe.edu.vallegrande.Model.Detalle;

/**
 *
 * @author josue
 */
@Named(value = "detalleC")
@SessionScoped
public class DetalleC implements Serializable {

    Detalle detalle;
    DetalleImpl daoDetalle;
    List<Detalle> listDetalle;
    List<Detalle> filteredDetalle;

    public DetalleC() {
        detalle = new Detalle();
        daoDetalle = new DetalleImpl();
        listDetalle = new ArrayList();
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
            daoDetalle.registrar(detalle);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Ingresado con éxito"));
            limpiar();
        } catch (Exception e) {
            System.out.println("Error al guardarC " + e.getMessage());
        }
    }

    public void actualizar() {
        try {
            daoDetalle.modificar(detalle);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización", "Se actualizo con éxito"));
        } catch (Exception e) {
            System.out.println("Error al actualizarC " + e.getMessage());
        }
    }

    public void eliminar(Detalle cliente) {
        try {
            daoDetalle.eliminar(cliente);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado", "Se eliminó con éxito"));
            listar();
        } catch (Exception e) {
            System.out.println("Error al eliminarC " + e.getMessage());
        }
    }

    public void limpiar() {
        detalle = new Detalle();
    }

    public void listar() {
        try {
            listDetalle = daoDetalle.listar();
        } catch (Exception e) {
            System.out.println("Error al  listar");
        }
    }

    public Detalle getDetalle() {
        return detalle;
    }

    public void setDetalle(Detalle detalle) {
        this.detalle = detalle;
    }

    public DetalleImpl getDaoDetalle() {
        return daoDetalle;
    }

    public void setDaoDetalle(DetalleImpl daoDetalle) {
        this.daoDetalle = daoDetalle;
    }

    public List<Detalle> getListDetalle() {
        return listDetalle;
    }

    public void setListDetalle(List<Detalle> listDetalle) {
        this.listDetalle = listDetalle;
    }

    public List<Detalle> getFilteredDetalle() {
        return filteredDetalle;
    }

    public void setFilteredDetalle(List<Detalle> filteredDetalle) {
        this.filteredDetalle = filteredDetalle;
    }
    
    

}
