/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.SucursalControl;
import controlador.util.Utilidades;
import modelo.EnumMes;
import modelo.Sucursal;

/**
 *
 * @author wilson7578
 */
public class Main {
    
    public static void main(String[] args) {
       // System.out.println("Hola");
       SucursalControl sc = new SucursalControl(); 
       try {
        

        sc.getSucursal().setId(1);
        sc.getSucursal().setNombre("Wilson");
        sc.registrar();
        
        sc.setSucursal(null);
        
        sc.getSucursal().setId(2);
        sc.getSucursal().setNombre("Jose");
        sc.registrar();
 
        Utilidades.imprimir(sc.getSucursal().getVentas());
        sc.setSucursal(null);

        
        sc.getSucursal().setId(3);
        sc.getSucursal().setNombre("Carlos");
        sc.registrar();
        sc.setSucursal(null);
        
        sc.getSucursal().setId(4);
        sc.getSucursal().setNombre("Peter");
        sc.registrar();
        
        //System.out.println(sc.getSucursal().getVentas());
        Utilidades.imprimir(sc.getSucursal().getVentas());
        sc.setSucursal(null);
      
        
        Utilidades.imprimir(sc.getSucursales());
    
           System.out.println("OOOOO");
        } catch (Exception e) {
            System.out.println("Error"+" "+e.getMessage());
        }
        
    }
}
