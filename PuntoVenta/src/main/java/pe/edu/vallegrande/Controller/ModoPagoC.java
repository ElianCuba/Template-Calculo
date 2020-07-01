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
import pe.edu.vallegrande.Dao.ModoPagoImpl;
import pe.edu.vallegrande.Model.ModoPago;

/**
 *
 * @author josue
 */
@Named(value = "modoPagoC")
@SessionScoped
public class ModoPagoC implements Serializable {

    ModoPago modopa;
    ModoPagoImpl daoModoPago;
    List<ModoPago> listModoPago;
    List<ModoPago> filteredModoPago;

    public ModoPagoC() {
        modopa = new ModoPago();
        daoModoPago = new ModoPagoImpl();
        listModoPago = new ArrayList();
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
            daoModoPago.registrar(modopa);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Ingresado con éxito"));
            limpiar();
        } catch (Exception e) {
            System.out.println("Error al guardarC " + e.getMessage());
        }
    }

    public void actualizar() {
        try {
            daoModoPago.modificar(modopa);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización", "Se actualizo con éxito"));
        } catch (Exception e) {
            System.out.println("Error al actualizarC " + e.getMessage());
        }
    }

    public void eliminar(ModoPago modopa) {
        try {
            daoModoPago.eliminar(modopa);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado", "Se eliminó con éxito"));
            listar();
        } catch (Exception e) {
            System.out.println("Error al eliminarC " + e.getMessage());
        }
    }

    public void limpiar() {
        modopa = new ModoPago();
    }

    public void listar() {
        try {
            listModoPago = daoModoPago.listar();
        } catch (Exception e) {
            System.out.println("Error al  listar");
        }
    }   

    public ModoPago getModopa() {
        return modopa;
    }

    public void setModopa(ModoPago modopa) {
        this.modopa = modopa;
    }

    public ModoPagoImpl getDaoModoPago() {
        return daoModoPago;
    }

    public void setDaoModoPago(ModoPagoImpl daoModoPago) {
        this.daoModoPago = daoModoPago;
    }

    public List<ModoPago> getListModoPago() {
        return listModoPago;
    }

    public void setListModoPago(List<ModoPago> listModoPago) {
        this.listModoPago = listModoPago;
    }

    public List<ModoPago> getFilteredModoPago() {
        return filteredModoPago;
    }

    public void setFilteredModoPago(List<ModoPago> filteredModoPago) {
        this.filteredModoPago = filteredModoPago;
    }
}
