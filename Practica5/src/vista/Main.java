/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.DAO.AdaptadorDAO;
import controlador.DAO.PaisDao;
import controlador.ed.lista.exception.VacioExceptio;
import java.io.IOException;
import modelo.Pais;

/**
 *
 * @author wilson7578
 */
public class Main {
     public static void main(String[] args) throws IOException {
        try {
         
            PaisDao fd = new PaisDao();
            fd.getFactura().setNacionalidad("Peruano");
            fd.getFactura().setEstado(Boolean.TRUE);
          
            fd.guardar();
            fd.setFactura(null);
            fd.listar().imprimir();
            System.out.println(fd.obtener(1));
        } catch (VacioExceptio e) {
            System.out.println(e); 
        }
    }
}
