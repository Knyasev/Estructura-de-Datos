/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.util;
import java.util.Random; 
import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioExceptio;

/**
 *
 * @author Gonzalez G
 */
public class UtilidadesVista {
    
   
       public ListaEnlazada GenerarNumerosAletorios(int num) throws VacioExceptio, PosicionException{
        ListaEnlazada<Double> randomNumbers = new ListaEnlazada<>();
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            Double randomNumber = random.nextDouble(1000);
            randomNumbers.insertar(randomNumber);
        }
        return  randomNumbers;
    
    }
}
