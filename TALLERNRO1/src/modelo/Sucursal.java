/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author wilson7578
 */
public class Sucursal {
    private Integer id;
    private String nombre;
    private Ventas[] ventas;

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

    public Ventas[] getVentas() {
        return ventas;
    }

    public void setVentas(Ventas[] ventas) {
        this.ventas = ventas;
    }

    @Override
    public String toString() {
        return nombre + " "+id;
    }
    
    
    
    
    
}
