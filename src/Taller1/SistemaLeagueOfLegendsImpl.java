package Taller1;

import ucn.ArchivoSalida;
import ucn.Registro;

import java.io.IOException;
import java.text.NumberFormat;

/**
 * Clase principal, se encarga de implementar el interface.
 */
public class SistemaLeagueOfLegendsImpl implements SistemaLeagueOfLegends {

    //region ATRIBUTOS DE LA CLASE.

    /**
     * Corresponde a la Lista de Campeones.
     */
    private final ListaCampeon listaCampeon;
    /**
     * Corresponde a la Lista de Invocadores.
     */
    private final ListaInvocador listaInvocador;
    /**
     * Corresponde al invocador logueado en el sistema.
     */
    private Invocador invocador;

    //endregion













    //region CONSTRUCTOR DE LA CLASE.
    /**
     * Constructor de la clase SistemaLeagueOfLeguendsImlp.
     */
    public SistemaLeagueOfLegendsImpl() {
        this.listaCampeon = new ListaCampeon();
        this.listaInvocador = new ListaInvocador();
        this.invocador = null;
    }

    //endregion




    //region REQUERIMIENTOS DEL SISTEMA.

    /**
     * Método que añade los invocadores del archivo invocadores.txt a la ListaInvocador.
     * @param nombreInv     Corresponde al nombre del invocador.
     * @param contrasenia   Corresponde a la contraseña del invocador.
     * @param posPrincipal  Corresponde a la posición principal del invocador.
     * @param posSecundaria Corresponde a la posición secundaria del invocador.
     * @param puntosLiga    Corresponde a los puntos de liga del invocador.
     */
    @Override
    public void registrarArregloInvocador(String nombreInv, String contrasenia, String posPrincipal, String posSecundaria, int puntosLiga) {

        Invocador invocador2 = new Invocador(nombreInv, contrasenia, posPrincipal, posSecundaria, puntosLiga);

        this.listaInvocador.agregarInvocador(invocador2);

    }

    /**
     * Método que añade los campeones del archivo campeones.txt a la ListaCampeon.
     * @param nombreCampeon      Corresponde al nombre del campeón.
     * @param descripcionCampeon Corresponde a la descripción del campeón.
     * @param rolCampeon         Corresponde al rol del campeón.
     * @param posCampeon         Corresponde a la posición del campeón.
     */
    @Override
    public void registrarArregloCampeon(String nombreCampeon, String descripcionCampeon, String rolCampeon, String posCampeon) {
        Campeon campeon = new Campeon(nombreCampeon, descripcionCampeon, rolCampeon, posCampeon);
        this.listaCampeon.agregarCampeon(campeon);
    }

    /**
     * Método para asociar un campeón al invocador.
     * @param nombreCampeon  Corresponde al nombre del campeón.
     * @param puntosMaestria Corresponde a los puntos de maestría que posee el invocador con el campeón.
     * @param cantVictorias  Corresponde a la cantidad de victorias que posee el invocador con el campeón.
     * @param cantDerrotas   Corresponde a la cantidad de derrotas que posee el invocador con el campeón.
     * @param nombreInv      Corresponde al nombre del invocador.
     */
    @Override
    public void asociarCampeonInv(String nombreCampeon, int puntosMaestria, int cantVictorias, int cantDerrotas, String nombreInv) {
        for (int i = 0; i < this.listaInvocador.getCantInvocador(); i++) {
            if (this.listaInvocador.getVecInvocador()[i].getNombreInv().equals(nombreInv)){
                CampeonInv campeonInv = new CampeonInv(nombreCampeon, puntosMaestria, cantVictorias, cantDerrotas);
                this.listaInvocador.getVecInvocador()[i].getListaCampeonInv().agregarCampeonInv(campeonInv);
            }
        }
    }

