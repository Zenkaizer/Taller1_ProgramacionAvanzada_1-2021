package Taller1;

/**
 * Representa a la entidad Campeón.
 */
public class Campeon {

    //region ATRIBUTOS DE LA CLASE CAMPEON.

    /**
     * Corresponde al nombre del campeón.
     */
    private final String nombreCampeon;
    /**
     * Corresponde a la descripción del campeón.
     */
    private final String descripcionCampeon;
    /**
     * Corresponde al rol del campeón.
     */
    private final String rolCampeon;
    /**
     * Corresponde a la posición del campeón.
     */
    private final String posCampeon;

    //endregion




    //region CONSTRUCTOR DE LA CLASE CAMPEON.

    /**
     * Constructor de la clase Campeón.
     * @param nombreCampeon Corresponde al nombre del campeón.
     * @param descripcionCampeon Corresponde a la descripción del campeón.
     * @param rolCampeon Corresponde al rol del campeón.
     * @param posCampeon Corresponde a la posición del campeón.
     */
    public Campeon(String nombreCampeon, String descripcionCampeon, String rolCampeon, String posCampeon) {
        this.nombreCampeon = nombreCampeon;
        this.descripcionCampeon = descripcionCampeon;
        this.rolCampeon = rolCampeon;
        this.posCampeon = posCampeon;
    }

    //endregion




    //region GETTER & SETTER DE LA CLASE CAMPEON.

    /**
     * Método que obtiene el nombre del campeón.
     * @return Nombre del campeón.
     */
    public String getNombreCampeon() {
        return this.nombreCampeon;
    }

    /**
     * Método que obtiene la descripción del campeón.
     * @return Descripción del campeón.
     */
    public String getDescripcionCampeon() {
        return this.descripcionCampeon;
    }

    /**
     * Método que obtiene el rol del campeón.
     * @return Rol del campeón.
     */
    public String getRolCampeon() {
        return this.rolCampeon;
    }

    /**
     * Método que obtiene la posición del campeón.
     * @return Posición del campeón.
     */
    public String getPosCampeon() {
        return this.posCampeon;
    }

    //endregion
}