/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_cupiCava
 * Autor: Equipo Cupi2 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.cupiCava.mundo;

/**
 * Clase que representa un vino. <br>
 * <b>inv:</b> <br>
 * - nombre ≠ null y nombre ≠ "". <br>
 * - presentacion es "BOTELLA" o "BARRIL". <br>
 * - anhoElaboracion > 0. <br>
 * - contenidoAzucar ≥ 0. <br>
 * - tipo es uno de: "SECO", "ABOCADO", "SEMI_SECO", "SEMI_DULCE", "DULCE". <br>
 * - color es uno de: "TINTO", "ROSADO", "BLANCO". <br>
 * - lugarOrigen ≠ null y lugarOrigen ≠ "". <br>
 * - imagen ≠ null y imagen ≠ "". <br>
 */
public class Vino
{
    // -------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------

    /**
     * Constante que representa la presentación barril.
     */
    public final static String BARRIL = "Barril";

    /**
     * Constante que representa la presentación botella.
     */
    public final static String BOTELLA = "Botella";

    /**
     * Constante que representa el color tinto.
     */
    public final static String TINTO = "Tinto";

    /**
     * Constante que representa el color rosado.
     */
    public final static String ROSADO = "Rosado";

    /**
     * Constante que representa el color blanco.
     */
    public final static String BLANCO = "Blanco";

    /**
     * Constante que representa el tipo de vino seco.
     */
    public final static String SECO = "Seco";

    /**
     * Constante que representa el tipo de vino abocado.
     */
    public static final String ABOCADO = "Abocado";

    /**
     * Constante que representa el tipo de vino semi-seco.
     */
    public static final String SEMI_SECO = "Semi-seco";

    /**
     * Constante que representa el tipo de vino semi-dulce.
     */
    public static final String SEMI_DULCE = "Semi-dulce";

    /**
     * Constante que representa el tipo de vino dulce.
     */
    public static final String DULCE = "Dulce";

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Nombre del vino.
     */
    private String nombre;

    /**
     * Presentación del vino.
     */
    private String presentacion;

    /**
     * Año de elaboración del vino.
     */
    private int anoElaboracion;

    /**
     * Contenido en azúcar del vino (gramos/litro).
     */
    private double contenidoAzucar;

    /**
     * Tipo del vino.
     */
    private String tipo;

    /**
     * Color del vino.
     */
    private String color;

    /**
     * Lugar de origen del vino.
     */
    private String lugarOrigen;

    /**
     * Ruta donde se encuentra la imagen del vino.
     */
    private String imagen;

    // -------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------

    /**
     * Inicializa el vino con la información dada por parámetro. <br>
     * <b>post: </b> El vino se inicializó con los valores de nombre, presentación, año elaboración, contenido en azúcar, tipo, color, lugar de origen e imagen dados por
     * parámetro.
     * @param pNombre Nombre del vino. pNombre != null && pNombre != "".
     * @param pPresentacion Presentación del vino. pPresentacion != null && pPresentacion != "" && (pPresentacion == BOTELLA || pPresentacion == BARRIL).
     * @param pAnhoElaboracion Año de elaboración del vino. pAnhoElaboracion > 0.
     * @param pContenidoAzucar Contenido en azúcar del vino. pContenidoAzucar >= 0
     * @param pTipo Tipo de vino de acuerdo a su contenido en azúcar. pTipo != null && pTipo != "" && (pTipo == SECO || pTipo == ABOCADO || pTipo == SEMI_SECO || pTipo ==
     *        SEMI_DULCE || pTipo == DULCE).
     * @param pColor Color del vino. pColor != null && pColor != "" && (pColor == TINTO || pColor == ROSADO || pColor == BLANCO).
     * @param pLugarOrigen Lugar de origen del vino. lugarElaboracion != null y lugarElaboracion != "".
     * @param pImagen Imagen del vino. pImagen != null && pImagen != "".
     */
    public Vino( String pNombre, String pPresentacion, int pAnoElaboracion, double pContenidoAzucar, String pTipo, String pColor, String pLugarOrigen, String pImagen )
    {
    	this.nombre = pNombre;
        this.presentacion = pPresentacion;
        this.anoElaboracion = pAnoElaboracion;
        this.contenidoAzucar = pContenidoAzucar;
        this.tipo = pTipo;
        this.color = pColor;
        this.lugarOrigen = pLugarOrigen;
        this.imagen = pImagen;
        
        verificarInvariante();

    }

    // -------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------