    /**
     * Método para iniciar sesión en el sistema.
     * @param nombreInv   Corresponde al nombre del invocador.
     * @param contrasenia Corresponde a la contraseña del invocador.
     * @return "true" si logró entrar al sistema, o "false" si no logró entrar al sistema.
     */
    @Override
    public boolean iniciarSesion(String nombreInv, String contrasenia) {

        for (int i = 0; i < listaInvocador.getCantInvocador(); i++) {
            //este for recorre la lista de usuarios.
            if (listaInvocador.getVecInvocador()[i].getNombreInv().equals(nombreInv) &&
                    listaInvocador.getVecInvocador()[i].getContrasenia().equals(contrasenia)){
                //En el if anterior se pregunta si el usuario de la posicion i y la contraseña
                // de ese usuario coincide con la pasada por parámetros.
                this.invocador = listaInvocador.getVecInvocador()[i];
                //Cuando coincida entonces el usuario actual o usuario dentro del sistema va a
                // ser el usuario encontrado.
                return true;
            }
        }
        return false;
        //Retorna falso porque no encontró ningun usuario con nombre y
        // la contraseña solicitados.
    }

    /**
     * Método para buscar una partida en el sistema.
     * @param nombreInv Corresponde al nombre del invocador.
     * @return Resultado de la partida.
     */
    @Override
    public String buscarPartida(String nombreInv) {
        //Estado inicial de la partida.
        String resultadoPartida = null;

        //Genera un número aleatorio para usarlo para buscar probabilidad.
        double nAleatorioPosA = (Math.random());
        //Posición durante la partida que se le da al jugador.
        String posicionAsignada = null;
        //Campeon que juega el jugador durante la partida.
        String campeonEscogido = null;

        //Se hace uso de un subprograma que filtra segun las posiciones del invocador, las posiciones libres.
        String[] vecPosAlt = combinacionesPosicion();

        if (0.2 <= nAleatorioPosA){//80% de probabilidad de jugar su posición principal.
            posicionAsignada = this.invocador.getPosPrincipal();

        }else if (0.15 <= nAleatorioPosA && nAleatorioPosA < 0.2){//15% de probabilidad de jugar su posición secundaria.
            posicionAsignada = this.invocador.getPosSecundaria();

        }else if (nAleatorioPosA < 0.15){//5% de probabilidad de jugar cualquier otra posición.

            //Se genera otro número aleatorio para elegir cualquiera de las posiciones restantes.
            double nAleatorioPosB = (Math.random());

            if ((double)2/3 <= nAleatorioPosB){
                posicionAsignada = vecPosAlt[0];
            }else if ((double)1/3 <= nAleatorioPosB && nAleatorioPosB < (double)2/3){
                posicionAsignada = vecPosAlt[1];
            }else if (nAleatorioPosB < (double)1/3){
                posicionAsignada = vecPosAlt[2];
            }
        }
        //Ciclo for que permite que se revise y se compruebe con probabilidades si el campeón es escogido o no.
        for (int i = 0; i < this.invocador.getListaCampeonInv().getCantCampeonInv(); i++) {

            if (campeonEscogido == null) {
                String nombreCampeonInv = this.invocador.getListaCampeonInv().getVecCampeonInv()[i].getNombreCampeon();

                for (int j = 0; j < listaCampeon.getCantCampeones(); j++) {

                    if (listaCampeon.getVecCampeones()[j].getNombreCampeon().equals(nombreCampeonInv)) {

                        String posCampeon = listaCampeon.getVecCampeones()[j].getPosCampeon();

                        if (posCampeon.equals(posicionAsignada)) {
                            double nAleatorioChamp = Math.random();

                            if (0.1 <= nAleatorioChamp) {//90% de probabilidad de escogerlo.
                                campeonEscogido = listaCampeon.getVecCampeones()[j].getNombreCampeon();

                                //Si lo escoje se juega la partida.

                                double nAleatorioPartidaA = Math.random();

                                if (0.2 <= nAleatorioPartidaA){//80% de probabilidad de ganar.

                                    resultadoPartida = "¡Ganaste! || +20PL || +2000 Puntos de Maestría con "+campeonEscogido;

                                    int puntosMaestria = 2000 + this.invocador.getListaCampeonInv().getVecCampeonInv()[i].getPuntosMaestria();
                                    int cantVictorias = 1 + this.invocador.getListaCampeonInv().getVecCampeonInv()[i].getCantVictorias();
                                    int puntosLiga = 20 + this.invocador.getPuntosLiga();
                                    
                                    this.invocador.getListaCampeonInv().getVecCampeonInv()[i].setPuntosMaestria(puntosMaestria);
                                    this.invocador.getListaCampeonInv().getVecCampeonInv()[i].setCantVictorias(cantVictorias);
                                    this.invocador.setPuntosLiga(puntosLiga);
                                    
                                }else if (nAleatorioPartidaA < 0.2){//20% de probabilidad de perder.

                                    resultadoPartida = "Lastima, Perdiste || -15PL || +500 Puntos de Maestría con "+campeonEscogido;

                                    int puntosMaestria = 500 + this.invocador.getListaCampeonInv().getVecCampeonInv()[i].getPuntosMaestria();
                                    int cantDerrotas = 1 + this.invocador.getListaCampeonInv().getVecCampeonInv()[i].getCantDerrotas();
                                    int puntosLiga = this.invocador.getPuntosLiga() - 15;

                                    this.invocador.getListaCampeonInv().getVecCampeonInv()[i].setPuntosMaestria(puntosMaestria);
                                    this.invocador.getListaCampeonInv().getVecCampeonInv()[i].setCantDerrotas(cantDerrotas);
                                    this.invocador.setPuntosLiga(puntosLiga);
                                }

                            } else {//10% de probabilidad de escogerlo.
                                campeonEscogido = null;
                            }
                        }
                    }
                }
            }
        }
        //Si el jugador no logra escojer algún campeón de su lista se escoje uno al azar según la posición asignada.
        if (campeonEscogido == null){

            while (campeonEscogido == null){
                //Vector con los nombres de los campeones que coinciden con la posición asignada.
                String[] vecCampPosAlt = new String[listaCampeon.getCantCampeones()];

                for (int i = 0; i < listaCampeon.getCantCampeones(); i++) {

                    if (listaCampeon.getVecCampeones()[i].getPosCampeon().equals(posicionAsignada)){
                        vecCampPosAlt[i] = listaCampeon.getVecCampeones()[i].getNombreCampeon();
                    }
                }
                //Se escoje un campeón al azar usando un número aleatorio que va desde el 0 al 150.
                //Si resulta ser "null" el while permite que el ciclo se repita hasta que sea válido.
                campeonEscogido = vecCampPosAlt[(int)(Math.random()*listaCampeon.getCantCampeones())];
            }
            
            //Se genera un número aleatorio para usarlo para buscar probabilidad.
            double nAleatorioPartidaB = Math.random();

            if (0.7 <= nAleatorioPartidaB){//30% de probabilidad de ganar.

                resultadoPartida = "¡Ganaste tu primera partida con " + campeonEscogido + "! || +20PL || +500 Puntos de Maestría con " + campeonEscogido;

                int puntosLiga = 20 + this.invocador.getPuntosLiga();

                asociarCampeonInv(campeonEscogido,500,1,0,this.invocador.getNombreInv());
                this.invocador.setPuntosLiga(puntosLiga);

            }else if (nAleatorioPartidaB < 0.7) {//70% de probabilidad de perder.

                resultadoPartida = "Lastima, perdiste tu primera partida con "+ campeonEscogido + "! || -15PL || +100 Puntos de Maestría con " + campeonEscogido;

                int puntosLiga = this.invocador.getPuntosLiga() - 15;

                asociarCampeonInv(campeonEscogido, 100, 0, 1, this.invocador.getNombreInv());
                this.invocador.setPuntosLiga(puntosLiga);
            }
        }

        return resultadoPartida;
    }

