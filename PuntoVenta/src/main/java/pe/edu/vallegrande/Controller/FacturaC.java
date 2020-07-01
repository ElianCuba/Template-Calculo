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
import pe.edu.vallegrande.Dao.FacturaImpl;
import pe.edu.vallegrande.Model.Factura;

/**
 *
 * @author josue
 */
@Named(value = "facturaC")
@SessionScoped
public class FacturaC implements Serializable {

    private Factura modelo;
    private FacturaImpl dao;
    private List<Factura> listaFactura;
    private Factura selectedFactura;

    public FacturaC() {
        dao = new FacturaImpl();
        modelo = new Factura();
        //daoBuscar = new AutoCompleteImpl();
    }

    public void registrar() throws Exception {
        try {
            dao.registrar(modelo);
            limpiar();
            listaFactura = null;
            System.out.println("Registro, completo...");
        } catch (Exception e) {
            System.out.println("No se pudo realizar el Registro...");
            throw e;
        }
    }

    public void modificar() throws Exception {
        try {
            dao.modificar(selectedFactura);
            listaFactura = null;
            limpiar();
            System.out.println("Actualizacion, completa...");
        } catch (Exception e) {
            System.out.println("No se pudo Actualizar el Registro...");
            throw e;
        }
    }

    public void eliminar() throws Exception {
        try {
            dao.eliminar(selectedFactura);
            limpiar();
            listaFactura = null;
            System.out.println("Eliminacion, completado...");
            limpiar();
        } catch (Exception e) {
            System.out.println("Falló eliminacion ...");
            throw e;
        }
    }

    public void limpiar() throws Exception {
        try {
            modelo = new Factura();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void listar() {
        try {

            listaFactura = dao.listar();

        } catch (Exception e) {
            System.out.println("Error al listar" + e);
        }

    }

    public Factura getModelo() {
        return modelo;
    }

    public void setModelo(Factura modelo) {
        this.modelo = modelo;
    }

    public FacturaImpl getDao() {
        return dao;
    }

    public void setDao(FacturaImpl dao) {
        this.dao = dao;
    }

    public List<Factura> getListaFactura() {
        return listaFactura;
    }

    public void setListaFactura(List<Factura> listaFactura) {
        this.listaFactura = listaFactura;
    }

    public Factura getSelectedFactura() {
        return selectedFactura;
    }

    public void setSelectedFactura(Factura selectedFactura) {
        this.selectedFactura = selectedFactura;
    }

}
