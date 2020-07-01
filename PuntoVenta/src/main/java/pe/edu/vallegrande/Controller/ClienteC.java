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
import pe.edu.vallegrande.Dao.ClienteImpl;
import pe.edu.vallegrande.Model.Cliente;

/**
 *
 * @author josue
 */
@Named(value = "clienteC")
@SessionScoped
public class ClienteC implements Serializable {

    /**
     * Creates a new instance of ClienteC
     */
    private Cliente modelo;
    private ClienteImpl dao;
    private List<Cliente> listaCliente;
    private Cliente selectedClient;

    public ClienteC() {
        dao = new ClienteImpl();
        modelo = new Cliente();
        //daoBuscar = new AutoCompleteImpl();
    }

    public void registrar() throws Exception {
        try {
            dao.registrar(modelo);
            limpiar();
            listaCliente = null;
            System.out.println("Registro, completo...");
        } catch (Exception e) {
            System.out.println("No se pudo realizar el Registro...");
            throw e;
        }
    }

    public void modificar() throws Exception {
        try {
            dao.modificar(selectedClient);
            listaCliente = null;
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
            listaCliente = null;
            System.out.println("Eliminacion, completado...");
            limpiar();
        } catch (Exception e) {
            System.out.println("Falló eliminacion ...");
            throw e;
        }
    }
    
    public void limpiar() throws Exception {
        try {
            modelo = new Cliente();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void listar() {
        try {

            listaCliente = dao.listar();

        } catch (Exception e) {
            System.out.println("Error al listar" + e);
        }

    }

    public Cliente getModelo() {
        return modelo;
    }

    public void setModelo(Cliente modelo) {
        this.modelo = modelo;
    }

    public ClienteImpl getDao() {
        return dao;
    }

    public void setDao(ClienteImpl dao) {
        this.dao = dao;
    }

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public Cliente getSelectedClient() {
        return selectedClient;
    }

    public void setSelectedClient(Cliente selectedClient) {
        this.selectedClient = selectedClient;
    }

}
