/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ed.cola;

import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioExceptio;
import controlador.ed.lista.exception.exception.TopeException;

/**
 *
 * @author wilson7578
 */
public class Cola<E> {
    private ColaI<E> cola ;

    public Cola(Integer tope) {
        this.cola = new ColaI(tope);
    }
    
    public void queue (E obj) throws TopeException{
    cola.queue(obj);
    
    }
    public E dequeue () throws VacioExceptio, PosicionException{
    
    return cola.dequeue();
    }
    
    public void print () throws VacioExceptio{
    cola.imprimir();
    }

    public Integer getTope() {
        return cola.getTope();
    }
    
}
