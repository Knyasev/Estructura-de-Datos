 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.modeloTabla;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioExceptio;
import controlador.util.Utilidades;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import vista.util.UtilidadesVista;

/**
 *
 * @author wilson7578
 */
public class ModeloNumerosAletorios extends AbstractTableModel {
 
    private ListaEnlazada<Object> datos = new ListaEnlazada<>();

    public ListaEnlazada<Object> getDatos() {
        return datos;
    }

    public void setDatos(ListaEnlazada<Object> datos) {
        this.datos = datos;
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public String getColumnName(int i) {

        switch (i) {
            case 0:return "NumeroAletorios";
            default: return null;
        }
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Object s = null;

        try {
            s = datos.get(i);

        } catch (PosicionException | VacioExceptio e) {
            System.out.println("Error en Lista" + e.getMessage());
        }
        switch (i1) {
            case 0: {
                return (s != null ? s: "NO DEFINIDO");
            }
            default:
                return null;
        }
    }

    
}
