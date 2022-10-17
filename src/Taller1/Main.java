package Taller1;
import ucn.*;
import java.io.IOException;

public class Main {
    //region MAIN.

    public static void main(String[] args) throws IOException {
        SistemaLeagueOfLegends sistema = new SistemaLeagueOfLegendsImpl();

        cargarArchivoInvocadores(sistema);
        cargarArchivoCampeones(sistema);
        menuPrincipal(sistema);
    }

    //endregion







    //region LECTURA DE ARCHIVOS.

    /**
     * Subprograma para cargar y leer el archivo para guardarlo en la ListaInvocador.
     * @param sistema Corresponde al llamado del sistema para utilizar los metodos de la clase SistemaLeagueOfLegendsImpl.
     * @throws IOException Detiene la carga/escritura  del archivo si ocurre algun error.
     */
    public static void cargarArchivoInvocadores(SistemaLeagueOfLegends sistema) throws IOException{
        ArchivoEntrada archivoEntrada = new ArchivoEntrada("invocadores.txt");
        while(!archivoEntrada.isEndFile()){

            int miric;

            Registro registroEntrada = archivoEntrada.getRegistro();

            String nombreInv = registroEntrada.getString();
            String contrasenia = registroEntrada.getString();

            try{
                miric = Integer.parseInt(registroEntrada.getInt());

                int cantPaginas = miric;


            }catch(Exception e){

                String genero2 = registroEntrada.getString();
                int cantPaginas = registroEntrada.getInt();

            }


            int puntosLiga = registroEntrada.getInt();
            String posPrincipal = registroEntrada.getString();
            String posSecundaria = registroEntrada.getString();
            int cantCampeonesJugador = registroEntrada.getInt();

            //Llamado al método del SistemaLeagueOfLegendsImlp para registrar auxiliar un nuevo invocador.
            sistema.registrarArregloInvocador(nombreInv, contrasenia, posPrincipal, posSecundaria,puntosLiga);

            for (int i = 0; i < cantCampeonesJugador; i++) {
                registroEntrada = archivoEntrada.getRegistro();

                String nombreCampeon = registroEntrada.getString();
                int puntosMaestria = registroEntrada.getInt();
                int cantVictorias = registroEntrada.getInt();
                int cantDerrotas = registroEntrada.getInt();

                //Llamado al método del SistemaLeagueOfLegendsImlp para asociar un campeón al invocador.
                sistema.asociarCampeonInv(nombreCampeon,puntosMaestria,cantVictorias,cantDerrotas,nombreInv);
            }
        }
        archivoEntrada.close();
    }
    /**
     * Subprograma para cargar y leer el archivo para guardarlo en la ListaCampeon.
     * @param sistema Corresponde al llamado del sistema para utilizar los metodos de la clase SistemaLeagueOfLegendsImpl.
     * @throws IOException Detiene la carga/escritura  del archivo si ocurre algun error.
     */
    public static void cargarArchivoCampeones(SistemaLeagueOfLegends sistema) throws IOException {
        ArchivoEntrada archivoEntrada = new ArchivoEntrada("campeones.txt");
        while(!archivoEntrada.isEndFile()){

            Registro registroEntrada = archivoEntrada.getRegistro();
            String nombreCampeon = registroEntrada.getString();
            String descripcionCampeon = registroEntrada.getString();
            String rolCampeon = registroEntrada.getString();
            String posCampeon = registroEntrada.getString();

            //Llamado al método del SistemaLeagueOfLegendsImlp para registrar a un nuevo campeón.
            sistema.registrarArregloCampeon(nombreCampeon, descripcionCampeon, rolCampeon, posCampeon); //Agregar Campeon lista
        }
        archivoEntrada.close();
    }

    //endregion






    //region SUBPROGRAMAS CON REQUERIMIENTOS DEL MENU.