    /**
     * Método que permite al usuario ver su perfil.
     * @param nombreInv Corresponde al nombre del invocador.
     * @return Datos del invocador.
     */
    @Override
    public String[] verPerfil(String nombreInv) {

        //En esta region de guarda el metodo usado para sacar el porcentaje de victorias del invocador conectado.
        //region Porcentaje de Victorias.
        double[] vecVictorias = new double[obtenerCantMaxCampeonInv()];

        for (int i = 0; i < this.invocador.getListaCampeonInv().getCantCampeonInv(); i++) {

            vecVictorias[i] = this.invocador.getListaCampeonInv().getVecCampeonInv()[i].getCantVictorias();





        }

        double[] vecDerrotas = new double[obtenerCantMaxCampeonInv()];

        for (int i = 0; i < this.invocador.getListaCampeonInv().getCantCampeonInv(); i++) {

            vecDerrotas[i] = this.invocador.getListaCampeonInv().getVecCampeonInv()[i].getCantDerrotas();
        }

        double cantVic = 0;
        double cantDer = 0;

        for (int i = 0; i < vecVictorias.length ; i++) {

            cantVic += vecVictorias[i];
            cantDer += vecDerrotas[i];
        }

        double porcentajeVic;

        if (cantVic == 0 && cantDer == 0){
            porcentajeVic = 0;

        }else{
            porcentajeVic = (cantVic*100)/(cantVic+cantDer);
        }

        //endregion

        int posMejorCampeon = 0;
        int maestria = 0;

        for (int i = 0; i < this.invocador.getListaCampeonInv().getCantCampeonInv(); i++) {

            if (this.invocador.getListaCampeonInv().getVecCampeonInv()[i].getPuntosMaestria() > maestria){
                maestria = this.invocador.getListaCampeonInv().getVecCampeonInv()[i].getPuntosMaestria();
                posMejorCampeon = i;
            }
        }
        //Inicialización de variables.
        nombreInv = this.invocador.getNombreInv();
        String PL;
        String mejorCampeon;
        int ptosMaestria;

        //Si el invocador no tiene campeones, las variables de colocan como vacías o 0.
        if(this.invocador.getListaCampeonInv().getCantCampeonInv() == 0){
            mejorCampeon = "";
            ptosMaestria = 0;
            PL = "0";
        }else{
            mejorCampeon = this.invocador.getListaCampeonInv().getVecCampeonInv()[posMejorCampeon].getNombreCampeon();
            ptosMaestria = this.invocador.getListaCampeonInv().getVecCampeonInv()[posMejorCampeon].getPuntosMaestria();
            PL =  "" + this.invocador.getPuntosLiga();
        }



        //Truncar la probabilidad para que se guarde con máximo dos decimáles.
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        String porcentajeVicStr = nf.format(porcentajeVic);

        //Se crea un vector de String para almacenar la información y llevarla al Main.
        String[] verPerfil = new String[5];
        verPerfil[0] = nombreInv;
        verPerfil[1] = PL;
        verPerfil[2] = porcentajeVicStr;
        verPerfil[3] = mejorCampeon;

        //Se comprueba que los puntos de maestria no sean 0, si son 0 en el main no se despliegan.
        if (ptosMaestria == 0){
            verPerfil[4] = null;
        }else{
            verPerfil[4] = "" + ptosMaestria;
        }

        return verPerfil;
    }

