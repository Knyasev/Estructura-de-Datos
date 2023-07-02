/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.Busqueda;

import controlador.ed.lista.ListaEnlazada;
import controlador.ordenacion.Quicksort;

/**
 *
 * @author wilson7578
 */
public class BusquedaBinaria {

    public Object busquedaBinaria(Object[] elementos, Object x) {
        int l = 0, r = elementos.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (elementos[m] instanceof Number) {
                Object arreglo = (Number) elementos[m];
                if (((Number) arreglo).doubleValue() == ((Number) x).doubleValue()) {
                    return arreglo;
                }

                if (((Number) arreglo).doubleValue() < ((Number) x).doubleValue()) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }

            } else if (elementos[m] instanceof String) {
                Object arreglos = (String) elementos[m];

                if (arreglos.toString().equals(x.toString())) {
                    return arreglos;
                }

                if (arreglos.toString().compareToIgnoreCase(x.toString()) <= 0) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }

        }
        return null;
    }
    
    
public static Object busquedaBinaria(ListaEnlazada<Object> elementos, Object x) {
    int l = 0, r = elementos.size() - 1;
    try {
         while (l <= r) {
        int m = l + (r - l) / 2;

        if (elementos.get(m) instanceof Number) {
            Object arreglo = (Number) elementos.get(m);
            if (((Number) arreglo).doubleValue() == ((Number) x).doubleValue()) {
                return arreglo;
            }

            if (((Number) arreglo).doubleValue() < ((Number) x).doubleValue()) {
                l = m + 1;
            } else {
                r = m - 1;
            }

        } else if (elementos.get(m) instanceof String) {
            Object arreglos = (String) elementos.get(m);

            if (arreglos.toString().equals(x.toString())) {
                return arreglos;
            }

            if (arreglos.toString().compareToIgnoreCase(x.toString()) <= 0) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
    } 
    } catch (Exception e) {
    }
  

    return null;
}
      public static int busqueda(ListaEnlazada<Object> elementos, Object x) {
          try {
              
        boolean ordenado = true;
              if (elementos.get(0) instanceof Number) {
               for (int i = 0; i < elementos.size() - 1; i++) {
            if (((Number)x).doubleValue()<((Number)elementos.get(i)).doubleValue()) {
                ordenado = false;
                
                break;
            }
            
        }   
              }else if (elementos.get(0) instanceof String) {
                  for (int i = 0; i < elementos.size() - 1; i++) {
            if (x.toString().compareToIgnoreCase((String)elementos.get(i)) < 0) {
                ordenado = false;
                
                break;
            }
            
        } 
              }
       

        if (ordenado) {
            busquedaBinaria(elementos, x);
        } else {
            busquedaSecuencial(elementos, x);
        } 
          } catch (Exception e) {
          }
      

        return -1; // Valor no encontrado
    }

    public static Object busquedaSecuencial(ListaEnlazada<Object> elementos, Object x) {
        try {
          for (int i = 0; i < elementos.size(); i++) {
        if (elementos.get(i).equals(x)) {
            return elementos.get(i);
        }
    }  
        } catch (Exception e) {
        }
        
    return null; // Valor no encontrado
}
     public static int busqueda(Object[] elementos, Comparable x) {
        int l = 0, r = elementos.length - 1;
        boolean ordenado = true;
        for (int i = 0; i < elementos.length - 1; i++) {
            if (x.compareTo(elementos[i]) < 0) {
                ordenado = false;
                break;
            }
        }

        if (ordenado) {
            while (l <= r) {
                int m = l + (r - l) / 2;
                int comparacion = x.compareTo(elementos[m]);
                if (comparacion == 0) {
                    return m;
                }
                if (comparacion < 0) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        } else {
            for (int i = 0; i < elementos.length; i++) {
                if (elementos[i].equals(x)) {
                    return i;
                }
            }
        }

        return -1; // Valor no encontrado
    }

    public static void main(String args[]) {
        BusquedaBinaria bb = new BusquedaBinaria();
        Integer elementos[] = {1, 2, 4, 10, 50,9 , 9, 9, 9,11,12};
        String[] m = {"alyce","alyce","juan","pedro","zambrano","Mendoza","Soto","Alvarado","alyce","zambrano","lilo","lilo","quirola"};
        Quicksort qs = new Quicksort();
        qs.quicksort(m, 0, m.length-1, 0);
        qs.quicksort(elementos, 0, elementos.length-1, 0);
        String buscar ="lilo";
        int n = elementos.length;
        Integer x = 50;
         bb.busquedaBinaria(elementos, x);
            bb.busquedaBinaria(m, buscar);

        System.out.println(bb.busquedaBinaria(m, buscar));
        System.out.println(bb.busquedaBinaria(elementos, x));
        
         Integer[] numeros = {1, 2, 3, 4, 5};
        String[] palabras = {"manzana", "banana", "cereza", "dátil", "uva"};

        int indiceNum = busqueda(numeros,5);
        
        try {
           ListaEnlazada lista = new ListaEnlazada();
           
           
           lista.insertar("sSS");
           lista.insertar("ass");
           lista.insertar("sddd");
           lista.insertar("bva");
           lista.insertar("zzaa");
           qs.quicksort(lista, 0, lista.size()-1, 0);
           String g= "ASS";
           busqueda(lista,g);
            System.out.println( busqueda(lista,g));
           lista.imprimir();
        } catch (Exception e) {
        }
 
//        System.out.println("Búsqueda - Número: " + indiceNum);
//        System.out.println("Búsqueda - Palabra: " + busqueda(palabras, "cereza"));
    }
}
