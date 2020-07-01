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
import pe.edu.vallegrande.Dao.ModoPagoImpl;
import pe.edu.vallegrande.Model.ModoPago;

/**
 *
 * @author josue
 */
@Named(value = "modoPagoC")
@SessionScoped
public class ModoPagoC implements Serializable {

    private ModoPago modelo;
    private ModoPagoImpl dao;
    private List<ModoPago> listaModoPago;
    private ModoPago selectedModoPago;

    public ModoPagoC() {
        dao = new ModoPagoImpl();
        modelo = new ModoPago();
    }

    public void registrar() throws Exception {
        try {
            dao.registrar(modelo);
            limpiar();
            listaModoPago = null;
            System.out.println("Registro, completo...");
        } catch (Exception e) {
            System.out.println("No se pudo realizar el Registro...");
            throw e;
        }
    }

    public void modificar() throws Exception {
        try {
            dao.modificar(selectedModoPago);
            listaModoPago = null;
            limpiar();
            System.out.println("Actualizacion, completa...");
        } catch (Exception e) {
            System.out.println("No se pudo Actualizar el Registro...");
            throw e;
        }
    }

    public void eliminar() throws Exception {
        try {
            dao.eliminar(selectedModoPago);
            limpiar();
            listaModoPago = null;
            System.out.println("Eliminacion, completado...");
            limpiar();
        } catch (Exception e) {
            System.out.println("Falló eliminacion ...");
            throw e;
        }
    }

    public void limpiar() throws Exception {
        try {
            modelo = new ModoPago();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void listar() {
        try {

            listaModoPago = dao.listar();

        } catch (Exception e) {
            System.out.println("Error al listar" + e);
        }

    }

    public ModoPago getModelo() {
        return modelo;
    }

    public void setModelo(ModoPago modelo) {
        this.modelo = modelo;
    }

    public ModoPagoImpl getDao() {
        return dao;
    }

    public void setDao(ModoPagoImpl dao) {
        this.dao = dao;
    }

    public List<ModoPago> getListaModoPago() {
        return listaModoPago;
    }

    public void setListaModoPago(List<ModoPago> listaModoPago) {
        this.listaModoPago = listaModoPago;
    }

    public ModoPago getSelectedModoPago() {
        return selectedModoPago;
    }

    public void setSelectedModoPago(ModoPago selectedModoPago) {
        this.selectedModoPago = selectedModoPago;
    }
}
