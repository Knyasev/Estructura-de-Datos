/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.ed.lista.ListaEnlazada;
import modelo.Ventas;
/**
 *
 * @author wilson7578
 */
public class Sucursal {
    private Integer id;
    private String nombre;
    private ListaEnlazada<Ventas> listaEnlazada;
    private ListaEnlazada<Reclamo> reclamo ;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaEnlazada<Ventas> getListaEnlazada() {
        return listaEnlazada;
    }

    public void setListaEnlazada(ListaEnlazada<Ventas> listaEnlazada) {
        
        this.listaEnlazada = listaEnlazada;
    }

    

    public ListaEnlazada<Reclamo> getReclamo() {
        return reclamo;
    }

    public void setReclamo(ListaEnlazada<Reclamo> reclamo) {
        this.reclamo = reclamo;
    }


   

    

    

    
    @Override
    public String toString() {
        return nombre ;
    }
    
    
    
    
    
}
