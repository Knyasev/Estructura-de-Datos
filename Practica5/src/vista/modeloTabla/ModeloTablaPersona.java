/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.modeloTabla;

import controlador.DAO.PaisDao;

import controlador.ed.lista.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Persona;

/**
 *
 * @author wilson7578
 */
public class ModeloTablaPersona extends AbstractTableModel {
    ListaEnlazada<Persona> datos = new ListaEnlazada<>();

    public ListaEnlazada<Persona> getDatos() {
        return datos;
    }

    public void setDatos(ListaEnlazada<Persona> datos) {
        this.datos = datos;
    }
    
    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
       return 6;
    }

    @Override
    public Object getValueAt(int arg0, int arg1) {
        Persona a = null;
        try{
            a = datos.get(arg0);
        }catch(Exception e){
            
        }
        switch(arg1){
            case 0: return (arg0+1);
            case 1: return (a != null) ? a.getCliente(): "No definido";
            case 2: return (a != null) ? a.getCedula(): "No definido";
            case 3: return (a != null) ? a.getDireccion(): "No definido";
            case 4: return (a != null) ? a.getFecha_Nacimiento(): "No definido";
            case 5: return (a != null) ? new PaisDao().obtener(a.getId_Pais()) : "No definido";
            default: return null;
        }
    }
    
     @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Nro";
            case 1: return "Cliente";
            case 2: return "Cedula";
            case 3: return "Direccion";
            case 4: return "Año";
            case 5: return "Pais";
            default: return null;
        }
    }
    
}
