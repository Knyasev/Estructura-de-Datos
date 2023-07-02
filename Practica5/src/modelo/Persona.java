/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author wilson7578
 */
public class Persona {

    private String Cliente;
    private String Direccion;
    private String cedula;
    private Integer id;
    private Integer fecha_Nacimiento;
    private Integer id_Pais;

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String nombre) {
        this.Cliente = nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_Pais() {
        return id_Pais;
    }

    public void setId_Pais(Integer id_Pais) {
        this.id_Pais = id_Pais;
    }

    public Integer getFecha_Nacimiento() {
        return fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(Integer fecha_Nacimiento) {
        this.fecha_Nacimiento = fecha_Nacimiento;
    }

   

}
