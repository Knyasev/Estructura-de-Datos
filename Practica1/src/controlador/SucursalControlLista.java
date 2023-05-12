/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.VacioExceptio;
import controlador.exception.EspacioException;
import modelo.EnumMes;
import modelo.Sucursal;
import modelo.Ventas;

/**
 *
 * @author wilson7578
 */
public class SucursalControlLista {
    ListaEnlazada<Sucursal> SucursalList;
    private Sucursal sucursal;
    private Ventas venta;

    
    
  

    public SucursalControlLista() {
        SucursalList = new ListaEnlazada<>();
      
    }

    
  

    public Sucursal getSucursal() {
         if (sucursal == null) {
            sucursal = new Sucursal();
        }
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public ListaEnlazada<Sucursal> getSucursalList() {
        return SucursalList;
    }

    public void setSucursalList(ListaEnlazada<Sucursal> SucursalList) {
        this.SucursalList = SucursalList;
    }


    public Ventas getVenta() {
        return venta;
    }

    public void setVenta(Ventas venta) {
        this.venta = venta;
    }

    public boolean registrar() throws EspacioException, VacioExceptio{      
        ListaEnlazada<Ventas> ventasListaEnlazada = new ListaEnlazada<>();
   

            sucursal.setVentas(new Ventas[EnumMes.values().length]);
            for (int i = 0; i < EnumMes.values().length; i++) {
                Ventas venta = new Ventas();
                venta.setId(i+1);
                venta.setMes(EnumMes.values()[i]);
                venta.setValor(0.0);
               sucursal.getVentas()[i] = venta;
               SucursalList.InsertarNodo(ventasListaEnlazada);
            }
        SucursalList.InsertarNodo(sucursal);
        SucursalList.imprimir();
        return true;
    }

    public boolean guardarVentas(Integer posVenta, Double valor) throws EspacioException{
        
//        sucursales[posSucur].getVentas()[posVenta].setValor(valor);
//  
          return true;
          
          

        
    }
    

    public boolean calcularPromedio(Double totalVentas,Enum enumMes){
        if (totalVentas ==null) {
            System.out.println("El total de ventas es cero");
            
        }
           
        return true;
    }
}
