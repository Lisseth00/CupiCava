/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_cupiCava
 * Autor: Equipo Cupi2 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.cupiCava.mundo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase que representa la Cupi-Cava. <br>
 * <b>inv: </b> <br>
 * - La lista de vinos est� inicializada (vinos != null). <br>
 * - Ning�n elemento de la lista es null. <br>
 * - No hay vinos repetidos en la lista (no hay dos vinos con el mismo nombre). <br>
 */
public class CupiCava
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Lista de vinos en la cava.
     */
    private ArrayList<Vino> vinos;

    // -------------------------------------------------------------
    // M�todo Constructor
    // -------------------------------------------------------------

    /**
     * Construye una nueva cava sin vinos. <br>
     * <b>post:</b> La lista de vinos ha sido inicializada.
     */
    public CupiCava( )
    {
        this.vinos = new ArrayList<Vino>( );
        verificarInvariante();
    }

    // -------------------------------------------------------------
    // M�todos
    // -------------------------------------------------------------

    /**
     * Retorna la lista de vinos.
     * @return Lista de vinos.
     */
    public ArrayList<Vino> darVinos( )
    {
        return vinos;
    }

    /**
     * Busca un vino con el nombre dado por par�metro. <br>
     * <b>pre:</b> La lista de vinos est� inicializada.
     * @param pNombre Nombre del vino. pNombre != null && pNombre != ""
     * @return Vino con el nombre dado, null en caso de no encontrarlo.
     */
    public Vino buscarVino( String pNombre )
    {
        Vino buscado = null;
        boolean encontre = false;

        for( int i = 0; i < vinos.size( ) && !encontre; i++ )
        {
            Vino vinoActual = ( Vino )vinos.get( i );
            if( vinoActual.darNombre( ).equalsIgnoreCase( pNombre ) )
            {
                buscado = vinoActual;
                encontre = true;
            }
        }

        return buscado;
    }

    /**
     * Busca un vino utilizando una b�squeda binaria. <br>
     * <b>pre: </b> La lista de vinos est� inicializada y se encuentra ordenada por nombre.
     * @param pNombre Nombre del vino que se va a buscar. pNombre != null && pNombre != "".
     * @return Vino con el nombre dado, null en caso de no encontrarlo.
     */
    public Vino buscarBinarioPorNombre( String pNombre )
    {
    	int izquierda = 0;
    	int derecha = vinos.size() -1;
    	
    	while (izquierda <= derecha) {
    		int medio = (izquierda + derecha) / 2;
    		Vino vinoMedio = vinos.get(medio);
    		int comparacion = vinoMedio.darNombre().compareToIgnoreCase(pNombre);
    		
    		if (comparacion == 0) {
	            return vinoMedio;
	        } else if (comparacion < 0) {
	            izquierda = medio + 1;
	        } else {
	            derecha = medio - 1;
	        }
    	}
    	
    	return null;
    }

    /**
     * Busca el vino m�s dulce (con mayor contenido en az�car) de la cava. <br>
     * <b>pre:</b> La lista de vinos est� inicializada.
     * @return Vino m�s dulce de la cava. Si la cava no tiene vinos se retorna null. Si existen varios vinos con el contenido en az�car m�s alto, se retorna el primer vino
     *         encontrado.
     */
    public Vino buscarVinoMasDulce( )
    {
   	 if (vinos == null || vinos.isEmpty()) {
   		 return null;
   	 }
   	Vino masDulce = vinos.get(0); // Asumiendo que este elemento es el mas dulce
   	for (int i = 1; i < vinos.size(); i++) {
        Vino actual = vinos.get(i);
        if (actual.darContenidoAzucar() > masDulce.darContenidoAzucar()) {
            masDulce = actual; // Se encontró un vino más dulce
        }
    }

    return masDulce;
    }

    /**
     * Busca el vino m�s seco (con menor contenido en az�car) de la cava. <br>
     * <b>pre:</b> La lista de vinos est� inicializada.
     * @return Vino m�s seco de la cava. Si la cava no tiene vinos se retorna null. Si existen varios vinos con el contenido en az�car m�s bajo, se retorna el primer vino
     *         encontrado.
     */
    public Vino buscarVinoMasSeco( )
    {
   	 if (vinos == null || vinos.isEmpty()) {
   		 return null;
   	 }
   	 Vino masSeco = vinos.get(0);
   	 for (int i = 1; i < vinos.size();i++) {
   		 Vino actual = vinos.get(i);
   		 if(actual.darContenidoAzucar()< masSeco.darContenidoAzucar()) {
   			 masSeco = actual;
   		 }
   	 }
   	 return masSeco; 
   }

    /**
     * Busca los vinos del tipo dado por par�metro. <br>
     * <b>pre:</b> La lista de vinos est� inicializada.
     * @param pTipo Tipo de vino de acuerdo a su contenido en az�car.pTipo != null && pTipo != "" && (pTipo == SECO || pTipo == ABOCADO || pTipo == SEMI_SECO || pTipo ==
     *        SEMI_DULCE || pTipo == DULCE).
     * @return Lista de vinos del tipo dado.
     */
    public ArrayList<Vino> buscarVinosDeTipo( String pTipo )
    {
   	 ArrayList<Vino> resultado = new ArrayList<>();
   	 
   	 for (Vino vino : vinos) {
   		 if(vino.darTipo().equalsIgnoreCase(pTipo)) {
   			 resultado.add(vino); 
   		 }
   	 }
   	 return resultado; 
   }

    /**
     * Agrega un nuevo vino a la cava si no existe actualmente un vino en la cava con el mismo nombre.<br>
     * <b>pre:</b> La lista de vinos est� inicializada.<br>
     * <b>post:</b> Se agreg� un nuevo vino a la lista de vinos.<br>
     * @param pNombre Nombre del vino. pNombre != null && pNombre != "".
     * @param pPresentacion Presentaci�n del vino. pPresentacion != null && pPresentacion != "" && (pPresentacion == BOTELLA || pPresentacion == BARRIL).
     * @param pAnhoElaboracion A�o de elaboraci�n del vino. pAnhoElaboracion > 0.
     * @param pContenidoAzucar Contenido en az�car del vino. pContenidoAzucar >= 0
     * @param pTipo Tipo de vino de acuerdo a su contenido en az�car. pTipo != null && pTipo != "" && (pTipo == SECO || pTipo == ABOCADO || pTipo == SEMI_SECO || pTipo ==
     *        SEMI_DULCE || pTipo == DULCE).
     * @param pColor Color del vino. pColor != null && pColor != "" && (pColor == TINTO || pColor == ROSADO || pColor == BLANCO).
     * @param pLugarOrigen Lugar de origen del vino. lugarElaboracion != null y lugarElaboracion != "".
     * @param pImagen Imagen del vino. pImagen != null && pImagen != "".
     * @return True si el vino es agregado, false de lo contrario.
     */
    public boolean agregarVino( String pNombre, String pPresentacion, int pAnhoElaboracion, double pContenidoAzucar, String pTipo, String pColor, String pLugarOrigen, String pImagen )
    {
        Vino buscado = buscarVino( pNombre );
        if (buscado != null) {
        	return false; 
        }
        Vino vino = new Vino(pNombre, pPresentacion,pAnhoElaboracion, pContenidoAzucar, pTipo, pColor, pLugarOrigen, pImagen ); 
        //Agregamos el nuevo vino a la lista
        vinos.add(vino);
        
        // Utilizamos las invariantes
        verificarInvariante();
        return false; 
    }

    /**
     * Ordena ascendentemente la lista de vinos por nombre usando el algoritmo de burbuja. <br>
     * <b>pre:</b> La lista de vinos est� inicializada. <br>
     * <b>post:</b> La lista de vinos est� ordenada por nombre (orden ascendente).
     */
    public void ordenarVinosPorNombre( )
    {
    	for (int i = 0; i < vinos.size(); i++) {
            for (int j = 0; j < vinos.size() - 1 - i; j++) {
                Vino v1 = vinos.get(j);
                Vino v2 = vinos.get(j + 1);
                if (v1.darNombre().compareToIgnoreCase(v2.darNombre()) > 0) {
                    vinos.set(j, v2);
                    vinos.set(j + 1, v1);
                }
            }
        }
   }

    /**
     * Ordena descendentemente la lista de vinos por a�o de elaboraci�n usando el algoritmo de selecci�n. <br>
     * <b>pre:</b> La lista de vinos est� inicializada. <br>
     * <b>post:</b> La lista de vinos est� ordenada por a�o de elaboraci�n (orden descendente).
     */
    public void ordenarVinosPorAhnoElaboracion( )
    {
    	for (int i = 0; i < vinos.size() - 1; i++) {
	        int indiceMayor = i;
	        for (int j = i + 1; j < vinos.size(); j++) {
	            if (vinos.get(j).darAnhoElaboracion() > vinos.get(indiceMayor).darAnhoElaboracion()) {
	                indiceMayor = j;
	            }
	        }
	        // Intercambio
	        Vino temp = vinos.get(i);
	        vinos.set(i, vinos.get(indiceMayor));
	        vinos.set(indiceMayor, temp);
	    }
   }

    /**
     * Ordena ascendentemente la lista de vinos por lugar de origen usando el algoritmo de inserci�n. <br>
     * <b>pre:</b> La lista de vinos est� inicializada.<br>
     * <b> post: </b>La lista de vinos est� ordenada por lugar de origen (orden ascendente).
     */
    public void ordenarVinosPorLugarOrigen( )
    {
    	for (int i = 1; i < vinos.size(); i++) {
	        Vino actual = vinos.get(i);
	        int j = i - 1;

	        while (j >= 0 && vinos.get(j).darLugarOrigen().compareToIgnoreCase(actual.darLugarOrigen()) > 0) {
	            vinos.set(j + 1, vinos.get(j));
	            j--;
	        }

	        vinos.set(j + 1, actual);
	    }
   }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica que se cumpla el invariante de la clase.
     */
    private void verificarInvariante() {
    	assert vinos != null : "La lista no puede estar vacia o ser nula.";
    	
    	Set<String> nombres = new HashSet<>();
    	
    	for ( int i = 0; i < vinos.size(); i++) {
    		Vino vino = vinos.get(i);
    		assert vino != null : "El vino en la posición" + i + "no puede ser nulo.";
    		
    		String nombre = vino.darNombre();
    		
    		assert !nombres.contains(nombre) : "El vino con" + nombre + "ya existe en la lista";
    		nombres.add(nombre);
    	}
    	
    }


    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1.
     * @return Respuesta 1.
     */
    public String metodo1( )
    {
        return "Respuesta 1.";
    }

    /**
     * M�todo para la extensi�n 2.
     * @return Respuesta 2.
     */
    public String metodo2( )
    {
        return "Respuesta 2.";
    }
}