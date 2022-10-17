package Taller1;

/**
 * Corresponde a la entidad Invocador.
 */
public class Invocador {

    //region ATRIBUTOS DE LA CLASE INVOCADOR.

    /**
     * Corresponde al nombre del invocador.
     */
    private final String nombreInv;
    /**
     * Corresponde a la contraseña del invocador.
     */
    private final String contrasenia;
    /**
     * Corresponde a la posición principal del invocador.
     */
    private final String posPrincipal;
    /**
     * Corresponde a la posición secundaria del invocador.
     */
    private final String posSecundaria;
    /**
     * Corresponde a los puntos de liga del invocador.
     */
    private int puntosLiga;
    /**
     * Corresponde a la Lista de los campeones del invocador.
     */
    private final ListaCampeonInv listaCampeonInv;

    //endregion




    //region CONSTRUCTOR DE LA CLASE INVOCADORES:

    /**
     * Constructor de la clase invocadores.
     * @param nombreInv Corresponde al nombre del invocador.
     * @param contrasenia Corresponde a la contraseña del invocador.
     * @param posPrincipal Corresponde a la posición principal del invocador.
     * @param posSecundaria Corresponde a la posición secundaria del invocador.
     * @param puntosLiga Corresponde a los puntos de liga del invocador.
     */
    public Invocador(String nombreInv, String contrasenia, String posPrincipal, String posSecundaria, int puntosLiga) {
        this.nombreInv = nombreInv;
        this.contrasenia = contrasenia;
        this.posPrincipal = posPrincipal;
        this.posSecundaria = posSecundaria;
        this.puntosLiga = puntosLiga;
        this.listaCampeonInv = new ListaCampeonInv();
    }

    public Invocador(String nombreInv, String posPrincipal, String posSecundaria, int puntosLiga) {
        this.nombreInv = nombreInv;
        this.posPrincipal = posPrincipal;
        this.posSecundaria = posSecundaria;
        this.puntosLiga = puntosLiga;
        this.listaCampeonInv = new ListaCampeonInv();
    }


    //endregion




    //region GETTER & SETTER DE LA CLASE INVOCADORES:

    /**
     * Método que obtiene el nombre del invocador.
     * @return Nombre del invocador.
     */
    public String getNombreInv() {
        return this.nombreInv;
    }

    /**
     * Método que obtiene la contraseña del invocador.
     * @return Contraseña del invocador.
     */
    public String getContrasenia() {
        return this.contrasenia;
    }

    /**
     * Método que obtiene la posición principal del invocador.
     * @return Posición principal del invocador.
     */
    public String getPosPrincipal() {
        return this.posPrincipal;
    }

    /**
     * Método que obtiene la posición secundaria del invocador.
     * @return Posición secundaria del invocador.
     */
    public String getPosSecundaria() {
        return this.posSecundaria;
    }

    /**
     * Método que obtiene los puntos de liga del invocador.
     * @return Puntos de liga del invocador.
     */
    public int getPuntosLiga() {
        return this.puntosLiga;
    }

    /**
     * Método que colóca o cambia los puntos de liga del invocador.
     * @param puntosLiga Corresponde a los puntos de liga del invocador.
     */
    public void setPuntosLiga(int puntosLiga) {
        this.puntosLiga = puntosLiga;
    }

    /**
     * Método que obtiene la Lista de campeones del invocador.
     * @return Lista de campeones del invocador.
     */
    public ListaCampeonInv getListaCampeonInv() {
        return this.listaCampeonInv;
    }

    //endregion
}
