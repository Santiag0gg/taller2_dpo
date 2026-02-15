package uniandes.dpoo.estructuras.logica;

import java.util.*;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre listas de enteros y de cadenas.
 */
public class SandboxListas
{
    private List<Integer> listaEnteros;
    private List<String> listaCadenas;

    public SandboxListas( )
    {
        listaEnteros = new ArrayList<Integer>( );
        listaCadenas = new LinkedList<String>( );
    }

    /**
     * Retorna una copia de la lista de enteros
     */
    public List<Integer> getCopiaEnteros( )
    {
        return new ArrayList<>(listaEnteros);
    }

    /**
     * Retorna una copia de la lista de cadenas
     */
    public List<String> getCopiaCadenas( )
    {
        return new LinkedList<>(listaCadenas);
    }

    /**
     * Retorna un arreglo con los valores de la lista de enteros
     */
    public int[] getEnterosComoArreglo( )
    {
        int[] a = new int[listaEnteros.size()];
        for (int i = 0; i < listaEnteros.size(); i++) {
            a[i] = listaEnteros.get(i);
        }
        return a;
    }

    /**
     * Retorna la cantidad de valores en la lista de enteros
     */
    public int getCantidadEnteros( )
    {
        return listaEnteros.size();
    }

    /**
     * Retorna la cantidad de valores en la lista de cadenas
     */
    public int getCantidadCadenas( )
    {
        return listaCadenas.size();
    }

    /**
     * Agrega un nuevo valor al final de la lista de enteros.
     */
    public void agregarEntero( int entero )
    {
        listaEnteros.add(entero);
    }

    /**
     * Agrega un nuevo valor al final de la lista de cadenas.
     */
    public void agregarCadena( String cadena )
    {
        listaCadenas.add(cadena);
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro de la lista de enteros
     */
    public void eliminarEntero( int valor )
    {
        // Iterator para borrar sin que la lista se descuadre mientras recorre
        Iterator<Integer> it = listaEnteros.iterator();
        while(it.hasNext()){
            if(it.next() == valor) it.remove();
        }
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro de la lista de cadenas
     */
    public void eliminarCadena( String cadena )
    {
        Iterator<String> it = listaCadenas.iterator();
        while(it.hasNext()){
            if(it.next().equals(cadena)) it.remove();
        }
    }

    /**
     * Inserta un nuevo entero en la lista de enteros
     */
    public void insertarEntero( int entero, int posicion )
    {
        if (posicion < 0) posicion = 0;
        if (posicion > listaEnteros.size()) posicion = listaEnteros.size();
        listaEnteros.add(posicion, entero);
    }

    /**
     * Elimina un valor de la lista de enteros dada su posición.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
        if (posicion >= 0 && posicion < listaEnteros.size()) {
            listaEnteros.remove(posicion);
        }
    }

    /**
     * Reinicia la lista de enteros con los valores contenidos en 'valores' truncados.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
        listaEnteros.clear();
        for (int i = 0; i < valores.length; i++) {
            listaEnteros.add((int) valores[i]);
        }
    }

    /**
     * Reinicia la lista de cadenas con toString...
     */
    public void reiniciarArregloCadenas( List<Object> objetos )
    {
        listaCadenas.clear();
        for (int i = 0; i < objetos.size(); i++) {
            listaCadenas.add(objetos.get(i).toString());
        }
    }

    /**
     * Modifica la lista de enteros para que todos los valores sean positivos.
     */
    public void volverPositivos( )
    {
        for (int i = 0; i < listaEnteros.size(); i++) {
            int val = listaEnteros.get(i);
            if (val < 0) listaEnteros.set(i, val * -1);
        }
    }

    /**
     * Modifica la lista de enteros para que queden organizados de MAYOR a MENOR.
     */
    public void organizarEnteros( )
    {
        Collections.sort(listaEnteros, Collections.reverseOrder());
    }

    /**
     * Modifica la lista de cadenas para que queden organizadas lexicográficamente.
     */
    public void organizarCadenas( )
    {
        Collections.sort(listaCadenas);
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en la lista de enteros
     */
    public int contarApariciones( int valor )
    {
        int c = 0;
        for (int n : listaEnteros) if (n == valor) c++;
        return c;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en la lista de cadenas.
     */
    public int contarApariciones( String cadena )
    {
        int c = 0;
        for (String s : listaCadenas) if (s.equalsIgnoreCase(cadena)) c++;
        return c;
    }

    /**
     * Cuenta cuántos valores dentro de la lista de enteros están repetidos.
     */
    public int contarEnterosRepetidos( )
    {
        Set<Integer> unicos = new HashSet<>();
        Set<Integer> repetidos = new HashSet<>();
        for (int n : listaEnteros) {
            // add devuelve falso si ya estaba
            if (!unicos.add(n)) repetidos.add(n);
        }
        return repetidos.size();
    }

    /**
     * Compara la lista de enteros con un arreglo de enteros...
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
        if (listaEnteros.size() != otroArreglo.length) return false;
        for (int i = 0; i < otroArreglo.length; i++) {
            if (listaEnteros.get(i) != otroArreglo[i]) return false;
        }
        return true;
    }

    /**
     * Cambia los elementos de la lista de enteros por valores generados aleatoriamente.
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
        listaEnteros.clear();
        for (int i = 0; i < cantidad; i++) {
            int n = (int) (Math.random() * (maximo - minimo + 1)) + minimo;
            listaEnteros.add(n);
        }
    }
}