    /**
     * Subprograma que lleva el menu principal del usuario.
     * @param sistema Corresponde al llamamiento al SistemaLeagueOfLegendsImlp.
     * @throws IOException Detiene la carga/escritura del archivo si ocurre algun error.
     */
    public static void menuPrincipal(SistemaLeagueOfLegends sistema) throws IOException {
        int opcion = 0;

        while(opcion != 3){
            StdOut.println("--------->Bienvenido a League of Legends<---------");
            StdOut.println("[1] Iniciar Sesión.");
            StdOut.println("[2] Registrar nuevo invocador.");
            StdOut.println("[3] Guardar y salir del sistema.");
            StdOut.print("Ingrese su opción: ");
            String opcionStr = StdIn.readLine();
            int opcionInt;

            while (true){
                try{
                    opcionInt = Integer.parseInt(opcionStr);
                    if (1 <= opcionInt && opcionInt <= 3){
                        break;
                    }else{
                        StdOut.println("Error, la opción ingresada no existe");
                        StdOut.print("Ingrese su opción nuevamente: ");
                        opcionStr = StdIn.readString();
                    }
                }catch(Exception e){
                    StdOut.println("Error, la opción ingresada no existe");
                    StdOut.print("Ingrese su opción nuevamente: ");
                    opcionStr = StdIn.readString();
                }
            }
            opcion = opcionInt;

            switch (opcion) {
                case 1 -> subMenuInicioSesion(sistema);
                case 2 -> subMenuRegistro(sistema);
                case 3 -> subMenuActualizarArchivo(sistema);
            }
        }
    }
    /**
     * Subprograma que lleva el submenu de inicio de sesion.
     */
    public static void subMenuInicioSesion(SistemaLeagueOfLegends sistema){

        StdOut.println("--------->Inicio de sesión en League of Legends<---------");
        StdOut.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = StdIn.readLine();
        StdOut.print("Ingrese su contraseña: ");
        String contraseniaUsuario = StdIn.readLine();

        if (sistema.iniciarSesion(nombreUsuario, contraseniaUsuario)){
            //Si el sistema acepta el inicio de sesion del impl, entonces entra a los menú de abajo.

            StdOut.println("\n¡Inicio de sesión exitoso!\n");

            int opcion = 0;
            while (opcion != 8){
                StdOut.println("--------->League of Legends<---------");
                StdOut.println("[1] Buscar Partida.");
                StdOut.println("[2] Agregar Campeón.");
                StdOut.println("[3] Ver Perfil.");
                StdOut.println("[4] Consultar Campeón.");
                StdOut.println("[5] Mejores Invocadores.");
                StdOut.println("[6] Mejores Campeones.");
                StdOut.println("[7] Mostrar todos los Campeones.");
                StdOut.println("[8] Volver al Menú Principal.");
                StdOut.print("Ingrese su opción: ");
                String opcionStr = StdIn.readLine();
                int opcionInt;

                while (true){
                    try{
                        opcionInt = Integer.parseInt(opcionStr);
                        if (1 <= opcionInt && opcionInt <= 8){
                            break;
                        }else{
                            StdOut.println("Error, la opción ingresada no existe");
                            StdOut.print("Ingrese su opción nuevamente: ");
                            opcionStr = StdIn.readString();
                        }
                    }catch(Exception e){
                        StdOut.println("Error, la opción ingresada no existe");
                        StdOut.print("Ingrese su opción nuevamente: ");
                        opcionStr = StdIn.readString();
                    }
                }
                opcion = opcionInt;

                switch (opcion) {
                    case 1 -> subMenuBuscarPartida(sistema);
                    case 2 -> subMenuAgregarCampeon(sistema);
                    case 3 -> subMenuVerPerfil(sistema);
                    case 4 -> subMenuConsultarCampeon(sistema);
                    case 5 -> subMenuMejoresInvocadores(sistema);
                    case 6 -> subMenuMejoresCampeones(sistema);
                    case 7 -> subMenuDesplegarTodosLosCampeones(sistema);
                    case 8 -> sistema.volverMenuPrincipal();
                }

            }
        }else{
            StdOut.println("Nombre de usuario o contraseña incorrecto.\n");
        }
    }
    /**
     * Subprograma que lleva el submenu de registro de nuevos invocadores.
     */
    public static void subMenuRegistro(SistemaLeagueOfLegends sistema){
        StdOut.println("--------->Registrate en League of Legends<---------");

        //obtener nombre:
        StdOut.print("Ingrese un nombre de usuario: ");
        String nombreInv = StdIn.readLine();
        while (!sistema.verificarNombreUsuario(nombreInv)){
            StdOut.print("Nombre de usuario ya registrado.\nIngrese un nombre de usuario: ");
            nombreInv = StdIn.readLine();
        }

        //obtener contraseña:
        StdOut.print("Ingrese una contraseña (Minímo 6 carácteres): ");
        String contrasenia = StdIn.readLine();
        while (contrasenia.length() < 6){
            StdOut.print("La contraseña ingresada es inválida.\nIngrese la contraseña nuevamente: ");
            contrasenia = StdIn.readLine();
        }

        //obtener posicion principal:
        StdOut.print("Las posiciones dentro del juego son: Superior, Jungla, Central, Soporte e Inferior.\nIngrese una posición principal: ");
        String posPrincipal = StdIn.readLine().toLowerCase();
        while (!posPrincipal.equals("superior") && !posPrincipal.equals("jungla") && !posPrincipal.equals("central") && !posPrincipal.equals("soporte") && !posPrincipal.equals("inferior")){
            StdOut.print("La opción ingresada es inválida.\nPor favor ingrese la posición principal: ");
            posPrincipal = StdIn.readLine().toLowerCase();
        }

        //obtener posicion secundaria:
        StdOut.print("La posición secundaria debe ser distinta a la principal.\nIngrese una posición secundaria: ");
        String posSecundaria = StdIn.readLine().toLowerCase();
        while (true){
            if (posSecundaria.equals("superior") || posSecundaria.equals("jungla") || posSecundaria.equals("central") || posSecundaria.equals("soporte") || posSecundaria.equals("inferior")){
                if (!posSecundaria.equals(posPrincipal)){
                    break;
                }
            }
            StdOut.print("La opción ingresada es inválida\nLa posición secundaria debe ser distinta a la principal.\nPor favor ingrese la posición secundaria: ");
            posSecundaria = StdIn.readLine().toLowerCase();
        }

        sistema.registrarArregloInvocador(nombreInv, contrasenia, posPrincipal, posSecundaria, 0);

        StdOut.println("\n¡Registro de nuevo usuario exitoso!\n");
    }
    /**
     * Subprograma que lleva el submenu de agregar campeones a la lista de campeones del invocador.
     * @param sistema Corresponde al llamado del sistema para utilizar los metodos de la clase SistemaLeagueOfLegendsImpl.
     */
    public static void subMenuAgregarCampeon(SistemaLeagueOfLegends sistema){
        StdOut.println("--------->Añadir un campeón a tu lista de campeones<---------");

        StdOut.print("Ingrese el nombre del campeón: ");
        String campeonSolicitado = StdIn.readLine();

        sistema.verificarNombreCampeon(campeonSolicitado);
        if (sistema.buscarCampeon(campeonSolicitado)){
            if (sistema.verificarNombreCampeon(campeonSolicitado)){
                sistema.asociarCampeonInv(campeonSolicitado,0,0,0, sistema.obtenerNombreInvLog());
                StdOut.println("\n¡Registro de nuevo campeón exitoso!.\nVolviendo al menú anterior...\n");
            }else{
                StdOut.println("\nCampeón ya registrado.\nVolviendo al menú anterior...\n");
            }
        }else{
            StdOut.println("\nCampeón no encontrado.\nVolviendo al menú anterior...\n");
        }
    }
    /**
     * Subprograma que permite al usuario buscar y juegar una partida con distintos resultados posibles.
     * @param sistema Corresponde al llamado del sistema para utilizar los metodos de la clase SistemaLeagueOfLegendsImpl.
     */
    public static void subMenuBuscarPartida(SistemaLeagueOfLegends sistema){

        StdOut.println(sistema.buscarPartida(sistema.obtenerNombreInvLog()));

    }
    /**
     * Submenu que permite al usuario ver su nombre de usuario, puntos de liga, porcentaje de victorias, mejor campeón y puntos de maestría.
     * @param sistema Corresponde al llamamiento al SistemaLeagueOfLegendsImlp.
     */
    public static void subMenuVerPerfil(SistemaLeagueOfLegends sistema){
        StdOut.println("--------->Perfil de "+sistema.obtenerNombreInvLog()+"<---------");

        String[] verPerfilMain = sistema.verPerfil(sistema.obtenerNombreInvLog());

        if (verPerfilMain[4] == null){
            StdOut.println("Invocador: " + verPerfilMain[0] + "     " + "PL: " + verPerfilMain[1] + "     " +
                    "Porcentaje de Victorias: " + verPerfilMain[2] + "%\n" + "No hay campeones para mostrar.");
        }else{
            StdOut.println("Invocador: " + verPerfilMain[0] + "     " + "PL: " + verPerfilMain[1] + "     " +
                    "Porcentaje de Victorias: " + verPerfilMain[2] + "%\n" + "Mejor Campeón: " + verPerfilMain[3] +
                    "      " + "Puntos de Maestría: " + verPerfilMain[4]);
        }
    }
    /**
     * Submenu que permite al usuario conocer el nombre, descripción, rol y porcentaje de victorias de un campeón.
     * @param sistema Corresponde al llamamiento al SistemaLeagueOfLegendsImlp.
     */
    public static void subMenuConsultarCampeon(SistemaLeagueOfLegends sistema){
        StdOut.println("--------->Menú Consulta Campeón<---------");
        StdOut.print("Ingrese el nombre del campeón a consultar: ");
        String campeonConsulta = StdIn.readLine();

        String[] campeonConsultado = sistema.consultarCampeon(campeonConsulta);

        if (campeonConsultado[3].equals("")){
            StdOut.println("\nCampeón no existe.\n");
        }else{
            StdOut.println("\n-Nombre del Campeón: "+campeonConsultado[0]);
            StdOut.println("-Descripción: "+campeonConsultado[1]);
            StdOut.println("-Rol del Campeón: "+campeonConsultado[2]);
            StdOut.println("-Porcentaje de Victorias: "+campeonConsultado[4]+"%.\n");
        }

    }
    /**
     * Submenu que recopila los mejores invocadores del sistema.
     * @param sistema Corresponde al llamamiento al SistemaLeagueOfLegendsImlp.
     */
    public static void subMenuMejoresInvocadores(SistemaLeagueOfLegends sistema){

        String[] mejoresInv = sistema.mejoresInvocadores();
        StdOut.println("--------->Mejores Invocadores de League of Legends<---------");

        if (mejoresInv[1].equals("0") && mejoresInv[3].equals("0")) {
            StdOut.println("No hay invocadores con puntos de liga mayores o iguales a 1.\n\n");
        }else if (mejoresInv[3].equals("0")) {
            StdOut.print("Invocador:                  Puntos de Liga: \n" +
                    "" + mejoresInv[0] + "                       " + mejoresInv[1] + "\n\n");
        }else{
            StdOut.print("Invocador:                  Puntos de Liga: \n" +
                    "" + mejoresInv[0] +"                       "+ mejoresInv[1]+"\n" +
                    "" + mejoresInv[2] +"                       "+ mejoresInv[3]+"\n\n");
        }
    }