    /**
     * Método que permite al usuario consultar sus estadísicas del campeón indicado.
     * @param nombreCampeon Corresponde al nombre del campeón.
     * @return Estadísicas del invocador con el campeón.
     */
    @Override
    public String[] consultarCampeon(String nombreCampeon) {

        //Inicialización de variables.
        String nombreCampeonConsulta = null;
        String descripcionCampeonConsulta = "";
        String rolCampeonConsulta = "";

        //Ciclo for que comprueba que recorre la lista de campeones.
        for (int i = 0; i < listaCampeon.getCantCampeones(); i++) {
            //Comprobación de si existe el campeón en la lista de campeones del invocador.
            if (listaCampeon.getVecCampeones()[i].getNombreCampeon().equalsIgnoreCase(nombreCampeon)){
                nombreCampeonConsulta = listaCampeon.getVecCampeones()[i].getNombreCampeon();
                descripcionCampeonConsulta = listaCampeon.getVecCampeones()[i].getDescripcionCampeon();
                rolCampeonConsulta = listaCampeon.getVecCampeones()[i].getRolCampeon();
            }
        }

        //Vector que contendrá la información necesaria para ejecutar el requerimiento en el main.
        String[] campeonConsulta = new String[5];

        campeonConsulta[0] = nombreCampeonConsulta;
        campeonConsulta[1] = descripcionCampeonConsulta;
        campeonConsulta[2] = rolCampeonConsulta;
        //La posición 3 del vector contiene un comodín para que no se muestren campeones al momento de su ejecución.
        if (nombreCampeonConsulta == null){
            campeonConsulta[3] = "";
        }
        campeonConsulta[4] = obtenerPorcentajeVictoriasTodos(nombreCampeonConsulta);

        return campeonConsulta;
    }

