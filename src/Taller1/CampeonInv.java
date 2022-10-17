package Taller1;

/**
 * Corresponde a la entidad Campeones del invocador.
 */
public class CampeonInv {

    //region ATRIBUTOS DE LA CLASE CAMPEONINV.

    /**
     * Corresponde al nombre del campeón.
     */
    private final String nombreCampeon;
    /**
     * Corresponde a los puntos de maestría que el invocador tiene con el campeón.
     */
    private int puntosMaestria;
    /**
     * Corresponde a la cantidad de victorias que el jugador tiene en total.
     */
    private int cantVictorias;
    /**
     * Corresponde a la cantidad de derrotas que el jugador tiene en total.
     */
    private int cantDerrotas;

    //endregion




    //region CONSTRUCTOR DE LA CLASE CAMPEONESINV.

    /**
     * Constructor de la clase CampeonesInv.
     * @param nombreCampeon Corresponde al nombre del campeón.
     * @param puntosMaestria Corresponde a los puntos de maestría del campeón.
     * @param cantVictorias Corresponde a la cantidad de victorias del campeón.
     * @param cantDerrotas Corresponde a la cantidad de derrotas del campeón.
     */
    public CampeonInv(String nombreCampeon, int puntosMaestria, int cantVictorias, int cantDerrotas) {
        this.nombreCampeon = nombreCampeon;
        this.puntosMaestria = puntosMaestria;
        this.cantVictorias = cantVictorias;
        this.cantDerrotas = cantDerrotas;
    }
    //endregion




    //region GETTER & SETTER DE LA CLASE CAMPEONESINV.

    /**
     * Método que obtiene el nombre del campeón.
     * @return Nombre del campeón.
     */
    public String getNombreCampeon() {
        return this.nombreCampeon;
    }

    /**
     * Método que obtiene los puntos de maestría del campeón usado por el invocador.
     * @return Puntos de maestría del campeón usado por el invocador.
     */
    public int getPuntosMaestria() {
        return this.puntosMaestria;
    }

    /**
     * Método que colóca o cambia los puntos de maestría del campeón usado por el invocador.
     * @param puntosMaestria Corresponde a los puntos de maestría.
     */
    public void setPuntosMaestria(int puntosMaestria) {
        this.puntosMaestria = puntosMaestria;
    }

    /**
     * Método que obtiene la cantidad de victorias del campeón usado por el invocador.
     * @return Cantidad de victorias del campeón usado por el invocador.
     */
    public int getCantVictorias() {
        return this.cantVictorias;
    }

    /**
     * Método que colóca o cambia la cantidad de victorias del campeón usado por el invocador.
     * @param cantVictorias Corresponde a la cantidad de victorias del campeón usado por el invocador.
     */
    public void setCantVictorias(int cantVictorias) {
        this.cantVictorias = cantVictorias;
    }

    /**
     * Método que obtiene la cantidad de derrotas del campeón usado por el invocador.
     * @return Cantidad de derrotas del campeón usado por el invocador.
     */
    public int getCantDerrotas() {
        return this.cantDerrotas;
    }

    /**
     * Método que colóca o cambia la cantidad de derrotas del campeón usado por el invocador.
     * @param cantDerrotas Corresponde a la cantidad de derrotas del campeón usado por el invocador.
     */
    public void setCantDerrotas(int cantDerrotas) {
        this.cantDerrotas = cantDerrotas;
    }

    //endregion
}
