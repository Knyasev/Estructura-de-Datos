/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modeloTabla;

/**
 *
 * @author wilson7578
 */
public class ModeloTablaSucursal extends AbstractTableModel{
    private ListaEnlazada<Sucursal> lista = new ListaEnlazada<>();
    

    public void setLista(ListaEnlazada<Sucursal> lista) {
        this.lista = lista;
    }
  
    public ListaEnlazada<Sucursal> getLista() {
        return lista;
    }
   
    
    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public String getColumnName(int i) {
        
        switch(i) {
            case 0: return "Nombre";
            case 1: return "Venta Anual";    
            case 2: return "Promedio de ventas";    
            default: return null;
        }
    }

    @Override
    public Object getValueAt(int i,int i1) {
        Sucursal s = null;
        try{
            s = lista.get(i);
        }  
        } catch (Exception e) {
    
        }
        switch(i1) {
            case 0: return (s != null ? s.getNombre(): "NO DEFINIDO");
            case 1: return (s != null) ? Utilidades.sumarVentas(s) : 0.0;    
            case 2: return (s != null) ? Utilidades.mediaVentas(s) : 0.0;   
            default: return null;
    }
                }

