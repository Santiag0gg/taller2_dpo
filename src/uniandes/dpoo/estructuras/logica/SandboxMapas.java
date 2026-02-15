package uniandes.dpoo.estructuras.logica;

import java.util.*;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre mapas.
 */
public class SandboxMapas
{
    private Map<String, String> mapaCadenas;

    public SandboxMapas( )
    {
        mapaCadenas = new HashMap<String, String>( );
    }

    /**
     * Retorna una lista con las cadenas del mapa (los valores) ordenadas lexicográficamente
     */
    public List<String> getValoresComoLista( )
    {
        List<String> v = new ArrayList<>(mapaCadenas.values());
        Collections.sort(v);
        return v;
    }

    /**
     * Retorna una lista con las llaves del mapa ordenadas lexicográficamente de mayor a menor
     */
    public List<String> getLlavesComoListaInvertida( )
    {
        List<String> k = new ArrayList<>(mapaCadenas.keySet());
        k.sort(Collections.reverseOrder());
        return k;
    }

    /**
     * Retorna la cadena que sea lexicográficamente menor dentro de las llaves del mapa.
     */
    public String getPrimera( )
    {
        if (mapaCadenas.isEmpty()) return null;
        List<String> llaves = new ArrayList<>(mapaCadenas.keySet());
        Collections.sort(llaves);
        return llaves.get(0);
    }

    /**
     * Retorna la cadena que sea lexicográficamente mayor dentro de los valores del mapa
     */
    public String getUltima( )
    {
        if (mapaCadenas.isEmpty()) return null;
        List<String> vals = new ArrayList<>(mapaCadenas.values());
        Collections.sort(vals);
        return vals.get(vals.size() - 1);
    }

    /**
     * Retorna una colección con las llaves del mapa, convertidas a mayúsculas.
     */
    public Collection<String> getLlaves( )
    {
        List<String> res = new ArrayList<>();
        for (String k : mapaCadenas.keySet()) res.add(k.toUpperCase());
        return res;
    }

    /**
     * Retorna la cantidad de *valores* diferentes en el mapa
     */
    public int getCantidadCadenasDiferentes( )
    {
        Set<String> set = new HashSet<>(mapaCadenas.values());
        return set.size();
    }

    /**
     * Agrega un nuevo valor al mapa: el valor será el recibido, y la llave la cadena invertida
     */
    public void agregarCadena( String cadena )
    {
        // Invertimos la cadena con un bucle manual
        String invertida = "";
        for (int i = cadena.length() - 1; i >= 0; i--) {
            invertida += cadena.charAt(i);
        }
        mapaCadenas.put(invertida, cadena);
    }

    /**
     * Elimina una cadena del mapa, dada la llave
     */
    public void eliminarCadenaConLLave( String llave )
    {
        mapaCadenas.remove(llave);
    }

    /**
     * Elimina una cadena del mapa, dado el valor
     */
    public void eliminarCadenaConValor( String valor )
    {
        // Usamos Iterator de Entries para borrar por valor
        Iterator<Map.Entry<String, String>> it = mapaCadenas.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().equals(valor)) it.remove();
        }
    }

    /**
     * Reinicia el mapa con representaciones toString...
     */
    public void reiniciarMapaCadenas( List<Object> objetos )
    {
        mapaCadenas.clear();
        for (int i = 0; i < objetos.size(); i++) {
            agregarCadena(objetos.get(i).toString());
        }
    }

    /**
     * Modifica el mapa reemplazando las llaves para que ahora estén en mayúsculas.
     */
    public void volverMayusculas( )
    {
        Map<String, String> nuevoMap = new HashMap<>();
        for (Map.Entry<String, String> e : mapaCadenas.entrySet()) {
            nuevoMap.put(e.getKey().toUpperCase(), e.getValue());
        }
        mapaCadenas = nuevoMap;
    }

    /**
     * Verifica si todos los elementos del arreglo están dentro de los valores del mapa
     */
    public boolean compararValores( String[] otroArreglo )
    {
        Collection<String> vals = mapaCadenas.values();
        for (int i = 0; i < otroArreglo.length; i++) {
            if (!vals.contains(otroArreglo[i])) return false;
        }
        return true;
    }
}