    /**
     * Método que permite al usuario consultar los mejores invocadores del sistema.
     * @return Lista con los mejores invocadores.
     */
    @Override
    public String[] mejoresInvocadores() {
        //Inicialización de variables.
        int PL = 0;
        int posMayor = 0;
        int antPL = 0;
        int posAnterior = 0;

        //Ciclo for para buscar a el invocador con el mayor número de puntos de liga.
        for (int i = 0; i < listaInvocador.getCantInvocador(); i++) {
            if (listaInvocador.getVecInvocador()[i].getPuntosLiga() > PL){
                PL = listaInvocador.getVecInvocador()[i].getPuntosLiga();
                posMayor = i;
            }
        }
        int mayorPL = listaInvocador.getVecInvocador()[posMayor].getPuntosLiga();
        String primerMejorInv = listaInvocador.getVecInvocador()[posMayor].getNombreInv();

        //Ciclo for para buscar a el segundo mejor invocador con el mayor número de puntos de liga.
        for (int i = 0; i < listaInvocador.getCantInvocador(); i++) {
            if (listaInvocador.getVecInvocador()[i].getPuntosLiga() > antPL && listaInvocador.getVecInvocador()[i].getPuntosLiga() <= mayorPL && !listaInvocador.getVecInvocador()[i].getNombreInv().equals(primerMejorInv)){
                antPL = listaInvocador.getVecInvocador()[i].getPuntosLiga();
                posAnterior = i;
            }
        }
        int anteriorMayorPL = listaInvocador.getVecInvocador()[posAnterior].getPuntosLiga();
        String anteriorPrimerMejorInv = listaInvocador.getVecInvocador()[posAnterior].getNombreInv();

        String mayorPLStr =""+mayorPL;
        String antMayorPLStr =""+anteriorMayorPL;

        //Vector con la información necesaria para ejecutar el requerimiento en el main.
        String[] vecMejores = new String[4];
        vecMejores[0] = primerMejorInv;
        vecMejores[1] = mayorPLStr;
        vecMejores[2] = anteriorPrimerMejorInv;
        vecMejores[3] = antMayorPLStr;

        return vecMejores;
    }

    /**
     * Método que permite al usuario consultar los mejores campeones usados por los invocadores del sistema.
     *
     * @return Mejores campeones del sistema.
     */
    @Override
    public String[] mejoresCampeones() {

        for (int i = 0; i < listaInvocador.getCantInvocador(); i++) {

            Invocador invocador = listaInvocador.getVecInvocador()[i];

            for (int j = 0; j < invocador.getListaCampeonInv().getCantCampeonInv(); j++) {



            }

            
        }





        return null;
    }

    /**
     * Método que obtiene los campeones con el rol "Tirador" y los almacena en un arreglo.
     * @return Arreglo con los tiradores.
     */
    @Override
    public String[] desplegarTiradores() {

        String[] vecTiradores = new String[((listaCampeon.getCantMax())*2)];

        for (int i = 0; i < listaCampeon.getCantMax(); i++) {

            if (listaCampeon.getVecCampeones()[i].getRolCampeon().equals("tirador")) {

                String tirador =  listaCampeon.obtenerCampeon(i).getNombreCampeon() +", "+listaCampeon.getVecCampeones()[i].getDescripcionCampeon()+ "----------->" + listaCampeon.getVecCampeones()[i].getPosCampeon();

                vecTiradores[i] = tirador;
            }
        }
        return vecTiradores;
    }

    /**
     * Método que obtiene los campeones con el rol "Luchador" y los almacena en un arreglo.
     * @return Arreglo con los luchadores.
     */
    @Override
    public String[] desplegarLuchadores() {
        String[] vecLuchadores = new String[((listaCampeon.getCantMax())*2)];

        for (int i = 0; i < listaCampeon.getCantMax(); i++) {

            if (listaCampeon.getVecCampeones()[i].getRolCampeon().equals("luchador")) {

                String luchador = listaCampeon.obtenerCampeon(i).getNombreCampeon() +", "+listaCampeon.getVecCampeones()[i].getDescripcionCampeon()+ "----------->" + listaCampeon.getVecCampeones()[i].getPosCampeon();

                vecLuchadores[i] = luchador;
            }
        }
        return vecLuchadores;
    }

