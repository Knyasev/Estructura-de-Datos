/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.ordenacion;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioExceptio;


/**
 *
 * @author wilson7578
 */
public class Quicksort {

   

    public void quicksort(ListaEnlazada<Object> lista, int izquierda, int derecha, Integer tipo) throws VacioExceptio, PosicionException {

        if (izquierda < derecha) {
            Object indiceParticion = particion(lista, izquierda, derecha, tipo);
            quicksort(lista, izquierda, (int) indiceParticion, tipo);
            quicksort(lista, (int) indiceParticion + 1, derecha, tipo);
        }

    }

    private Object particion(ListaEnlazada<Object> lista, int izquierda, int derecha, Integer tipo) throws VacioExceptio, PosicionException {
        Object PrimerElemento = lista.get(izquierda);
        if (PrimerElemento instanceof Number) {
            
            switch (tipo) {
                case 0:
                    Object pivote = (Number) PrimerElemento;
                    while (true) {
                        while (((Number) lista.get(izquierda)).doubleValue() < ((Number) pivote).doubleValue()) {
                            izquierda++;
                        }
                        while (((Number) lista.get(derecha)).doubleValue() > ((Number) pivote).doubleValue()) {
                            derecha--;
                        }
                        if (izquierda >= derecha) {
                            return derecha;
                        } else {
                            Object temporal = lista.get(izquierda);
                            lista.modificar(lista.get(derecha), izquierda);
                            lista.modificar(temporal, derecha);
                            izquierda++;
                            derecha--;
                        }
                    }
                case 1:
                    Object pivoteD = (Number) PrimerElemento;
                    while (true) {
                        while (((Number) lista.get(izquierda)).doubleValue() > ((Number) pivoteD).doubleValue()) {
                            izquierda++;
                        }
                        while (((Number) lista.get(derecha)).doubleValue() < ((Number) pivoteD).doubleValue()) {
                            derecha--;
                        }
                        if (izquierda >= derecha) {
                            return derecha;
                        } else {
                            Object temporal = lista.get(izquierda);
                            lista.modificar(lista.get(derecha), izquierda);
                            lista.modificar(temporal, derecha);
                            izquierda++;
                            derecha--;
                        }
                    }
            }

        } else if (PrimerElemento instanceof String) {

            switch (tipo) {
                case 0:
                    Object pivote = (String) PrimerElemento;
                    while (true) {
                        while (lista.get(izquierda).toString().compareToIgnoreCase(pivote.toString()) < 0) {
                            izquierda++;
                        }
                        while (lista.get(derecha).toString().compareToIgnoreCase(pivote.toString()) > 0) {
                            derecha--;
                        }
                        if (izquierda >= derecha) {
                            return derecha;
                        } else {
                            Object temporal = lista.get(izquierda);
                            lista.modificar(lista.get(derecha), izquierda);
                            lista.modificar(temporal, derecha);
                            izquierda++;
                            derecha--;
                        }
                    }
                case 1:
                    Object pivoteD = (String) PrimerElemento;
                    while (true) {
                        while (lista.get(izquierda).toString().compareToIgnoreCase(pivoteD.toString()) > 0) {
                            izquierda++;
                        }
                        while (lista.get(derecha).toString().compareToIgnoreCase(pivoteD.toString()) < 0) {
                            derecha--;
                        }
                        if (izquierda >= derecha) {
                            return derecha;
                        } else {
                            Object temporal = lista.get(izquierda);
                            lista.modificar(lista.get(derecha), izquierda);
                            lista.modificar(temporal, derecha);
                            izquierda++;
                            derecha--;
                        }
                    }

            }

        }
        return lista;
    }

    public void quicksort(Object arreglo[], int izquierda, int derecha, Integer tipo) {

        if (izquierda < derecha) {
            Object indiceParticion = particion(arreglo, izquierda, derecha, tipo);
            quicksort(arreglo, izquierda, (int) indiceParticion, tipo);
            quicksort(arreglo, (int) indiceParticion + 1, derecha, tipo);
        }

    }
    public void quicksortL(ListaEnlazada<Object> lista, int izquierda, int derecha, Integer tipo) throws VacioExceptio, PosicionException {
           Object [] arreglo = lista.toArray();
        if (izquierda < derecha) {
            Object indiceParticion = particionL(lista, izquierda, derecha, tipo);
            quicksort(arreglo, izquierda, (int) indiceParticion, tipo);
            quicksort(arreglo, (int) indiceParticion + 1, derecha, tipo);
        
        }
        lista.toList(arreglo);

    }

