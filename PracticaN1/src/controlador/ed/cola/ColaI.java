/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ed.cola;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioExceptio;
import controlador.ed.lista.exception.exception.TopeException;

/**
 *
 * @author wilson7578
 */
public class ColaI<E> extends ListaEnlazada<E> {

    private Integer tope;

    public ColaI(Integer tope) {
        this.tope = tope;
    }

    public Boolean isFull() {

        return (size() >= tope);
    }

    public void queue(E dato) throws TopeException{
        if (!isFull()) {
            throw new TopeException("cola sin espacio");
        }else {
        this.InsertarNodo(dato);
        
        }
   
}
     public E dequeue() throws VacioExceptio, PosicionException{
      E dato = null;
     if (isEmpty()) {
         throw new VacioExceptio("pila vacia");
     }
     return this.delete(0);
    }    

    public Integer getTope() {
        return tope;
    }

    public void setTope(Integer tope) {
        this.tope = tope;
    }
    
}
