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
import pe.edu.vallegrande.Dao.FacturaImpl;
import pe.edu.vallegrande.Model.Factura;
import static pe.edu.vallegrande.Model.Sevice.serv.mensajeInfo;

/**
 *
 * @author josue
 */
@Named(value = "facturaC")
@SessionScoped
public class FacturaC implements Serializable {

    private Factura factura;
    private FacturaImpl daoFactura;
    private List<Factura> listFactura;

    public FacturaC() {

        factura = new Factura();
        daoFactura = new FacturaImpl();
        listFactura = new ArrayList();
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
            daoFactura.registrar(factura);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Ingresado con éxito"));
            limpiar();
        } catch (Exception e) {
             mensajeInfo("Registro", "completo...");
        }
    }

    public void actualizar() {
        try {
            daoFactura.modificar(factura);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización", "Se actualizo con éxito"));
        } catch (Exception e) {
            System.out.println("Error al actualizarC " + e.getMessage());
        }
    }

    public void eliminar(Factura factura) {
        try {
            daoFactura.eliminar(factura);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado", "Se eliminó con éxito"));
            listar();
        } catch (Exception e) {
            System.out.println("Error al eliminarC " + e.getMessage());
        }
    }

    public void limpiar() {
        factura = new Factura();
    }

    public void listar() {
        try {
            listFactura = daoFactura.listar();
        } catch (Exception e) {
            System.out.println("Error al  listar");
        }
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public FacturaImpl getDaoFactura() {
        return daoFactura;
    }

    public void setDaoFactura(FacturaImpl daoFactura) {
        this.daoFactura = daoFactura;
    }

    public List<Factura> getListFactura() {
        return listFactura;
    }

    public void setListFactura(List<Factura> listFactura) {
        this.listFactura = listFactura;
    }

}
