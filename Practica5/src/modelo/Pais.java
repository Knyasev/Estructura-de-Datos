/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author wilson7578
 */
public class Pais {
    private Integer id ;
    private String nacionalidad;
    private boolean estado ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    

   

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String tipo) {
        this.nacionalidad = tipo;
    }

    @Override
    public String toString() {
        return nacionalidad;
    }
    
}

