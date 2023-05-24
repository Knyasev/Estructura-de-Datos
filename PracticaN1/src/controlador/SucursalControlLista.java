/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioExceptio;
import controlador.exception.EspacioException;
import modelo.EnumMes;
import modelo.Reclamo;
import modelo.Sucursal;
import modelo.Ventas;

/**
 *
 * @author wilson7578
 */
public class SucursalControlLista<E> {

    ListaEnlazada<Sucursal> SucursalList;
    ListaEnlazada<Ventas> ventasList;
    ListaEnlazada<Reclamo> reclamoList;

    private Sucursal sucursal;
    private Ventas venta;
    private Reclamo reclamo;

    public SucursalControlLista() {
        reclamoList = new ListaEnlazada<>();
        SucursalList = new ListaEnlazada<>();
        ventasList = new ListaEnlazada<>();

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

    public ListaEnlazada<Ventas> getVentasList() {
        return ventasList;
    }

    public void setVentasList(ListaEnlazada<Ventas> ventasList) {
        this.ventasList = ventasList;
    }

    public Ventas getVenta() {
        if (venta == null) {
            venta = new Ventas();
        }
        return venta;
    }

    public void setVenta(Ventas venta) {
        this.venta = venta;
    }

    public Reclamo getReclamo() {
        if (reclamo == null) {
            reclamo = new Reclamo();
        }
        return reclamo;
    }

    public void setReclamo(Reclamo reclamo) {
        this.reclamo = reclamo;
    }

    public ListaEnlazada<Sucursal> getSucursalList() {
        return SucursalList;
    }

    public void setSucursalList(ListaEnlazada<Sucursal> SucursalList) {
        this.SucursalList = SucursalList;
    }

    public ListaEnlazada<Reclamo> getReclamoList() {
        return reclamoList;
    }

    public void setReclamoList(ListaEnlazada<Reclamo> reclamoList) {
        this.reclamoList = reclamoList;
    }

   

      /**
     * Permite registrar la sucursal con su respectivas ventas y con reclamo por defecto 
     * 
     */
    public boolean registrar() throws EspacioException, VacioExceptio, PosicionException {
        ventasList = new ListaEnlazada();
            sucursal.setListaEnlazada(ventasList);
               sucursal.setReclamo(reclamoList);
         sucursal.getReclamo().InsertarNodo(reclamo);
        for (int j = 0; j < EnumMes.values().length; j++) {
            Ventas v = new Ventas();
            v.setId(j + 1);
            v.setMes(EnumMes.values()[j]);
            v.setValor(0.0);
            sucursal.getListaEnlazada().InsertarNodo(v);
        }
        
        SucursalList.InsertarNodo(sucursal);
        return true;
    }

 
  /**
     * Permite modificar el valor de cada mes de las ventas anuales de la sucursal
     * 
     */
    public boolean guardarVentas(Integer posVenta, Double valor) throws EspacioException, PosicionException, VacioExceptio {

        if (this.sucursal != null) {
            if (posVenta <= this.ventasList.getSize()) {
                ventasList.get(posVenta).setValor(valor);
               
            } else {
                throw new EspacioException();
            }
        } else {
            throw new NullPointerException("Se debe elegir una sucursal");
        }
        return true;

    }
      /**
     * Permite saber cual fueron las ventas mayores de cada sucursal 
     * 
     */
    public boolean mayorVentas(Integer posVenta) throws VacioExceptio, PosicionException {
        if (this.sucursal != null) {
            
        }
            for (int i = 0; i < SucursalList.size(); i++) {
                for (int j = 0; j < sucursal.getListaEnlazada().size(); j++) {
                    if (sucursal.getListaEnlazada().get(j).getValor() >sucursal.getListaEnlazada().get(j).getValor() ) {
                        System.out.println("es mayor la sucursal "+ getSucursal().getNombre());
                    }
                }
            }
    
        return true;
    
        
}
      /**
     * Permite modificar el mensaje del reclamo
     
     */
    public void guardarReclamo ( String msj) throws VacioExceptio, PosicionException, EspacioException{
            Reclamo re = new Reclamo();
            re.setMensaje(msj);
          
          
        }
}
