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
import pe.edu.vallegrande.Dao.ClienteImpl;
import pe.edu.vallegrande.Model.Cliente;

/**
 *
 * @author josue
 */
@Named(value = "clienteC")
@SessionScoped
public class ClienteC implements Serializable {

    Cliente cliente;
    ClienteImpl daoCliente;
    List<Cliente> listCliente;
    List<Cliente> filteredCliente;

    public ClienteC() {
        cliente = new Cliente();
        daoCliente = new ClienteImpl();
        listCliente = new ArrayList();
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
            daoCliente.registrar(cliente);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Ingresado con éxito"));
            limpiar();
        } catch (Exception e) {
            System.out.println("Error al guardarC " + e.getMessage());
        }
    }

    public void actualizar() {
        try {
            daoCliente.modificar(cliente);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización", "Se actualizo con éxito"));
        } catch (Exception e) {
            System.out.println("Error al actualizarC " + e.getMessage());
        }
    }

    public void eliminar(Cliente cliente) {
        try {
            daoCliente.eliminar(cliente);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado", "Se eliminó con éxito"));
            listar();
        } catch (Exception e) {
            System.out.println("Error al eliminarC " + e.getMessage());
        }
    }

    public void limpiar() {
        cliente = new Cliente();
    }

    public void listar() {
        try {
            listCliente = daoCliente.listar();
        } catch (Exception e) {
            System.out.println("Error al  listar");
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ClienteImpl getDaoCliente() {
        return daoCliente;
    }

    public void setDaoCliente(ClienteImpl daoCliente) {
        this.daoCliente = daoCliente;
    }

    public List<Cliente> getListCliente() {
        return listCliente;
    }

    public void setListCliente(List<Cliente> listCliente) {
        this.listCliente = listCliente;
    }

    public List<Cliente> getFilteredCliente() {
        return filteredCliente;
    }

    public void setFilteredCliente(List<Cliente> filteredCliente) {
        this.filteredCliente = filteredCliente;
    }
    
    
}
