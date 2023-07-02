/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.VacioExceptio;
import controlador.ed.lista.exception.PosicionException;
import controlador.ordenacion.Quicksort;
import java.io.IOException;
import modelo.Pais;
import modelo.Persona;

/**
 *
 * @author wilson7578
 */
public class PersonaDao extends AdaptadorDAO<Persona> {

    private Persona persona;

    public PersonaDao() {
        super(Persona.class);
    }

    public Persona getPersona() {
        if (this.persona == null) {
            this.persona = new Persona();
        }
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void guardar() throws IOException {
        persona.setId(generateID());
        this.guardar(persona);
    }

    public void modificar(Integer pos) throws VacioExceptio, PosicionException, IOException {
        this.modificar(persona, pos);
    }

    private Integer generateID() {
        return listar().size() + 1;
    }

    public ListaEnlazada<Persona> buscarPorNombresOrdenado(String dato) throws VacioExceptio, PosicionException {
        ListaEnlazada<Persona> lista = listar();
        quicksortNombres(lista, 0, lista.size() - 1);
        return busquedaBinariaNombres(lista, dato);
    }

    public ListaEnlazada<Persona> quicksortNombres(ListaEnlazada<Persona> lista, int izquierda, int derecha) throws VacioExceptio, PosicionException {
        if (izquierda < derecha) {
            int indicePivote = particionNombres(lista, izquierda, derecha);
            quicksortNombres(lista, izquierda, indicePivote - 1);
            quicksortNombres(lista, indicePivote + 1, derecha);
        }
        return lista;
    }

    private int particionNombres(ListaEnlazada<Persona> lista, int izquierda, int derecha) throws VacioExceptio, PosicionException {
        Persona pivote = lista.get(derecha);
        int indicePivote = izquierda;

        for (int i = izquierda; i < derecha; i++) {
            if (lista.get(i).getCliente().compareToIgnoreCase(pivote.getCliente()) < 0) {
                Persona temp = lista.get(indicePivote);
                lista.modificar(lista.get(i), indicePivote);
                lista.modificar(temp, i);
                indicePivote++;
            }
        }

        Persona temp = lista.get(indicePivote);
        lista.modificar(lista.get(derecha), indicePivote);
        lista.modificar(temp, derecha);

        return indicePivote;
    }

    public ListaEnlazada<Persona> buscarPorNombresSyB(String dato) throws VacioExceptio, PosicionException {
        ListaEnlazada<Persona> lista = listar();
        quicksortNombres(lista, 0, lista.size() - 1);
        return busquedaSecuencialYBinariaNombre(lista, dato);
    }

    public ListaEnlazada<Persona> busquedaBinariaNombres(ListaEnlazada<Persona> lista, String dato) throws VacioExceptio, PosicionException {
        ListaEnlazada<Persona> resultado = new ListaEnlazada<>();
        int l = 0;
        int r = lista.size() - 1;

        while (l <= r) {
            int mitad = l + (r - l) / 2;
            String nombreMitad = lista.get(mitad).getCliente().toLowerCase();

            if (nombreMitad.startsWith(dato.toLowerCase())) {
                resultado.insertar(lista.get(mitad));
                break;
            }

            if (nombreMitad.compareToIgnoreCase(dato.toLowerCase()) < 0) {
                l = mitad + 1;
            } else {
                r = mitad - 1;
            }
        }

        return resultado;
    }

    public ListaEnlazada<Persona> busquedaSecuencialYBinariaNombre(ListaEnlazada<Persona> lista, String dato) throws VacioExceptio, PosicionException {
        ListaEnlazada<Persona> resultado = new ListaEnlazada<>();

        // Búsqueda secuencial
        for (int i = 0; i < lista.size(); i++) {
            String nombre = lista.get(i).getCliente().toLowerCase();
            if (nombre.startsWith(dato.toLowerCase())) {
                resultado.insertar(lista.get(i));
            } else if (nombre.compareToIgnoreCase(dato.toLowerCase()) > 0) {
                // Si el nombre es mayor al dato, se detiene la búsqueda secuencial porque los nombres están ordenados.
                break;
            }
        }

        // Búsqueda binaria
        int l = 0;
        int r = lista.size() - 1;

        while (l <= r) {
            int mitad = l + (r - l) / 2;
            String nombreMitad = lista.get(mitad).getCliente().toLowerCase();

            if (nombreMitad.startsWith(dato.toLowerCase())) {
                // Ya se insertó en la búsqueda secuencial, se omite para evitar duplicados.
                break;
            }

            if (nombreMitad.compareToIgnoreCase(dato.toLowerCase()) < 0) {
                l = mitad + 1;
            } else {
                r = mitad - 1;
            }
        }
        // Continuar la búsqueda binaria hacia la izquierda para encontrar más coincidencias
        while (r >= 0) {
            String nombreR = lista.get(r).getCliente().toLowerCase();
            if (nombreR.startsWith(dato.toLowerCase())) {
                resultado.insertar(lista.get(r));
            } else {
                break;
            }
            r--;
        }

        return resultado;
    }

    public ListaEnlazada<Persona> buscarPorDireccionSyB(String dato) throws VacioExceptio, PosicionException {
        ListaEnlazada<Persona> lista = listar();
        quicksortDireccion(lista, 0, lista.size() - 1);
        return busquedaSecuencialYBinariaDireccion(lista, dato);
    }

    public ListaEnlazada<Persona> busquedaBinariaOrdenada(ListaEnlazada<Persona> lista, String dato) throws VacioExceptio, PosicionException {
        quicksortDireccion(lista, 0, lista.size() - 1);
        return busquedaBinariaDireccion(lista, dato);
    }

    public ListaEnlazada<Persona> quicksortDireccion(ListaEnlazada<Persona> lista, int izquierda, int derecha) throws VacioExceptio, PosicionException {
        if (izquierda < derecha) {
            int indicePivote = particionD(lista, izquierda, derecha);
            quicksortDireccion(lista, izquierda, indicePivote - 1);
            quicksortDireccion(lista, indicePivote + 1, derecha);
        }
        return lista;
    }

    private int particionD(ListaEnlazada<Persona> lista, int izquierda, int derecha) throws VacioExceptio, PosicionException {
        Persona pivote = lista.get(derecha);
        int indicePivote = izquierda;

        for (int i = izquierda; i < derecha; i++) {
            if (lista.get(i).getDireccion().compareToIgnoreCase(pivote.getDireccion()) < 0) {
                Persona temp = lista.get(indicePivote);
                lista.modificar(lista.get(i), indicePivote);
                lista.modificar(temp, i);
                indicePivote++;
            }
        }
        Persona temp = lista.get(indicePivote);
        lista.modificar(lista.get(derecha), indicePivote);
        lista.modificar(temp, derecha);
        return indicePivote;
    }

    public ListaEnlazada<Persona> busquedaBinariaDireccion(ListaEnlazada<Persona> lista, String dato) throws VacioExceptio, PosicionException {
        ListaEnlazada<Persona> resultado = new ListaEnlazada<>();
        int l = 0;
        int r = lista.size() - 1;
        while (l <= r) {
            int mitad = l + (r - l) / 2;
            String direccionMitad = lista.get(mitad).getDireccion().toLowerCase();
            if (direccionMitad.equals(dato.toLowerCase())) {
                resultado.insertar(lista.get(mitad));
                break;
            }
            if (direccionMitad.compareToIgnoreCase(dato.toLowerCase()) < 0) {
                l = mitad + 1;
            } else {
                r = mitad - 1;
            }
        }
        return resultado;
    }

    public ListaEnlazada<Persona> busquedaSecuencialYBinariaDireccion(ListaEnlazada<Persona> lista, String dato) throws VacioExceptio, PosicionException {
        ListaEnlazada<Persona> resultado = new ListaEnlazada<>();
        // Búsqueda secuencial
        for (int i = 0; i < lista.size(); i++) {
            String direccion = lista.get(i).getDireccion().toLowerCase();
            if (direccion.startsWith(dato.toLowerCase())) {
                resultado.insertar(lista.get(i));
            } else if (direccion.compareToIgnoreCase(dato.toLowerCase()) > 0) {
                break;
            }
        }
        // Búsqueda binaria
        int l = 0;
        int r = lista.size() - 1;

        while (l <= r) {
            int mitad = l + (r - l) / 2;
            String nombreMitad = lista.get(mitad).getDireccion().toLowerCase();

            if (nombreMitad.startsWith(dato.toLowerCase())) {
                // Ya se insertó en la búsqueda secuencial, se omite para evitar duplicados.
                break;
            }

            if (nombreMitad.compareToIgnoreCase(dato.toLowerCase()) < 0) {
                l = mitad + 1;
            } else {
                r = mitad - 1;
            }
        }
        // Continuar la búsqueda binaria hacia la izquierda para encontrar más coincidencias
        while (r >= 0) {
            String nombreR = lista.get(r).getDireccion().toLowerCase();
            if (nombreR.startsWith(dato.toLowerCase())) {
                resultado.insertar(lista.get(r));
            } else {
                break;
            }
            r--;
        }

        return resultado;

    }

    public ListaEnlazada<Persona> buscarPorCedulaSyB(String dato) throws VacioExceptio, PosicionException {
        ListaEnlazada<Persona> lista = listar();
        OrdenarCedula(lista, 0, lista.size() - 1);
        return busquedaSecuencialYBinariaCedula(lista, dato);
    }

    public ListaEnlazada<Persona> busquedaBinariaOCedula(ListaEnlazada<Persona> lista, String dato) throws VacioExceptio, PosicionException {
        OrdenarCedula(lista, 0, lista.size() - 1);
        return busquedaBinariaCedula(lista, dato);
    }

    public ListaEnlazada<Persona> OrdenarCedula(ListaEnlazada<Persona> lista, int izquierda, int derecha) throws VacioExceptio, PosicionException {
        if (izquierda < derecha) {
            int indicePivote = particionCedula(lista, izquierda, derecha);
            OrdenarCedula(lista, izquierda, indicePivote - 1);
            OrdenarCedula(lista, indicePivote + 1, derecha);
        }
        return lista;
    }

    private int particionCedula(ListaEnlazada<Persona> lista, int izquierda, int derecha) throws VacioExceptio, PosicionException {
        Persona pivote = lista.get(derecha);
        int indicePivote = izquierda;
        for (int i = izquierda; i < derecha; i++) {
            if (lista.get(i).getCedula().compareToIgnoreCase(pivote.getCedula()) < 0) {
                Persona temp = lista.get(indicePivote);
                lista.modificar(lista.get(i), indicePivote);
                lista.modificar(temp, i);
                indicePivote++;
            }
        }
        Persona temp = lista.get(indicePivote);
        lista.modificar(lista.get(derecha), indicePivote);
        lista.modificar(temp, derecha);
        return indicePivote;
    }

    public ListaEnlazada<Persona> busquedaBinariaCedula(ListaEnlazada<Persona> lista, String dato) throws VacioExceptio, PosicionException {
        ListaEnlazada<Persona> resultado = new ListaEnlazada<>();
        int l = 0;
        int r = lista.size() - 1;
        while (l <= r) {
            int mitad = l + (r - l) / 2;
            String cedulaMitad = lista.get(mitad).getCedula();
            if (cedulaMitad.equals(dato)) {
                resultado.insertar(lista.get(mitad));
                return resultado;
            }
            if (cedulaMitad.compareToIgnoreCase(dato) < 0) {
                l = mitad + 1;
            } else {
                r = mitad - 1;
            }
        }
        return resultado;
    }

    public ListaEnlazada<Persona> busquedaSecuencialYBinariaCedula(ListaEnlazada<Persona> lista, String dato) throws VacioExceptio, PosicionException {
        ListaEnlazada<Persona> resultado = new ListaEnlazada<>();
        // Búsqueda secuencial
        for (int i = 0; i < lista.size(); i++) {
            String c = lista.get(i).getCedula();
            if (c.startsWith(dato)) {
                resultado.insertar(lista.get(i));
            } else if (c.compareToIgnoreCase(dato) > 0) {
                break;
            }
        }
        // Búsqueda binaria
        int l = 0;
        int r = lista.size() - 1;
        while (l <= r) {
            int mitad = l + (r - l) / 2;
            String nombreMitad = lista.get(mitad).getCedula();
            if (nombreMitad.startsWith(dato)) {
                break;
            }
            if (nombreMitad.compareToIgnoreCase(dato) < 0) {
                l = mitad + 1;
            } else {
                r = mitad - 1;
            }
        }
        
        return resultado;
    }
    public ListaEnlazada<Persona> buscarPorNacionalidadB(String dato) throws VacioExceptio, PosicionException {
    ListaEnlazada<Persona> lista = listar();
    ListaEnlazada<Persona> resultado = new ListaEnlazada<>();
    Pais p = new PaisDao().buscarPorNombre(dato.trim());
    if (p != null) {
        ListaEnlazada<Persona> listaOrdenada = ordenarLista(lista);
        int indice = busquedaBinaria(listaOrdenada, p.getId().intValue());
        if (indice != -1) {
            resultado.insertar(listaOrdenada.get(indice));
        }
    }
    return resultado;
}
 public ListaEnlazada<Persona> buscarPorNacionalidadBYS(String dato) throws VacioExceptio, PosicionException {
    ListaEnlazada<Persona> lista = listar();
    ListaEnlazada<Persona> resultado = new ListaEnlazada<>();
    Pais p = new PaisDao().buscarPorNombre(dato.trim());
    if (p != null) {
        
        int indice = busquedaBinaria(lista, p.getId());
        if (indice != -1) {
            resultado.insertar(lista.get(indice));
        }
    }
 
    return resultado;
}   
    

private ListaEnlazada<Persona> ordenarLista(ListaEnlazada<Persona> lista) {
        ListaEnlazada<Persona> listaOrdenada = new ListaEnlazada<>();

    try {
    for (int i = 0; i < lista.size(); i++) {
        listaOrdenada.insertar(lista.get(i));
    }
    quickSortN(listaOrdenada, 0, listaOrdenada.size() - 1);
    
    } catch (Exception e) {
    }
        return listaOrdenada;
}

public ListaEnlazada<Persona> quickSortN(ListaEnlazada<Persona> lista, int inicio, int fin) {
    if (inicio < fin) {
        int indiceParticion = particionN(lista, inicio, fin);
        quickSortN(lista, inicio, indiceParticion - 1);
        quickSortN(lista, indiceParticion + 1, fin);
    }
    return lista ;
}

private int particionN(ListaEnlazada<Persona> lista, int inicio, int fin) {
     int i = inicio - 1;
    try {
        Persona pivote = lista.get(fin);
   
    for (int j = inicio; j < fin; j++) {
        if (lista.get(j).getId_Pais() <= pivote.getId_Pais()) {
            i++;
            Persona temp = lista.get(i);
            lista.modificar( lista.get(j),i);
            lista.modificar( temp,j);
        }
    }
    Persona temp = lista.get(i + 1);
    lista.modificar( lista.get(fin),i + 1);
    lista.modificar( temp,fin);
    } catch (Exception e) {
    }
    return i + 1;
}


private int busquedaBinaria(ListaEnlazada<Persona> lista, int idPais) {
    
    try {
int inicio = 0;
    int fin = lista.size() - 1;
    while (inicio <= fin) {
        int medio = (inicio + fin) / 2;
        if (lista.get(medio).getId_Pais().intValue() == idPais) {
            return medio;
        } else if (lista.get(medio).getId_Pais().intValue() < idPais) {
            inicio = medio + 1;
        } else {
            fin = medio - 1;
        }
    }        
    } catch (Exception e) {
    }

    return -1;
}
    public ListaEnlazada<Persona> busquedaSecuencialYBinariaNacionalidad(ListaEnlazada<Persona> lista,int idPais) throws VacioExceptio, PosicionException {
        ListaEnlazada<Persona> resultado = new ListaEnlazada<>();
        // Búsqueda secuencial
        for (int i = 0; i < lista.size(); i++) {
            
            if (lista.get(i).getId_Pais()== idPais) {
                resultado.insertar(lista.get(i));
            } else if (lista.get(i).getId_Pais() > idPais) {
                break;
            }
        }
        // Búsqueda binaria
        int l = 0;
        int r = lista.size() - 1;
        while (l <= r) {
            int mitad = l + (r - l) / 2;
            if (lista.get(mitad).getId_Pais()==idPais) {
                break;
            }
            if (lista.get(mitad).getId_Pais() < idPais) {
                l = mitad + 1;
            } else {
                r = mitad - 1;
            }
        }
        while (r >= 0) {
            if (lista.get(r).getId_Pais() > idPais) {
                resultado.insertar(lista.get(r));
            } else {
                break;
            }
            r--;
        }
        return resultado;
    }


}
