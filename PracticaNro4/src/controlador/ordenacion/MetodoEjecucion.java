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
public class MetodoEjecucion {

    public static Integer ASCENDENTE = 0;
    public static Integer DESCENDENTE = 1;

    public void imprimir(Object[] m) {
        System.out.println("Imprimir Matriz");
        for (int i = 0; i < m.length; i++) {
            System.out.print(m[i].toString() + ", ");
        }
        System.out.println("\n Fin-----");
    }

    public static void main(String[] args) {
        Integer[] m = new Integer[100];
        for (int i = 0; i < m.length; i++) {
            m[i] = (int) (Math.random() * 1000);
        }
        MetodoEjecucion em = new MetodoEjecucion();
        em.imprimir(m);
        Burbuja b = new Burbuja();
        m = (Integer[]) b.burbuja(m, ASCENDENTE);
        System.out.println("Burbuja");
        em.imprimir(m);
        m = (Integer[]) b.burbuja(m, DESCENDENTE);
        System.out.println("Burbuja");
        em.imprimir(m);
        System.out.println("Strings");
        String[] n = {"alyce", "juan", "pedro", "lily", "quirola", "zambrano", "Mendoza", "Soto", "Alvarado"};
        em.imprimir(n);
        System.out.println("Burbuja Strings");
        n = (String[]) b.burbuja(n, ASCENDENTE);
        em.imprimir(n);
        Double[] d = new Double[100];
        for (int i = 0; i < d.length; i++) {
            d[i] = (Math.random() * 1000);
        }
        em.imprimir(d);
        System.out.println("Burbuja Strings");
        d = (Double[]) b.burbuja(d, ASCENDENTE);
        em.imprimir(d);
        Quicksort qs = new Quicksort();
//        
//        qs.quicksort(n, 0, n.length-1, ASCENDENTE);
//        System.out.println("hola ______");
//        em.imprimir(n);
        
        MergeSort ms = new MergeSort();
        
        ms.partition(n, 0, n.length-1, ASCENDENTE);
        em.imprimir(n);
    }

   

}
