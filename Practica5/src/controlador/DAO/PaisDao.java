/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.VacioExceptio;
import controlador.ed.lista.exception.PosicionException;
import java.io.IOException;


import modelo.Pais;

/**
 *
 * @author wilson7578
 */
public class PaisDao extends AdaptadorDAO<Pais> {

    private Pais pais;

    public PaisDao() {
        super(Pais.class);
    }

    public Pais getFactura() {
        if (this.pais == null) {
            this.pais = new Pais();
        }
        return pais;
    }

    public void setFactura(Pais factura) {
        this.pais = factura;
    }

    public void guardar() throws IOException {
        pais.setId(generateID());
        this.guardar(pais);
    }

    public void modificar(Integer pos) throws VacioExceptio, PosicionException, IOException {
        this.modificar(pais, pos);
    }

    private Integer generateID() {
        return listar().size() + 1;
    }
  public ListaEnlazada<Pais> ordenarNombre(ListaEnlazada<Pais> lista,  Integer tipo) {
        try {
            Pais[] matriz = lista.toArray();
            for (int i = 1; i < lista.size(); i++) {
                Pais key = matriz[i];
                int j = i - 1;
                switch(tipo){
                    case 0: 
                        
                }
                while (j >= 0 && (matriz[j].getNacionalidad().compareToIgnoreCase(key.getNacionalidad())) > 0) {
                    //lista.update(j+1, lista.get(j));
                    matriz[j + 1] = matriz[j];
                    j = j - 1;
                }
                //lista.update(j+1, key);
                matriz[j + 1] = key;
            }
            lista.toList(matriz);
        } catch (Exception e) {
        }
        return lista;
    }

    
   public ListaEnlazada<Pais> ordenarID(ListaEnlazada<Pais> lista, Integer tipo) {
        try {
            Pais[] matriz = lista.toArray();
            for (int i = 1; i < lista.size(); i++) {
                Pais key = matriz[i];
                //Auto key = lista.get(i);
                int j = i - 1;
                switch (tipo) {
                    case 0:
                        while (j >= 0 && (matriz[j].getId() > key.getId())) {
                            //lista.update(j+1, lista.get(j));
                            matriz[j + 1] = matriz[j];
                            j = j - 1;
                        }

                        break;

                    case 1:
                        while (j >= 0 && (matriz[j].getId() < key.getId())) {
                            //lista.update(j+1, lista.get(j));
                            matriz[j + 1] = matriz[j];
                            j = j - 1;
                        }
                        break;

                }
            }
            lista.toList(matriz);

        } catch (Exception e) {
        }
        return lista;
    }
     public Pais buscarPorNombre(String dato) throws VacioExceptio, PosicionException{
        Pais resultado = null;
        ListaEnlazada<Pais> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            Pais aux = lista.get(i);
            if (aux.getNacionalidad().toLowerCase().equals(dato.toLowerCase())) {
                resultado = aux;
                break;
            }
        }
        return resultado;
    }
     
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
}