    /**
     * Método que obtiene los campeones con el rol "Mago" y los almacena en un arreglo.
     * @return Arreglo con los magos.
     */
    @Override
    public String[] desplegarMagos() {
        String[] vecMagos = new String[((listaCampeon.getCantMax())*2)];

        for (int i = 0; i < listaCampeon.getCantMax(); i++) {

            if (listaCampeon.getVecCampeones()[i].getRolCampeon().equals("mago")) {

                String mago =  listaCampeon.obtenerCampeon(i).getNombreCampeon() +", "+listaCampeon.getVecCampeones()[i].getDescripcionCampeon()+ "----------->" + listaCampeon.getVecCampeones()[i].getPosCampeon();

                vecMagos[i] = mago;
            }
        }
        return vecMagos;
    }

    /**
     * Método que obtiene los campeones con el rol "Asesino" y los almacena en un arreglo.
     * @return Arreglo con los asesinos.
     */
    @Override
    public String[] desplegarAsesinos() {
        String[] vecAsesinos = new String[((listaCampeon.getCantMax())*2)];

        for (int i = 0; i < listaCampeon.getCantMax(); i++) {

            if (listaCampeon.getVecCampeones()[i].getRolCampeon().equals("asesino")) {

                String asesino =  listaCampeon.obtenerCampeon(i).getNombreCampeon() +", "+listaCampeon.getVecCampeones()[i].getDescripcionCampeon()+ "----------->" + listaCampeon.getVecCampeones()[i].getPosCampeon();

                vecAsesinos[i] = asesino;
            }
        }
        return vecAsesinos;
    }

    /**
     * Método que obtiene los campeones con el rol "Tanque" y los almacena en un arreglo.
     * @return Arreglo con los tanques.
     */
    @Override
    public String[] desplegarTanques() {
        String[] vecTanques = new String[((listaCampeon.getCantMax())*2)];

        for (int i = 0; i < listaCampeon.getCantMax(); i++) {

            if (listaCampeon.getVecCampeones()[i].getRolCampeon().equals("tanque")) {

                String tanque =  listaCampeon.obtenerCampeon(i).getNombreCampeon() +", "+listaCampeon.getVecCampeones()[i].getDescripcionCampeon()+ "----------->" + listaCampeon.getVecCampeones()[i].getPosCampeon();

                vecTanques[i] = tanque;
            }
        }
        return vecTanques;
    }

    /**
     * Método que sobreescribe el archivo invocadores.txt y lo guarda.
     * @throws IOException Detiene la carga/escritura del archivo si ocurre algun error.
     */
    @Override
    public void guardarInvocador() throws IOException {
        ArchivoSalida file = new ArchivoSalida("invocadores.txt");

        for (int i = 0; i < listaInvocador.getCantInvocador(); i++) {

            Invocador invocador = this.listaInvocador.getVecInvocador()[i];

            Registro line = new Registro(6);

            line.agregarCampo(invocador.getNombreInv());
            line.agregarCampo(invocador.getContrasenia());
            line.agregarCampo(invocador.getPuntosLiga());
            line.agregarCampo(invocador.getPosPrincipal());
            line.agregarCampo(invocador.getPosSecundaria());
            line.agregarCampo(invocador.getListaCampeonInv().getCantCampeonInv());
            file.writeRegistro(line);

            for (int j = 0; j < invocador.getListaCampeonInv().getCantCampeonInv() ; j++) {
                CampeonInv campeonInv = invocador.getListaCampeonInv().getVecCampeonInv()[j];
                Registro liner = new Registro(4);
                liner.agregarCampo(campeonInv.getNombreCampeon());
                liner.agregarCampo(campeonInv.getPuntosMaestria());
                liner.agregarCampo(campeonInv.getCantVictorias());
                liner.agregarCampo(campeonInv.getCantDerrotas());
                file.writeRegistro(liner);
            }
        }
        file.close();
    }

