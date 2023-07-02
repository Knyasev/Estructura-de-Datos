/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ed.lista.exception.exception;

/**
 *
 * @author wilson7578
 */
public class TopeException extends Exception {

    public TopeException(String message) {
        super(message);
    }
    public TopeException() {
        super("limite alcanzado");
    }
}
