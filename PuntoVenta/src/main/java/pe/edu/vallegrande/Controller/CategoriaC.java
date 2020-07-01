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
import pe.edu.vallegrande.Dao.CategoriaImpl;
import pe.edu.vallegrande.Model.Categoria;

/**
 *
 * @author josue
 */
@Named(value = "categoriaC")
@SessionScoped
public class CategoriaC implements Serializable {

  private Categoria modelo;
    private CategoriaImpl dao;
    private List<Categoria> listaCategoria;
    private Categoria selectedCategoria;
    public CategoriaC() {
         dao = new CategoriaImpl();
        modelo = new Categoria();
        //daoBuscar = new AutoCompleteImpl();
    }

    public void registrar() throws Exception {
        try {
            dao.registrar(modelo);
            limpiar();
            listaCategoria = null;
            System.out.println("Registro, completo...");
        } catch (Exception e) {
            System.out.println("No se pudo realizar el Registro...");
            throw e;
        }
    }

    public void modificar() throws Exception {
        try {
            dao.modificar(selectedCategoria);
            listaCategoria = null;
            limpiar();
            System.out.println("Actualizacion, completa...");
        } catch (Exception e) {
            System.out.println("No se pudo Actualizar el Registro...");
            throw e;
        }
    }
public void eliminar() throws Exception {
        try {
            dao.eliminar(selectedCategoria);
            limpiar();
            listaCategoria = null;
            System.out.println("Eliminacion, completado...");
            limpiar();
        } catch (Exception e) {
            System.out.println("Falló eliminacion ...");
            throw e;
        }
    }
    
    public void limpiar() throws Exception {
        try {
            modelo = new Categoria();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void listar() {
        try {

            listaCategoria = dao.listar();

        } catch (Exception e) {
            System.out.println("Error al listar" + e);
        }

    }
    
    
    public Categoria getModelo() {
        return modelo;
    }

    public void setModelo(Categoria modelo) {
        this.modelo = modelo;
    }

    public CategoriaImpl getDao() {
        return dao;
    }

    public void setDao(CategoriaImpl dao) {
        this.dao = dao;
    }

    public List<Categoria> getListaCategoria() {
        return listaCategoria;
    }

    public void setListaCategoria(List<Categoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }

    public Categoria getSelectedCategoria() {
        return selectedCategoria;
    }

    public void setSelectedCategoria(Categoria selectedCategoria) {
        this.selectedCategoria = selectedCategoria;
    }
    
}