    /**
     * Método que vuelve al menú inicial.
     *
     */
    @Override
    public void volverMenuPrincipal() {
        this.invocador = null;
    }

    //endregion




    //region METODOS QUE OBTIENEN VARIABLES.

    /**
     * Método que obtiene el nombre del invocador logueado en el sistema.
     * @return Invocador logueado.
     */
    @Override
    public String obtenerNombreInvLog() {
        return this.invocador.getNombreInv();
    }

    /**
     * Método que obtiene la cantidad máxima del arreglo de los campeones del invocador.
     * @return Cantidad máxima de ListaCampeonesInv.
     */
    @Override
    public int obtenerCantMaxCampeonInv() {
        return this.invocador.getListaCampeonInv().getCantCampeonInv();
    }

    /**
     * Método que obtiene el porcentaje de victorias del campeón según todos los invocadores.
     * @param nombreCampeon Corresponde al nombre del campeón/
     * @return Porcentaje de victorias del campeón según todos los invocadores.
     */
    @Override
    public String obtenerPorcentajeVictoriasTodos(String nombreCampeon) {

        int cantVic = 0;
        int cantDer = 0;

        for (int i = 0; i < listaInvocador.getCantInvocador(); i++) {

            Invocador invocador = listaInvocador.getVecInvocador()[i];

            for (int j = 0; j < invocador.getListaCampeonInv().getCantCampeonInv(); j++) {

                if (invocador.getListaCampeonInv().getVecCampeonInv()[j].getNombreCampeon().equals(nombreCampeon)){
                    cantVic += invocador.getListaCampeonInv().getVecCampeonInv()[j].getCantVictorias();
                    cantDer += invocador.getListaCampeonInv().getVecCampeonInv()[j].getCantDerrotas();
                }
            }
        }

        double porcentajeVicTotal;

        if (cantVic == 0 && cantDer == 0){
            porcentajeVicTotal = 0;

        }else{
            porcentajeVicTotal = (cantVic*100)/(cantVic+cantDer);
        }

        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        
        
        return nf.format(porcentajeVicTotal);
    }

    /**
     * Método que busca un campeón dentro la de ListaCampeonInv.
     * @param nombreCampeon Corresponde al nombre del campeón.
     * @return "true" si el no campeón existe dentro de la lista, "false" si existe.
     */
    @Override
    public boolean buscarCampeon(String nombreCampeon) {

        for (int i = 0; i < listaCampeon.getCantCampeones(); i++) {
            if (listaCampeon.getVecCampeones()[i].getNombreCampeon().equals(nombreCampeon)){
                return true;
            }
        }
        return false;
    }

    /**
     * Método que verifica el nombre del campeón de ListaCampeonesInv.
     * @param nombreCampeon Corresponde al nombre del campeón.
     * @return "true" si el campeón no existe en la lista de campeones del invocador, "false" si existe.
     */
    @Override
    public boolean verificarNombreCampeon(String nombreCampeon) {
        for (int i = 0; i < this.invocador.getListaCampeonInv().getCantCampeonInv(); i++) {
            if (this.invocador.getListaCampeonInv().getVecCampeonInv()[i].getNombreCampeon().equals(nombreCampeon)){
                return false;
            }
        }
        return true;
    }

    /**
     * Método que verifica si el nombre de usuario ingresado por teclado existe en el sistema.
     * @param nombreInv Corresponde al nombre de usuario del invocador.
     * @return "true" si el nombre de usuario no existe, "false" si el nombre de usuario existe.
     */
    @Override
    public boolean verificarNombreUsuario(String nombreInv) {
        for (int i = 0; i < listaInvocador.getCantInvocador(); i++) {
            if (listaInvocador.getVecInvocador()[i].getNombreInv().equals(nombreInv)){
                return false;
            }
        }
        return true;
    }

