/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.modeloTabla;

import controlador.util.Utilidades;
import javax.swing.table.AbstractTableModel;
import modelo.Sucursal;
import modelo.Ventas;

/**
 *
 * @author alyce
 */
public class ModeloTablaVenta extends AbstractTableModel{
    private Ventas [] datos = new Ventas[12];

    public Ventas[] getDatos() {
        return datos;
    }

    public void setDatos(Ventas[] datos) {
        this.datos = datos;
    }

    
    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return datos.length;
    }

    @Override
    public String getColumnName(int i) {
        
        switch(i) {
            case 0: return "Mes";
            case 1: return "Valor";       
            default: return null;
        }
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Ventas v = datos[i];
        switch(i1) {
            case 0: return (v != null ? v.getMes().toString(): "NO DEFINIDO");
            case 1: return (v != null) ? v.getValor() : 0.0;    
            default: return null;
        }
    }
}
