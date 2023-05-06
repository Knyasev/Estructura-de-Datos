/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.exception.EspacioException;
import modelo.EnumMes;
import modelo.Sucursal;
import modelo.Ventas;

/**
 *
 * @author wilson7578
 */
public class SucursalControl {
    private Sucursal[] sucursales;
    private Sucursal sucursal;
    private Ventas venta;

    public Ventas getVenta() {
        return venta;
    }

    public void setVenta(Ventas venta) {
        this.venta = venta;
    }
    
    

    public SucursalControl() {
        sucursales = new Sucursal[4];
        
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

    public Sucursal[] getSucursales() {
        return sucursales;
    }

    public void setSucursales(Sucursal[] sucursales) {
        this.sucursales = sucursales;
    }
    
    
    
    public boolean registrar() throws EspacioException{
        int pos = -1;
        int cont = -1;
        for (Sucursal s : sucursales) {
            cont++;
            
            if (s == null) {
                pos = cont;
                break;
            }
        }
        if (pos == -1) {
            throw new EspacioException();
        }
            sucursal.setVentas(new Ventas[EnumMes.values().length]);
            for (int i = 0; i < EnumMes.values().length; i++) {
                Ventas venta = new Ventas();
                venta.setId(i+1);
                venta.setMes(EnumMes.values()[i]);
                venta.setValor(0.0);
                sucursal.getVentas()[i] = venta;
            }
        
        sucursales[pos]= sucursal;
        
    return true;
    }
    
    
    
    public boolean guardarVentas(Integer posVenta, Double valor) throws EspacioException{
        
//        sucursales[posSucur].getVentas()[posVenta].setValor(valor);
//        return true;
      if (this.sucursal != null) {
              if (posVenta <= this.sucursal.getVentas().length -1) 
                  sucursal.getVentas()[posVenta].setValor(valor);
              else 
              throw new EspacioException();
            
        }else 
              throw new NullPointerException("Se debe elegir una sucursal");
          return true;
          
          

        
    }
    

    public boolean calcularPromedio(Double totalVentas,Enum enumMes){
        if (totalVentas ==null) {
            System.out.println("El total de ventas es cero");
            
        }
           
        return true;
    }
}
