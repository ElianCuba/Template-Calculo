/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.vallegrande.Dao;

import java.util.List;


/**
 *
 * @author josue
 * @param <Generica>
 */
public interface ICRUD<Generica> {

    void registrar(Generica modelo) throws Exception;

    void modificar(Generica modelo) throws Exception;

    void eliminar(Generica modelo) throws Exception;

    List<Generica> listar() throws Exception;

}