    private Object particion(Object[] arreglo, int izquierda, int derecha, Integer tipo) {
        Object PrimerElemento = arreglo[izquierda];
        if (PrimerElemento instanceof Number) {
            switch (tipo) {
                case 0:
                    Object pivote = (Number) PrimerElemento;
                    while (true) {
                        while (((Number) arreglo[izquierda]).doubleValue() < ((Number) pivote).doubleValue()) {
                            izquierda++;
                        }
                        while (((Number) arreglo[derecha]).doubleValue() > ((Number) pivote).doubleValue()) {
                            derecha--;
                        }
                        if (izquierda >= derecha) {
                            return derecha;
                        } else {
                            Object temporal = arreglo[izquierda];
                            arreglo[izquierda] = arreglo[derecha];
                            arreglo[derecha] = temporal;
                            izquierda++;
                            derecha--;
                        }
                    }
                case 1:
                    Object pivoteD = (Number) PrimerElemento;
                    while (true) {
                        while (((Number) arreglo[izquierda]).doubleValue() > ((Number) pivoteD).doubleValue()) {
                            izquierda++;
                        }
                        while (((Number) arreglo[derecha]).doubleValue() < ((Number) pivoteD).doubleValue()) {
                            derecha--;
                        }
                        if (izquierda >= derecha) {
                            return derecha;
                        } else {
                            Object temporal = arreglo[izquierda];
                            arreglo[izquierda] = arreglo[derecha];
                            arreglo[derecha] = temporal;
                            izquierda++;
                            derecha--;
                        }
                    }
            }

        } else if (PrimerElemento instanceof String) {

            switch (tipo) {
                case 0:
                    Object pivote = (String) PrimerElemento;
                    while (true) {
                        while (arreglo[izquierda].toString().compareToIgnoreCase(pivote.toString()) < 0) {
                            izquierda++;
                        }
                        while (arreglo[derecha].toString().compareToIgnoreCase(pivote.toString()) > 0) {
                            derecha--;
                        }
                        if (izquierda >= derecha) {
                            return derecha;
                        } else {
                            Object temporal = arreglo[izquierda];
                            arreglo[izquierda] = arreglo[derecha];
                            arreglo[derecha] = temporal;
                            izquierda++;
                            derecha--;
                        }
                    }
                case 1:
                    Object pivoteD = (String) PrimerElemento;
                    while (true) {
                        while (arreglo[izquierda].toString().compareToIgnoreCase(pivoteD.toString()) > 0) {
                            izquierda++;
                        }
                        while (arreglo[derecha].toString().compareToIgnoreCase(pivoteD.toString()) < 0) {
                            derecha--;
                        }
                        if (izquierda >= derecha) {
                            return derecha;
                        } else {
                            Object temporal = arreglo[izquierda];
                            arreglo[izquierda] = arreglo[derecha];
                            arreglo[derecha] = temporal;
                            izquierda++;
                            derecha--;
                        }
                    }

            }

        }
        return arreglo;
    }

    
    
    private Object particionL(ListaEnlazada<Object> lista, int izquierda, int derecha, Integer tipo) {
        Object[] arreglo = lista.toArray();
        Object PrimerElemento = arreglo[izquierda];
        if (PrimerElemento instanceof Number) {
            
            for (int i = 0; i < lista.size(); i++) {
                 switch (tipo) {
                case 0:
                    Object pivote = (Number) PrimerElemento;
                    while (true) {
                        while (((Number) arreglo[izquierda]).doubleValue() < ((Number) pivote).doubleValue()) {
                            izquierda++;
                        }
                        while (((Number) arreglo[derecha]).doubleValue() > ((Number) pivote).doubleValue()) {
                            derecha--;
                        }
                        if (izquierda >= derecha) {
                            return derecha;
                        } else {
                            Object temporal = arreglo[izquierda];
                            arreglo[izquierda] = arreglo[derecha];
                            arreglo[derecha] = temporal;
                            izquierda++;
                            derecha--;
                        }
                         
                    }
               
                case 1:
                    Object pivoteD = (Number) PrimerElemento;
                    while (true) {
                        while (((Number) arreglo[izquierda]).doubleValue() > ((Number) pivoteD).doubleValue()) {
                            izquierda++;
                        }
                        while (((Number) arreglo[derecha]).doubleValue() < ((Number) pivoteD).doubleValue()) {
                            derecha--;
                        }
                        if (izquierda >= derecha) {
                            return derecha;
                        } else {
                            Object temporal = arreglo[izquierda];
                            arreglo[izquierda] = arreglo[derecha];
                            arreglo[derecha] = temporal;
                            izquierda++;
                            derecha--;
                        }
                    }
            } 
            }
          lista.toList(arreglo);

        } else if (PrimerElemento instanceof String) {
            for (int i = 0; i < lista.size(); i++) {
               switch (tipo) {
                case 0:
                    Object pivote = (String) PrimerElemento;
                    while (true) {
                        while (arreglo[izquierda].toString().compareToIgnoreCase(pivote.toString()) < 0) {
                            izquierda++;
                        }
                        while (arreglo[derecha].toString().compareToIgnoreCase(pivote.toString()) > 0) {
                            derecha--;
                        }
                        if (izquierda >= derecha) {
                            return derecha;
                        } else {
                            Object temporal = arreglo[izquierda];
                            arreglo[izquierda] = arreglo[derecha];
                            arreglo[derecha] = temporal;
                            izquierda++;
                            derecha--;
                        }
                    }
                case 1:
                    Object pivoteD = (String) PrimerElemento;
                    while (true) {
                        while (arreglo[izquierda].toString().compareToIgnoreCase(pivoteD.toString()) > 0) {
                            izquierda++;
                        }
                        while (arreglo[derecha].toString().compareToIgnoreCase(pivoteD.toString()) < 0) {
                            derecha--;
                        }
                        if (izquierda >= derecha) {
                            return derecha;
                        } else {
                            Object temporal = arreglo[izquierda];
                            arreglo[izquierda] = arreglo[derecha];
                            arreglo[derecha] = temporal;
                            izquierda++;
                            derecha--;
                        }
                    }

            }
lista.toList(arreglo);
            }
           
        }
        return arreglo;
    }
    
