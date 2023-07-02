/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ed.pila;

import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioExceptio;
import controlador.ed.lista.exception.exception.TopeException;

/**
 *
 * @author wilson7578
 */
public class Pila<E> {
    private PilaI<E> pilai ;

    public Pila(Integer cima) {
        pilai =  new PilaI<>(cima);
    }
    public void push (E obj) throws TopeException{
    pilai.push(obj);
    
    }
    public E pop() throws VacioExceptio, PosicionException{
    return pilai.pop();
    } 
    
     public void print () throws VacioExceptio{
     pilai.imprimir();
     }
            
            }