    public static void subMenuMejoresCampeones(SistemaLeagueOfLegends sistema){


    }
    /**
     * Submenu que despliega todos los campeones disponibles en el sistema.
     * @param sistema Corresponde al llamamiento al SistemaLeagueOfLegendsImlp.
     */
    public static void subMenuDesplegarTodosLosCampeones(SistemaLeagueOfLegends sistema){

        String[] tiradores = sistema.desplegarTiradores();

        StdOut.println("\nTiradores:                         Posición:\n");


        for (String tiradore : tiradores) {
            if (tiradore != null) {
                StdOut.println(tiradore);
            }
        }
        String[] luchadores = sistema.desplegarLuchadores();

        StdOut.println("\nLuchadores:                         Posición:\n");

        for (String luchadore : luchadores) {
            if (luchadore != null) {
                StdOut.println(luchadore);
            }
        }
        String[] magos = sistema.desplegarMagos();

        StdOut.println("\nMagos:                         Posición:\n");

        for (String mago : magos) {
            if (mago != null) {
                StdOut.println(mago);
            }
        }
        String[] asesinos = sistema.desplegarAsesinos();

        StdOut.println("\nAsesinos:                         Posición:\n");

        for (String asesino : asesinos) {
            if (asesino != null) {
                StdOut.println(asesino);
            }
        }
        String[] tanques = sistema.desplegarTanques();

        StdOut.println("\nTanques:                         Posición:\n");

        for (String tanque : tanques) {
            if (tanque != null) {
                StdOut.println(tanque);
            }
        }
    }
    /**
     * Método que sobreescribe el archivo invocadores.txt y lo guarda.
     * @param sistema Corresponde al llamamiento al SistemaLeagueOfLegendsImlp.
     * @throws IOException Detiene la carga/escritura  del archivo si ocurre algun error.
     */
    public static void subMenuActualizarArchivo(SistemaLeagueOfLegends sistema) throws IOException{

        sistema.guardarInvocador();

        StdOut.println("Guardando datos y apagando el sistema...\nAdiós Invocador.");

    }

    //endregion
}