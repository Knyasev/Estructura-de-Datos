/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.util;

import java.util.Iterator;
import modelo.Sucursal;
import modelo.Ventas;

/**
 *
 * @author alyce
 */
public class Utilidades {
    public static void imprimir(Object[]objs){
        System.out.println("Lista de "+objs.getClass().getSimpleName());
        for (Object o : objs) {
            System.out.println(o.toString());
        }
    }
  
    
      
}
