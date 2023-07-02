/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.util;

import controlador.DAO.AdaptadorDAO;
import controlador.DAO.PaisDao;
import controlador.DAO.PersonaDao;
import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.VacioExceptio;
import controlador.ed.lista.exception.PosicionException;
import javax.swing.JComboBox;
import modelo.Pais;


/**
 *
 * @author wilson7578
 */
public class Utilidades{
  
    
     public static void cargarFactura(JComboBox cbx ,PaisDao fd) throws VacioExceptio, PosicionException{
        cbx.removeAllItems();
        ListaEnlazada<Pais> lista = fd.ordenarNombre(fd.listar(), AdaptadorDAO.ASCENDENTE);
        for (int i = 0; i < lista.size(); i++) {
            cbx.addItem(lista.get(i).getNacionalidad());
            
            
        }
        
        
    }
    
    
}