    /**
     * Retorna el nombre del vino.
     * @return Nombre del vino.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna la presentación del vino.
     * @return Presentación del vino.
     */
    public String darPresentacion( )
    {
        return presentacion;
    }

    /**
     * Retorna el año de elaboración del vino.
     * @return Año de elaboración del vino.
     */
    public int darAnoElaboracion( )
    {
        return anoElaboracion;
    }

    /**
     * Retorna el contenido en azúcar del vino.
     * @return Contenido en azúcar del vino.
     */
    public double darContenidoAzucar( )
    {
        return contenidoAzucar;
    }

    /**
     * Retorna el tipo del vino.
     * @return Tipo del vino.
     */
    public String darTipo( )
    {
        return tipo;
    }

    /**
     * Retorna el color del vino.
     * @return Color del vino.
     */
    public String darColor( )
    {
        return color;
    }

    /**
     * Retorna el lugar de origen del vino.
     * @return Lugar de origen del vino.
     */
    public String darLugarOrigen( )
    {
        return lugarOrigen;
    }

    /**
     * Retorna la imagen del vino.
     * @return Imagen del vino.
     */
    public String darImagen( )
    {
        return imagen;
    }

    /**
     * Compara dos vinos según el nombre. <br>
     * @param pVino Vino contra el cual se está comparando. pVino !=null.
     * @return Retorna 0 si los vinos tienen el mismo nombre. <br>
     *         Retorna -1 si el vino pVino tiene un valor "MAYOR" para el nombre. <br>
     *         Retorna 1 si el vino pVino tiene un valor "MENOR" para el nombre. <br>
     */
    public int compararPorNombre( Vino pVino )
    {
    	 // TODO Parte2 PuntoA: Implemente el método según la documentación dada.
    	assert pVino != null : "El vino no puede ser nulo";

        String nombreVino = pVino.darNombre( );
        String nombre = this.nombre;   

        int rVino = this.nombre.compareTo(nombreVino);


        if ( rVino == 0 ) 
        {
            return 0;
        } 
        else if ( rVino > 0 ) 
        {
            return -1;
        } 
        else 
        {
            return 1;
        }
    }

    /**
     * Compara dos vinos según la presentación. <br>
     * @param pVino Vino contra el cual se está comparando. pVino !=null.
     * @return Retorna 0 si los vinos tienen la misma presentación. <br>
     *         Retorna -1 si el vino pVino tiene un valor "MAYOR" para la presentación. <br>
     *         Retorna 1 si el vino pVino tiene un valor "MENOR" para la presentación. <br>
     */
    public int compararPorPresentacion( Vino pVino )
    {
   	 // TODO Parte2 PuntoB: Implemente el método según la documentación dada.
        assert pVino != null : "El vino no puede ser nulo";
    	
    	String presentacion = pVino.darPresentacion( );
    	String presentacionVino = this.presentacion;
    	
    	int rPresenacion = presentacion.compareTo(presentacionVino);
    	
    	if ( rPresenacion == 0 ) 
        {
            return 0;
        } 
        else if ( rPresenacion > 0 ) 
        {
            return -1;
        } 
        else 
        {
            return 1;
        }
   }

    /**
     * Compara dos vinos según el año de elaboración. <br>
     * @param pVino Vino contra el cual se está comparando. pVino !=null.
     * @return Retorna 0 si los vinos tienen el mismo año de elaboración. <br>
     *         Retorna -1 si el vino pVino tiene un valor "MAYOR" para el año de elaboración. <br>
     *         Retorna 1 si el vino pVino tiene un valor "MENOR" para el año de elaboración. <br>
     */
    public int compararPorAnoElaboracion( Vino pVino )
    {
   	 // TODO Parte2 PuntoC: Implemente el método según la documentación dada.
    	assert pVino != null : "El vino no puede ser nulo";

        int anoElaboracion = this.anoElaboracion;
        int anoDado = pVino.darAnoElaboracion( );  
  
        if ( anoElaboracion == anoDado )
            return 0;
        else if ( anoElaboracion < anoDado )
            return -1;
        else
            return 1; 
   }

