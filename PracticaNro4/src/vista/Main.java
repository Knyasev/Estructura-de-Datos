/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioExceptio;
import controlador.ed.pila.Pila;
import controlador.util.Utilidades;

import sun.net.www.content.text.plain;

/**
 *
 * @author alyce
 */
public class Main {
    
    public static void main(String[] args) {
       // System.out.println("Hola");
       Pila<Integer> pila = new Pila(5);
        try {
            pila.push(5);
            pila.push(65);
            pila.push(8);
           pila.print();
            
        } catch (Exception e) {
        }
       
       ListaEnlazada<String> lista = new ListaEnlazada<>();
     
        try {
            lista.insertar("Marylin");
            
            lista.insertar("Julio");
            lista.insertar("Maria");
            lista.insertarInicio("Erick");
            lista.insertarPos("Alice",0);
            lista.imprimir();
            System.out.println("eliminar");
            System.out.println(lista.delete(0));
            lista.imprimir();
            System.out.println(lista.delete(0));
            lista.imprimir();
            
            lista.deleteAll();
            lista.imprimir();
           
            
        } catch (VacioExceptio|PosicionException e) {
            System.out.println(e.getMessage());
        }
    }
}