    public void quickSort(ListaEnlazada<Object> lista, int izq, int der, Integer tipo) {
        Object numerosAOrdenar[] ;
        numerosAOrdenar = lista.toArray();
        
        Object pivote = numerosAOrdenar[izq];
        if (pivote instanceof Number) {
        int i = izq;
        int j = der;
        Number auxiliar;
            switch (tipo) {
                case 0:
                  
                    while (i < j) {
                        while (((Number) numerosAOrdenar[i]).doubleValue() <= ((Number) pivote).doubleValue() && i < j) {
                            i++;
                        }
                        while (((Number) numerosAOrdenar[j]).doubleValue() > ((Number) pivote).doubleValue()) {
                            j--;
                        }
                        if (i < j) {
                            auxiliar = (Number) numerosAOrdenar[i];
                            numerosAOrdenar[i] = numerosAOrdenar[j];
                            numerosAOrdenar[j] = auxiliar;
                        }
                    }

                    numerosAOrdenar[izq] = numerosAOrdenar[j];
                    numerosAOrdenar[j] = pivote;
                     lista.toList(numerosAOrdenar);
                    if (izq < j - 1) {
                       
                        quickSort( lista, izq, j - 1, tipo);
                    }
                    if (j + 1 < der) {
                        quickSort( lista, j + 1, der, tipo);
                    } 
                   
                case 1:
                    while (i < j) {
                        while (((Number) numerosAOrdenar[i]).doubleValue() >= ((Number) pivote).doubleValue() && i < j) {
                            i++;
                        }
                        while (((Number) numerosAOrdenar[j]).doubleValue() < ((Number) pivote).doubleValue()) {
                            j--;
                        }
                        if (i < j) {
                            auxiliar = (Number) numerosAOrdenar[i];
                            numerosAOrdenar[i] = numerosAOrdenar[j];
                            numerosAOrdenar[j] = auxiliar;
                        }
                    }

                    numerosAOrdenar[izq] = numerosAOrdenar[j];
                    numerosAOrdenar[j] = pivote;
                    lista.toList(numerosAOrdenar);
                    if (izq < j - 1) {
                        quickSort(lista, izq, j - 1, tipo);
                    }
                    if (j + 1 < der) {
                        quickSort( lista, j + 1, der, tipo);
                    }
                     
            }
        } else if (pivote instanceof String) {
             Object pivoteS = numerosAOrdenar[izq];
            int i = izq;
        int j = der;
        String auxiliar;
            switch (tipo) {
                case 0:
                    while (i < j) {
                        while ((numerosAOrdenar[i]).toString().compareToIgnoreCase(pivoteS.toString()) <= 0 && i < j) {
                            i++;
                        }
                        while ((numerosAOrdenar[j]).toString().compareToIgnoreCase(pivoteS.toString()) > 0) {
                            j--;
                        }
                        if (i < j) {
                            auxiliar = (String) numerosAOrdenar[i];
                            numerosAOrdenar[i] = numerosAOrdenar[j];
                            numerosAOrdenar[j] = auxiliar;
                        }
                    }

                    numerosAOrdenar[izq] = numerosAOrdenar[j];
                    numerosAOrdenar[j] = pivoteS;
                    lista.toList(numerosAOrdenar);
                    if (izq < j - 1) {
                        quickSort(lista, izq, j - 1, tipo);
                    }
                    if (j + 1 < der) {
                        quickSort(lista, j + 1, der, tipo);
                    } 
                    
                case 1:
                     while (i < j) {
                        while ((numerosAOrdenar[i]).toString().compareToIgnoreCase(pivoteS.toString()) >= 0 && i < j) {
                            i++;
                        }
                        while ((numerosAOrdenar[j]).toString().compareToIgnoreCase(pivoteS.toString()) < 0) {
                            j--;
                        }
                        if (i < j) {
                            auxiliar = (String) numerosAOrdenar[i];
                            numerosAOrdenar[i] = numerosAOrdenar[j];
                            numerosAOrdenar[j] = auxiliar;
                        }
                    }

                    numerosAOrdenar[izq] = numerosAOrdenar[j];
                    numerosAOrdenar[j] = pivoteS;
                     lista.toList(numerosAOrdenar);    
                    if (izq < j - 1) {
                        quickSort(lista, izq, j - 1, tipo);
                    }
                    if (j + 1 < der) {
                        quickSort(lista, j + 1, der, tipo);
                    } 
                    
            }

        }
    }
}
