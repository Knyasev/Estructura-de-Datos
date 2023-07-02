/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ordenacion;
import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioExceptio;
/**
 *
 * @author wilson7578
 */
public class MergeSort {

   
     public void merge(Object objecto[], int low, int middle, int high,Integer tipo){ 
          int derechaTam = middle-low+1;
        int izquierdaTam = high - middle;
        Object derecha[] = new Object [derechaTam];
        Object izquierda[] = new Object [izquierdaTam];
        int i, j, idx;       
        for (i = 0; i < derechaTam; i++) {
            derecha[i] = objecto[low+ i];
        }
        for (i = 0; i < izquierdaTam; i++) {
            izquierda[i] = objecto[middle+ i+1];
        }
        i = 0;
        j = 0;
        idx = low;    
        if (objecto[low] instanceof Number && objecto[middle + 1] instanceof Number) {
        switch (tipo) {
            case 0:
       
                while (i < derechaTam && j < izquierdaTam) {
            if(((Number)derecha[i]).doubleValue() <= ((Number)izquierda [j]).doubleValue()) {
                objecto [idx] = derecha[ i];
                i++;
            } else {
                objecto[idx] = izquierda[j];
                j++;

            }
            idx++; 
        }
        while (i < derechaTam){
            objecto[idx] = derecha[i];
            i++;
            idx++;
        }
        while (j < izquierdaTam) {
            objecto [idx] = izquierda [j];
            j++;
            idx++;
        }
                break;
                
            case 1 :
              while (i < derechaTam && j < izquierdaTam) {
            if(((Number)derecha[i]).doubleValue() >= ((Number)izquierda [j]).doubleValue()) {
                objecto [idx] = derecha[ i];
                i++;
            } else {
                objecto[idx] = izquierda[j];
                j++;

            }
            idx++; 
        }
        while (i < derechaTam){
            objecto[idx] = derecha[i];
            i++;
            idx++;
        }
        while (j < izquierdaTam) {
            objecto [idx] = izquierda [j];
            j++;
            idx++;
        }
                
       break;
         }
        }else if (objecto[low] instanceof String && objecto[middle + 1] instanceof String) {

        switch (tipo) {
            case 0:
                while (i < derechaTam && j < izquierdaTam) {
                    if (derecha[i].toString().compareToIgnoreCase(izquierda[j].toString()) <= 0) {
                        objecto[idx] = derecha[i];
                        i++;
                    } else {
                        objecto[idx] = izquierda[j];
                        j++;
                    }
                    idx++;
                }
                break;

            case 1:
                while (i < derechaTam && j < izquierdaTam) {
                    if (derecha[i].toString().compareTo(izquierda[j].toString()) >= 0) {
                        objecto[idx] = derecha[i];
                        i++;
                    } else {
                        objecto[idx] = izquierda[j];
                        j++;
                    }
                    idx++;
                }
                break;
        }

        while (i < derechaTam) {
            objecto[idx] = derecha[i];
            i++;
            idx++;
        }

        while (j < izquierdaTam) {
            objecto[idx] = izquierda[j];
            j++;
            idx++;
        }

        }

    }

   

    public void partition(Object arreglo[], int low, int high, Integer tipo) {
        int middle;
        if (low < high) {
            middle = (low + high) / 2;
            partition(arreglo, low, middle, tipo);
            partition(arreglo, middle + 1, high, tipo);
            merge(arreglo, low, middle, high, tipo);
        }
    }
    
    public void merge(ListaEnlazada<Object> lista, int low, int middle, int high, Integer tipo) throws VacioExceptio, PosicionException {
    int derechaTam = middle - low + 1;
    int izquierdaTam = high - middle;

    ListaEnlazada<Object> derecha = new ListaEnlazada<>();
    ListaEnlazada<Object> izquierda = new  ListaEnlazada<>();

    for (int i = 0; i < derechaTam; i++) {
        derecha.insertar(lista.get(low + i));
    }

    for (int i = 0; i < izquierdaTam; i++) {
        izquierda.insertar(lista.get(middle + i + 1));
    }

    int i = 0;
    int j = 0;
    int idx = low;

    if (lista.get(low) instanceof Number && lista.get(middle + 1) instanceof Number) {
        switch (tipo) {
            case 0:
                while (i < derechaTam && j < izquierdaTam) {
                    if (((Number) derecha.get(i)).doubleValue() <= ((Number) izquierda.get(j)).doubleValue()) {
                        lista.modificar( derecha.get(i),idx);
                        i++;
                    } else {
                        lista.modificar( izquierda.get(j),idx);
                        j++;
                    }
                    idx++;
                }
                break;

            case 1:
                while (i < derechaTam && j < izquierdaTam) {
                    if (((Number) derecha.get(i)).doubleValue() >= ((Number) izquierda.get(j)).doubleValue()) {
                        lista.modificar( derecha.get(i),idx);
                        i++;
                    } else {
                        lista.modificar( izquierda.get(j),idx);
                        j++;
                    }
                    idx++;
                }
                break;
        }
    } else if (lista.get(low) instanceof String && lista.get(middle + 1) instanceof String) {
        switch (tipo) {
            case 0:
                while (i < derechaTam && j < izquierdaTam) {
                    if (derecha.get(i).toString().compareToIgnoreCase(izquierda.get(j).toString()) <= 0) {
                        lista.modificar( derecha.get(i),idx);
                        i++;
                    } else {
                        lista.modificar(izquierda.get(j),idx);
                        j++;
                    }
                    idx++;
                }
                break;

            case 1:
                while (i < derechaTam && j < izquierdaTam) {
                    if (derecha.get(i).toString().compareTo(izquierda.get(j).toString()) >= 0) {
                        lista.modificar( derecha.get(i),idx);
                        i++;
                    } else {
                        lista.modificar(izquierda.get(j),idx);
                        j++;
                    }
                    idx++;
                }
                break;
        }
    }

    while (i < derechaTam) {
        lista.modificar( derecha.get(i),idx);
        i++;
        idx++;
    }

    while (j < izquierdaTam) {
        lista.modificar(izquierda.get(j),idx);
        j++;
        idx++;
    }
}
    
    public void partition(ListaEnlazada<Object> objeto, int low, int high, Integer tipo) throws VacioExceptio, PosicionException {
        int middle;
        Object[] arreglo = objeto.toArray();
        if (low < high) {
            middle = (low + high) / 2;
            partition(arreglo, low, middle, tipo);
            partition(arreglo, middle + 1, high, tipo);
            merge(arreglo, low, middle, high, tipo);
        }
        objeto.toList(arreglo);
    }
}
