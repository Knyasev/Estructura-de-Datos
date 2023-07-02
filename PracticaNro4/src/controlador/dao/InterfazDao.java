/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.ed.lista.ListaEnlazada;
import java.io.IOException;

/**
 * meetodo que permite realizar el guardado
 * @author wilson7578
 * @param <T>
 */
public interface InterfazDao<T> {
    public void guardar(T obj) throws IOException;
    public void modificar (T obj,Integer pos)throws IOException;
    public T obtener(Integer id);
    public  ListaEnlazada<T> listar();
    
    
    
}
