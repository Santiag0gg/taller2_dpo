package uniandes.dpoo.estructuras.logica;

import java.util.*;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre conjuntos implementados usando un árbol (TreeSet).
 * ... (comentarios originales se mantienen en tu código)
 */
public class SandboxConjuntos
{
    private NavigableSet<String> arbolCadenas;

    public SandboxConjuntos( )
    {
        arbolCadenas = new TreeSet<String>( );
    }

    /**
     * Retorna una lista con las cadenas del conjunto ordenadas lexicográficamente
     * @return Una lista con las cadenas ordenadas
     */
    public List<String> getCadenasComoLista( )
    {
        // Creamos lista nueva con el contenido del set ordenado
        return new ArrayList<>(arbolCadenas);
    }

    /**
     * Retorna una lista con las cadenas del conjunto, ordenadas lexicográficamente de mayor a menor.
     * @return Una lista con las cadenas ordenadas de mayor a menor
     */
    public List<String> getCadenasComoListaInvertida( )
    {
        List<String> l = new ArrayList<>(arbolCadenas);
        Collections.reverse(l); // Invertimos la lista
        return l;
    }

    /**
     * Retorna la cadena que sea lexicográficamente menor en el conjunto de cadenas.
     */
    public String getPrimera( )
    {
        if (arbolCadenas.isEmpty()) return null;
        return arbolCadenas.first();
    }

    /**
     * Retorna la cadena que sea lexicográficamente mayor en el conjunto de cadenas
     */
    public String getUltima( )
    {
        if (arbolCadenas.isEmpty()) return null;
        return arbolCadenas.last();
    }

    /**
     * Retorna una colección con las cadenas... mayores o iguales a la cadena del parámetro
     */
    public Collection<String> getSiguientes( String cadena )
    {
        return arbolCadenas.tailSet(cadena, true);
    }

    /**
     * Retorna la cantidad de valores en el conjunto de cadenas
     */
    public int getCantidadCadenas( )
    {
        return arbolCadenas.size();
    }

    /**
     * Agrega un nuevo valor al conjunto de cadenas.
     */
    public void agregarCadena( String cadena )
    {
        arbolCadenas.add(cadena);
    }

    /**
     * Elimina una cadena del conjunto de cadenas
     */
    public void eliminarCadena( String cadena )
    {
        arbolCadenas.remove(cadena);
    }

    /**
     * Elimina una cadena del conjunto de cadenas, independientemente de las mayúsculas o minúsculas
     */
    public void eliminarCadenaSinMayusculasOMinusculas( String cadena )
    {
        // Usamos Iterator manual para buscar y borrar sin errores de concurrencia
        Iterator<String> it = arbolCadenas.iterator();
        while (it.hasNext()) {
            if (it.next().equalsIgnoreCase(cadena)) it.remove();
        }
    }

    /**
     * Elimina la primera cadena del conjunto
     */
    public void eliminarPrimera( )
    {
        if (!arbolCadenas.isEmpty()) arbolCadenas.pollFirst();
    }

    /**
     * Reinicia el conjunto de cadenas con toString para convertir objetos...
     */
    public void reiniciarConjuntoCadenas( List<Object> objetos )
    {
        arbolCadenas.clear();
        for (int i = 0; i < objetos.size(); i++) {
            arbolCadenas.add(objetos.get(i).toString());
        }
    }

    /**
     * Modifica el conjunto de cadenas para que todas las cadenas estén en mayúsculas.
     */
    public void volverMayusculas( )
    {
        NavigableSet<String> nuevo = new TreeSet<>();
        for (String s : arbolCadenas) {
            nuevo.add(s.toUpperCase());
        }
        arbolCadenas = nuevo; // Reemplazamos porque el orden cambia
    }

    /**
     * Construye un árbol de cadenas donde todas las cadenas están organizadas de MAYOR a MENOR.
     */
    public TreeSet<String> invertirCadenas( )
    {
        TreeSet<String> r = new TreeSet<>(Collections.reverseOrder());
        r.addAll(arbolCadenas);
        return r;
    }

    /**
     * Verifica si todos los elementos del arreglo hacen parte del conjunto
     */
    public boolean compararElementos( String[] otroArreglo )
    {
        for (int i = 0; i < otroArreglo.length; i++) {
            if (!arbolCadenas.contains(otroArreglo[i])) return false;
        }
        return true;
    }
}