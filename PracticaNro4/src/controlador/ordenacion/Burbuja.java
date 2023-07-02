/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.ordenacion;

/**
 *
 * @author wilson7578
 */
public class Burbuja {
    public Object[] burbuja(Object aux[], Integer tipo) {
        for (int i = 1; i < aux.length; i++) {
            for (int j = aux.length - 1; j >= i; j--) {
//                System.out.println("Tipo de dato " + aux.getClass());
                if (tipo == 0) {
                    if (aux[0].getClass().getSimpleName().equalsIgnoreCase("String")) {
                        if (aux[j].toString().compareToIgnoreCase(aux[j - 1].toString()) < 0) {
                            aux = intercambio((String[]) aux, j);
                        }
                    }else if (aux[0].getClass().getSuperclass().getSimpleName().equalsIgnoreCase("Number")){
                        if (((Number)aux[j]).doubleValue() < ((Number)aux[j - 1]).doubleValue()) {
                            aux = intercambioI((Number[])aux, j);
                        }
                    }
                } else {
                    if (aux[0].getClass().getSimpleName().equalsIgnoreCase("String")) {
                        if (aux[j].toString().compareToIgnoreCase(aux[j - 1].toString()) > 0) {
                            aux = intercambio((String[]) aux, j);
                        }
                    }else if (aux[0].getClass().getSuperclass().getSimpleName().equalsIgnoreCase("Number")){
                        if (((Number)aux[j]).doubleValue() > ((Number)aux[j - 1]).doubleValue()) {
                            aux = intercambioI((Number[])aux, j);
                        }
                    }
                }
            }
        }
        return aux;
    }


    private Number[] intercambioI(Number[] aux, Integer j) {
        Number a = aux[j - 1];
        aux[j - 1] = aux[j];
        aux[j] = a;
        return aux;
    }


    private String[] intercambio(String[] aux, Integer j) {
        String a = aux[j - 1];
        aux[j - 1] = aux[j];
        aux[j] = a;
        return aux;}
   

}
