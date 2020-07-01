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
import pe.edu.vallegrande.Dao.DetalleImpl;
import pe.edu.vallegrande.Model.Detalle;

/**
 *
 * @author josue
 */
@Named(value = "detalleC")
@SessionScoped
public class DetalleC implements Serializable {

    private Detalle modelo;
    private DetalleImpl dao;
    private List<Detalle> listaDetalle;
    private Detalle selectedDetalle;

    public DetalleC() {
        dao = new DetalleImpl();
        modelo = new Detalle();
        //daoBuscar = new AutoCompleteImpl();
    }

    public void registrar() throws Exception {
        try {
            dao.registrar(modelo);
            limpiar();
            listaDetalle = null;
            System.out.println("Registro, completo...");
        } catch (Exception e) {
            System.out.println("No se pudo realizar el Registro...");
            throw e;
        }
    }

    public void modificar() throws Exception {
        try {
            dao.modificar(selectedDetalle);
            listaDetalle = null;
            limpiar();
            System.out.println("Actualizacion, completa...");
        } catch (Exception e) {
            System.out.println("No se pudo Actualizar el Registro...");
            throw e;
        }
    }

    public void eliminar() throws Exception {
        try {
            dao.eliminar(selectedDetalle);
            limpiar();
            listaDetalle = null;
            System.out.println("Eliminacion, completado...");
            limpiar();
        } catch (Exception e) {
            System.out.println("Falló eliminacion ...");
            throw e;
        }
    }

    public void limpiar() throws Exception {
        try {
            modelo = new Detalle();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void listar() {
        try {

            listaDetalle = dao.listar();

        } catch (Exception e) {
            System.out.println("Error al listar" + e);
        }

    }

    public Detalle getModelo() {
        return modelo;
    }

    public void setModelo(Detalle modelo) {
        this.modelo = modelo;
    }

    public DetalleImpl getDao() {
        return dao;
    }

    public void setDao(DetalleImpl dao) {
        this.dao = dao;
    }

    public List<Detalle> getListaDetalle() {
        return listaDetalle;
    }

    public void setListaDetalle(List<Detalle> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }

    public Detalle getSelectedDetalle() {
        return selectedDetalle;
    }

    public void setSelectedDetalle(Detalle selectedDetalle) {
        this.selectedDetalle = selectedDetalle;
    }

}