    /**
     * Compara dos vinos según el contenido en azúcar. <br>
     * @param pVino Vino contra el cual se está comparando. pVino !=null.
     * @return Retorna 0 si los vinos tienen el mismo contenido en azúcar. <br>
     *         Retorna -1 si el vino pVino tiene un mayor contenido en azúcar. <br>
     *         Retorna 1 si el vino pVino tiene un menor contenido en azúcar. <br>
     */
    public int compararPorContenidoAzucar( Vino pVino )
    {
   	 // TODO Parte2 PuntoD: Implemente el método según la documentación dada.
    	assert pVino != null : "El vino no puede ser nulo";

        double azucar = this.contenidoAzucar;
        double azucarAct = pVino.darContenidoAzucar( );

        if ( azucar == azucarAct )
            return 0;
        else if ( azucar < azucarAct )
            return -1;
        else
            return 1;
   }

    /**
     * Compara dos vinos según el tipo de vino. <br>
     * @param pVino Vino contra el cual se está comparando. pVino !=null.
     * @return Retorna 0 si los vinos tienen el mismo tipo. <br>
     *         Retorna -1 si el vino pVino tiene un valor "MAYOR" para el tipo. <br>
     *         Retorna 1 si el vino pVino tiene un valor "MENOR" para el tipo. <br>
     */
    public String compararPorTipo( double contenidoAzucar)
    {
   	 // TODO Parte2 PuntoE: Implemente el método según la documentación dada.
    	 if (contenidoAzucar >= 0 && contenidoAzucar < 5)
             return Vino.SECO;
         else if (contenidoAzucar < 15)
             return Vino.ABOCADO;
         else if (contenidoAzucar < 30)
             return Vino.SEMI_SECO; 
         else if (contenidoAzucar < 50)
             return Vino.SEMI_DULCE;
         else
             return Vino.DULCE; 
   }

    /**
     * Compara dos vinos según el color. <br>
     * @param pVino Vino contra el cual se está comparando. pVino !=null.
     * @return Retorna 0 si los vinos tienen el mismo color. <br>
     *         Retorna -1 si el vino pVino tiene un valor "MAYOR" para el color. <br>
     *         Retorna 1 si el vino pVino tiene un valor "MENOR" para el color. <br>
     */
    public int compararPorColor( Vino pVino )
    {
   	 // TODO Parte2 PuntoF: Implemente el método según la documentación dada.
    	assert pVino != null : "El vino no puede ser nulo";

        String color = this.color;
        String colorSelec = pVino.darColor( );
        
        int rColor = color.compareTo(colorSelec);
        
        if ( rColor == 0 )
            return 0;
        else if ( rColor < 0 )
            return -1;
        else 
            return 1;
    }

    /**
     * Compara dos vinos según el lugar de origen. <br>
     * @param pVino Vino contra el cual se está comparando. pVino !=null.
     * @return Retorna 0 si los vinos tienen el mismo lugar de origen. <br>
     *         Retorna -1 si el vino pVino tiene un valor "MAYOR" para el lugar de origen. <br>
     *         Retorna 1 si el vino pVino tiene un valor "MENOR" para el lugar de origen. <br>
     */
    public int compararPorLugarOrigen( Vino pVino )
    {
   	 // TODO Parte2 PuntoG: Implemente el método según la documentación dada.
    	assert pVino != null : "El vino no puede ser nulo";

        String LugarOrigen = this.lugarOrigen;
        String LugarOrigenDado = pVino.darLugarOrigen( );
        
        int rLugarOrigen = LugarOrigen.compareTo( LugarOrigenDado );
        
        if ( rLugarOrigen == 0 )
            return 0;
        else if ( rLugarOrigen < 0 )
            return -1;
        else
            return 1;
   }

    /**
     * Retorna una cadena con el nombre del vino.
     * @return Representación del vino en una cadena de caracteres.
     */
    public String toString( )
    {
        return nombre;
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    private void verificarInvariante( )
    {
    	
    	assert nombre != null && !nombre.trim( ).isEmpty( ) : " El nombre no puede estar vacio ";
    	assert nombre.equals( darNombre( ) ) : "El nombre ya existe " ;
    	assert presentacion != null && !presentacion.trim( ).isEmpty( ) : " la presentacion no puede estar vacia ";
    	assert anoElaboracion > 0 : "El año debe ser mayor que 0 ";
    	assert contenidoAzucar >= 0 : "El contenido de azucar debe ser mayor o igual a 0 ";
    	assert tipo != null && !tipo.trim( ).isEmpty( ) : " El tipo no puede estar vacio ";
    	assert color != null && !color.trim( ).isEmpty( ) : " el color no puede estar vacio ";
    	assert lugarOrigen != null && !lugarOrigen.trim( ).isEmpty( ) : " el lugar de origen no puede estar vacio "; 
    	
    }

}