    /**
     * Método que comprueba todas las combinaciones posibles de posiciones del invocador para obtener las restantes.
     * @return Arreglo con las posiciones restantes del invocador.
     */
    @Override
    public String[] combinacionesPosicion() {

        //Inicialización de variables.
        String posPrincipal = this.invocador.getPosPrincipal();
        String posSecundaria = this.invocador.getPosSecundaria();
        String pos3 = null;
        String pos4 = null;
        String pos5 = null;

        //Se buscan las posiciones restantes verificando cada combinatoria posible.
        if (posPrincipal.equals("superior") && posSecundaria.equals("jungla")){
            pos3 = "central";
            pos4 = "soporte";
            pos5 = "inferior";
        }else if (posPrincipal.equals("superior") && posSecundaria.equals("central")){
            pos3 = "jungla";
            pos4 = "soporte";
            pos5 = "inferior";
        }else if (posPrincipal.equals("superior") && posSecundaria.equals("soporte")){
            pos3 = "superior";
            pos4 = "jungla";
            pos5 = "inferior";
        }else if (posPrincipal.equals("superior") && posSecundaria.equals("inferior")){
            pos3 = "superior";
            pos4 = "jungla";
            pos5 = "central";
        }else if (posPrincipal.equals("jungla") && posSecundaria.equals("superior")){
            pos3 = "central";
            pos4 = "soporte";
            pos5 = "inferior";
        }else if (posPrincipal.equals("jungla") && posSecundaria.equals("central")){
            pos3 = "superior";
            pos4 = "soporte";
            pos5 = "inferior";
        }else if (posPrincipal.equals("jungla") && posSecundaria.equals("soporte")){
            pos3 = "superior";
            pos4 = "central";
            pos5 = "inferior";
        }else if (posPrincipal.equals("jungla") && posSecundaria.equals("inferior")){
            pos3 = "superior";
            pos4 = "central";
            pos5 = "soporte";
        }else if (posPrincipal.equals("central") && posSecundaria.equals("superior")){
            pos3 = "jungla";
            pos4 = "soporte";
            pos5 = "inferior";
        }else if (posPrincipal.equals("central") && posSecundaria.equals("jungla")){
            pos3 = "superior";
            pos4 = "soporte";
            pos5 = "inferior";
        }else if (posPrincipal.equals("central") && posSecundaria.equals("soporte")){
            pos3 = "superior";
            pos4 = "jungla";
            pos5 = "inferior";
        }else if (posPrincipal.equals("central") && posSecundaria.equals("inferior")){
            pos3 = "superior";
            pos4 = "jungla";
            pos5 = "soporte";
        }else if (posPrincipal.equals("soporte") && posSecundaria.equals("superior")){
            pos3 = "jungla";
            pos4 = "central";
            pos5 = "inferior";
        }else if (posPrincipal.equals("soporte") && posSecundaria.equals("jungla")){
            pos3 = "superior";
            pos4 = "central";
            pos5 = "inferior";
        }else if (posPrincipal.equals("soporte") && posSecundaria.equals("central")){
            pos3 = "superior";
            pos4 = "jungla";
            pos5 = "inferior";
        }else if (posPrincipal.equals("soporte") && posSecundaria.equals("inferior")){
            pos3 = "superior";
            pos4 = "jungla";
            pos5 = "central";
        }else if (posPrincipal.equals("inferior") && posSecundaria.equals("superior")){
            pos3 = "jungla";
            pos4 = "central";
            pos5 = "soporte";
        }else if (posPrincipal.equals("inferior") && posSecundaria.equals("jungla")){
            pos3 = "superior";
            pos4 = "central";
            pos5 = "soporte";
        }else if (posPrincipal.equals("inferior") && posSecundaria.equals("central")){
            pos3 = "superior";
            pos4 = "jungla";
            pos5 = "soporte";
        }else if (posPrincipal.equals("inferior") && posSecundaria.equals("soporte")){
            pos3 = "superior";
            pos4 = "jungla";
            pos5 = "central";
        }

        //Se crea un vector con las posiciones restantes del invocador.
        String[] vecPos = new String[3];

        vecPos[0] = pos3;
        vecPos[1] = pos4;
        vecPos[2] = pos5;

        return vecPos;
    }

    public String obtenerNombreInvocador(String nombreProvisional){
        for (int i = 0; i < this.listaCampeon.getCantCampeones(); i++) {
            if (this.listaCampeon.getVecCampeones()[i].getNombreCampeon().equals(nombreProvisional)){
                return this.listaCampeon.getVecCampeones()[i].getNombreCampeon();
            }
        }
        return "";
    }


    //endregion
}
