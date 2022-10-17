package Taller1;

import java.io.IOException;

public class a implements SistemaLeagueOfLegends{
    /**
     * Método que añade los invocadores del archivo invocadores.txt a la ListaInvocador.
     *
     * @param nombreInv     Corresponde al nombre del invocador.
     * @param contrasenia   Corresponde a la contraseña del invocador.
     * @param posPrincipal  Corresponde a la posición principal del invocador.
     * @param posSecundaria Corresponde a la posición secundaria del invocador.
     * @param puntosLiga    Corresponde a los puntos de liga del invocador.
     */
    @Override
    public void registrarArregloInvocador(String nombreInv, String contrasenia, String posPrincipal, String posSecundaria, int puntosLiga) {

    }

    /**
     * Método que añade los campeones del archivo campeones.txt a la ListaCampeon.
     *
     * @param nombreCampeon      Corresponde al nombre del campeón.
     * @param descripcionCampeon Corresponde a la descripción del campeón.
     * @param rolCampeon         Corresponde al rol del campeón.
     * @param posCampeon         Corresponde a la posición del campeón.
     */
    @Override
    public void registrarArregloCampeon(String nombreCampeon, String descripcionCampeon, String rolCampeon, String posCampeon) {

    }

    /**
     * Método para asociar un campeón al invocador.
     *
     * @param nombreCampeon  Corresponde al nombre del campeón.
     * @param puntosMaestria Corresponde a los puntos de maestría que posee el invocador con el campeón.
     * @param cantVictorias  Corresponde a la cantidad de victorias que posee el invocador con el campeón.
     * @param cantDerrotas   Corresponde a la cantidad de derrotas que posee el invocador con el campeón.
     * @param nombreInv      Corresponde al nombre del invocador.
     */
    @Override
    public void asociarCampeonInv(String nombreCampeon, int puntosMaestria, int cantVictorias, int cantDerrotas, String nombreInv) {

    }

    /**
     * Método para iniciar sesión en el sistema.
     *
     * @param nombreInv   Corresponde al nombre del invocador.
     * @param contrasenia Corresponde a la contraseña del invocador.
     * @return "true" si logró entrar al sistema, o "false" si no logró entrar al sistema.
     */
    @Override
    public boolean iniciarSesion(String nombreInv, String contrasenia) {
        return false;
    }

    /**
     * Método para buscar una partida en el sistema.
     *
     * @param nombreInv Corresponde al nombre del invocador.
     * @return Resultado de la partida.
     */
    @Override
    public String buscarPartida(String nombreInv) {
        return null;
    }

    /**
     * Método que permite al usuario ver su perfil.
     *
     * @param nombreInv Corresponde al nombre del invocador.
     * @return Datos del invocador.
     */
    @Override
    public String[] verPerfil(String nombreInv) {
        return new String[0];
    }

    /**
     * Método que permite al usuario consultar sus estadísicas del campeón indicado.
     *
     * @param nombreCampeon Corresponde al nombre del campeón.
     * @return Estadísicas del invocador con el campeón.
     */
    @Override
    public String[] consultarCampeon(String nombreCampeon) {
        return new String[0];
    }

    /**
     * Método que permite al usuario consultar los mejores invocadores del sistema.
     *
     * @return Lista con los mejores invocadores.
     */
    @Override
    public String[] mejoresInvocadores() {
        return new String[0];
    }

    /**
     * Método que permite al usuario consultar los mejores campeones usados por los invocadores del sistema.
     *
     * @return Mejores campeones del sistema.
     */
    @Override
    public String[] mejoresCampeones() {
        return new String[0];
    }

    /**
     * Método que obtiene los campeones con el rol "Tirador" y los almacena en un arreglo.
     *
     * @return Arreglo con los tiradores.
     */
    @Override
    public String[] desplegarTiradores() {
        return new String[0];
    }

    /**
     * Método que obtiene los campeones con el rol "Luchador" y los almacena en un arreglo.
     *
     * @return Arreglo con los luchadores.
     */
    @Override
    public String[] desplegarLuchadores() {
        return new String[0];
    }

    /**
     * Método que obtiene los campeones con el rol "Mago" y los almacena en un arreglo.
     *
     * @return Arreglo con los magos.
     */
    @Override
    public String[] desplegarMagos() {
        return new String[0];
    }

    /**
     * Método que obtiene los campeones con el rol "Asesino" y los almacena en un arreglo.
     *
     * @return Arreglo con los asesinos.
     */
    @Override
    public String[] desplegarAsesinos() {
        return new String[0];
    }

    /**
     * Método que obtiene los campeones con el rol "Tanque" y los almacena en un arreglo.
     *
     * @return Arreglo con los tanques.
     */
    @Override
    public String[] desplegarTanques() {
        return new String[0];
    }

    /**
     * Método que sobreescribe el archivo invocadores.txt y lo guarda.
     *
     * @throws IOException Detiene la carga/escritura del archivo si ocurre algun error.
     */
    @Override
    public void guardarInvocador() throws IOException {

    }

    /**
     * Método que vuelve al menú inicial.
     */
    @Override
    public void volverMenuPrincipal() {

    }

    /**
     * Método que obtiene el nombre del invocador logueado en el sistema.
     *
     * @return Invocador logueado.
     */
    @Override
    public String obtenerNombreInvLog() {
        return null;
    }

    /**
     * Método que obtiene la cantidad máxima del arreglo de los campeones del invocador.
     *
     * @return Cantidad máxima de ListaCampeonesInv.
     */
    @Override
    public int obtenerCantMaxCampeonInv() {
        return 0;
    }

    /**
     * Método que obtiene el porcentaje de victorias del campeón según todos los invocadores.
     *
     * @param nombreCampeon Corresponde al nombre del campeón/
     * @return Porcentaje de victorias del campeón según todos los invocadores.
     */
    @Override
    public String obtenerPorcentajeVictoriasTodos(String nombreCampeon) {
        return null;
    }

    /**
     * Método que busca un campeón dentro la de ListaCampeonInv.
     *
     * @param nombreCampeon Corresponde al nombre del campeón.
     * @return "true" si el no campeón existe dentro de la lista, "false" si existe.
     */
    @Override
    public boolean buscarCampeon(String nombreCampeon) {
        return false;
    }

    /**
     * Método que verifica el nombre del campeón de ListaCampeonesInv.
     *
     * @param nombreCampeon Corresponde al nombre del campeón.
     * @return "true" si el campeón no existe en la lista de campeones del invocador, "false" si existe.
     */
    @Override
    public boolean verificarNombreCampeon(String nombreCampeon) {
        return false;
    }

    /**
     * Método que verifica si el nombre de usuario ingresado por teclado existe en el sistema.
     *
     * @param nombreInv Corresponde al nombre de usuario del invocador.
     * @return "true" si el nombre de usuario no existe, "false" si el nombre de usuario existe.
     */
    @Override
    public boolean verificarNombreUsuario(String nombreInv) {
        return false;
    }

    /**
     * Método que comprueba todas las combinaciones posibles de posiciones del invocador para obtener las restantes.
     *
     * @return Arreglo con las posiciones restantes del invocador.
     */
    @Override
    public String[] combinacionesPosicion() {
        return new String[0];
    }
}
