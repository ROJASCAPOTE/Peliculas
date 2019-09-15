/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.idao;

import java.util.List;

/**
 *
 * @author ACER E5
 * @param <T>
 */
public interface DAO<T> {

    int registrar(T a);

    int actualizar(T a);

    int eliminar(T a);

    List<T> obtenerTodos();
}
