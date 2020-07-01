/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.vallegrande.Dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;

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
    /*Generica create(Generica modelo) throws EntityExistsException, IllegalStateException,
            IllegalArgumentException, TransactionRequiredException;

    Generica read(Serializable primaryKey) throws IllegalStateException,
            IllegalArgumentException;

    void update(Generica modelo) throws IllegalStateException,
            IllegalArgumentException, TransactionRequiredException;

    void deleteO(Generica modelo) throws IllegalStateException,
            IllegalArgumentException, TransactionRequiredException,
            PersistenceException;*/

}
