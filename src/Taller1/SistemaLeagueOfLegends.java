package Taller1;

import java.io.IOException;

/**
 * Interface del programa.
 */
public interface SistemaLeagueOfLegends {

    //region REQUERIMIENTOS DEL SISTEMA.
    /**
     * Método que añade los invocadores del archivo invocadores.txt a la ListaInvocador.
     * @param nombreInv Corresponde al nombre del invocador.
     * @param contrasenia Corresponde a la contraseña del invocador.
     * @param posPrincipal Corresponde a la posición principal del invocador.
     * @param posSecundaria Corresponde a la posición secundaria del invocador.
     * @param puntosLiga Corresponde a los puntos de liga del invocador.
     */
    void registrarArregloInvocador(String nombreInv, String contrasenia, String posPrincipal, String posSecundaria, int puntosLiga);

    /**
     * Método que añade los campeones del archivo campeones.txt a la ListaCampeon.
     * @param nombreCampeon Corresponde al nombre del campeón.
     * @param descripcionCampeon Corresponde a la descripción del campeón.
     * @param rolCampeon Corresponde al rol del campeón.
     * @param posCampeon Corresponde a la posición del campeón.
     */
    void registrarArregloCampeon(String nombreCampeon, String descripcionCampeon, String rolCampeon, String posCampeon);

    /**
     * Método para asociar un campeón al invocador.
     * @param nombreCampeon Corresponde al nombre del campeón.
     * @param puntosMaestria Corresponde a los puntos de maestría que posee el invocador con el campeón.
     * @param cantVictorias Corresponde a la cantidad de victorias que posee el invocador con el campeón.
     * @param cantDerrotas Corresponde a la cantidad de derrotas que posee el invocador con el campeón.
     * @param nombreInv Corresponde al nombre del invocador.
     */
    void asociarCampeonInv(String nombreCampeon, int puntosMaestria, int cantVictorias, int cantDerrotas, String nombreInv);

    /**
     * Método para iniciar sesión en el sistema.
     * @param nombreInv Corresponde al nombre del invocador.
     * @param contrasenia Corresponde a la contraseña del invocador.
     * @return "true" si logró entrar al sistema, o "false" si no logró entrar al sistema.
     */
    boolean iniciarSesion(String nombreInv, String contrasenia);

    /**
     * Método para buscar una partida en el sistema.
     * @param nombreInv Corresponde al nombre del invocador.
     * @return Resultado de la partida.
     */
    String buscarPartida(String nombreInv);

    /**
     * Método que permite al usuario ver su perfil.
     * @param nombreInv Corresponde al nombre del invocador.
     * @return Datos del invocador.
     */
    String[] verPerfil(String nombreInv);

    /**
     * Método que permite al usuario consultar sus estadísicas del campeón indicado.
     * @param nombreCampeon Corresponde al nombre del campeón.
     * @return Estadísicas del invocador con el campeón.
     */
    String[] consultarCampeon(String nombreCampeon);

    /**
     * Método que permite al usuario consultar los mejores invocadores del sistema.
     * @return Lista con los mejores invocadores.
     */
    String[] mejoresInvocadores();

    /**
     * Método que permite al usuario consultar los mejores campeones usados por los invocadores del sistema.
     * @return Mejores campeones del sistema.
     */
    String[] mejoresCampeones();

    /**
     * Método que obtiene los campeones con el rol "Tirador" y los almacena en un arreglo.
     * @return Arreglo con los tiradores.
     */
    String[] desplegarTiradores();

    /**
     * Método que obtiene los campeones con el rol "Luchador" y los almacena en un arreglo.
     * @return Arreglo con los luchadores.
     */
    String[] desplegarLuchadores();

    /**
     * Método que obtiene los campeones con el rol "Mago" y los almacena en un arreglo.
     * @return Arreglo con los magos.
     */
    String[] desplegarMagos();

    /**
     * Método que obtiene los campeones con el rol "Asesino" y los almacena en un arreglo.
     * @return Arreglo con los asesinos.
     */
    String[] desplegarAsesinos();

    /**
     * Método que obtiene los campeones con el rol "Tanque" y los almacena en un arreglo.
     * @return Arreglo con los tanques.
     */
    String[] desplegarTanques();

    /**
     * Método que sobreescribe el archivo invocadores.txt y lo guarda.
     * @throws IOException Detiene la carga/escritura del archivo si ocurre algun error.
     */
    void guardarInvocador() throws IOException;

    /**
     * Método que vuelve al menú inicial.
     */
    void volverMenuPrincipal();
    //endregion




    //region METODOS QUE OBTIENEN VARIABLES.

    /**
     * Método que obtiene el nombre del invocador logueado en el sistema.
     * @return Invocador logueado.
     */
    String obtenerNombreInvLog();

    /**
     * Método que obtiene la cantidad máxima del arreglo de los campeones del invocador.
     * @return Cantidad máxima de ListaCampeonesInv.
     */
    int obtenerCantMaxCampeonInv();

    /**
     * Método que obtiene el porcentaje de victorias del campeón según todos los invocadores.
     * @param nombreCampeon Corresponde al nombre del campeón/
     * @return Porcentaje de victorias del campeón según todos los invocadores.
     */
    String obtenerPorcentajeVictoriasTodos(String nombreCampeon);

    /**
     * Método que busca un campeón dentro la de ListaCampeonInv.
     * @param nombreCampeon Corresponde al nombre del campeón.
     * @return "true" si el no campeón existe dentro de la lista, "false" si existe.
     */
    boolean buscarCampeon(String nombreCampeon);

    /**
     * Método que verifica el nombre del campeón de ListaCampeonesInv.
     * @param nombreCampeon Corresponde al nombre del campeón.
     * @return "true" si el campeón no existe en la lista de campeones del invocador, "false" si existe.
     */
    boolean verificarNombreCampeon(String nombreCampeon);

    /**
     * Método que verifica si el nombre de usuario ingresado por teclado existe en el sistema.
     * @param nombreInv Corresponde al nombre de usuario del invocador.
     * @return "true" si el nombre de usuario no existe, "false" si el nombre de usuario existe.
     */
    boolean verificarNombreUsuario(String nombreInv);

    /**
     * Método que comprueba todas las combinaciones posibles de posiciones del invocador para obtener las restantes.
     * @return Arreglo con las posiciones restantes del invocador.
     */
    String[] combinacionesPosicion();

    //endregion
}
