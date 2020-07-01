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
import pe.edu.vallegrande.Dao.CategoriaImpl;
import pe.edu.vallegrande.Model.Categoria;

/**
 *
 * @author josue
 */
@Named(value = "categoriaC")
@SessionScoped
public class CategoriaC implements Serializable {

    private Categoria categoria;
    private CategoriaImpl daoCategoria;
    private List<Categoria> listCategoria;
    public CategoriaC() {
        categoria = new Categoria();
        daoCategoria = new CategoriaImpl();
        listCategoria = new ArrayList();
    }
    
    @PostConstruct
    public void init() {
        try {
            listar();
        } catch (Exception e) {
            e.getMessage();
        }

    }

    public void listar() {
        try {
            listCategoria = daoCategoria.listar();
        } catch (Exception e) {
            System.out.println("Error al  listar");
        }

    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public CategoriaImpl getDaoCategoria() {
        return daoCategoria;
    }

    public void setDaoCategoria(CategoriaImpl daoCategoria) {
        this.daoCategoria = daoCategoria;
    }

    public List<Categoria> getListCategoria() {
        return listCategoria;
    }

    public void setListCategoria(List<Categoria> listCategoria) {
        this.listCategoria = listCategoria;
    }
    
}
