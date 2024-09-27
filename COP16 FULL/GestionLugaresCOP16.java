
import java.util.Scanner;

public class GestionLugaresCOP16 {
    // Generar las variables globales
    static Scanner scanner;
    static String[] lugaresRegistrados;
    static String[] departamentosLugares;
    static int[] areaLugaresRegistrados;
    static int contadorLugar;

    public static void main(String[] args) {
        // Iniciar las variables globales
        inicializarGlobales();
        System.out.println(
                "--Bienvenido voluntario a la aplicación de Interacción de Rutas Ecológicas COP 16 Cali - Colombia. \n¿Cuál es tu nombre?--");
        String nombre = scanner.nextLine();

        // Registrar cedula del voluntario
        System.out.println("Por favor, digita tu cédula.");
        int cedula = scanner.nextInt();
        scanner.nextLine();

        // Bienvenida y seleccion de ruta
        System.out.println("¡Bienvenido, " + nombre + "!");
        System.out.println("¿Qué ruta registrarás el día de hoy?" + "\n" + "1-Farallones \n2-Oriente \n3-Laderas");

        boolean pasar = false;// boolean para frenar el while
        // while que repite el scanner cuando el usuario digita la ruta mal
        while (pasar == false) {
            String selecRuta = scanner.nextLine();
            selecRuta = selecRuta.toLowerCase();

            if (selecRuta.equals("farallones")) {

                mensaje_de_ruta(selecRuta);
                pasar = true;// frenar while

            } else if (selecRuta.equals("oriente")) {

                mensaje_de_ruta(selecRuta);
                pasar = true;// frenar while

            } else if (selecRuta.equals("laderas")) {

                mensaje_de_ruta(selecRuta);
                pasar = true;// frenar while

            } else if (selecRuta.length() == 0) { // posibles errores cometidos por el usuario
                System.out.println("--Error, espacio en blanco\nDigite la ruta nuevamente!");
            } else {
                System.out.println("--Error, la ruta NO existe\nDigite la ruta nuevamente!");
            }

        }

        // Registro del numero de participantes
        System.out.println("¿Cuántos participantes acudirán a la caminata el día de hoy?");
        int numParticipantes = scanner.nextInt();
        // Registro del numero de guias
        System.out.println("¿Cuántos guías acudirán a la caminata el día de hoy?");
        int numGuias = scanner.nextInt();
        // Registro de temperatura
        System.out.println("Ingresar la temperatura en grados centígrados °C");
        double tempGradosC = scanner.nextDouble();
        // Registro de porcentaje de humedad
        System.out.println("Ingresar el porcentaje de humedad relativa");
        double porHumedad = scanner.nextDouble();

        calcular_clima(tempGradosC, porHumedad);

        int totalPersonas = numParticipantes + numGuias;// calcular total de personas (guias y participantes)

        // Imprime mensaje con el total de personas
        System.out.println("Al ser un total de " + totalPersonas
                + " personas que harán parte de la actividad, se necesitarán un total de:");

        // Imprime mensaje con el numero de buses
        System.out.println((calcular_buses(totalPersonas))
                + " buses para llevarla a cabo de manera exitosa. ¡Nos vemos en la COP16!");

        System.out.println(
                "Bienvenido voluntario a la aplicación de Gestión de Lugares Biodiversos COP 16 Cali - Colombia.");
        System.out.println("Te presentamos las siguientes opciones, ingresa:");
        // while para que el usuario pueda repetir opciones
        while (true) {
            System.out.println("1. Para registrar un lugar con diversidad biológica.\n" +
                    "2. Para consultar los lugares ordenados de menor a mayor con respecto al área.\n" +
                    "3. Para consultar el departamento que tiene más lugares con diversidad biológica registrados hasta el momento.\n"
                    +
                    "4. Para salir del programa.");

            System.out.print(">");
            int opcion = scanner.nextInt();
            // Condicion para romper el while o para salir del ciclo
            if (opcion == 4) {
                break;
            }
            scanner.nextLine();
            // switch con las opciones del programa
            switch (opcion) {
                // Tomar o registar el lugar, su departamento y su area
                case 1:
                    System.out.print("Ingresa el nombre del lugar biodiverso\n>");
                    lugaresRegistrados[contadorLugar] = scanner.nextLine();// guarda en el arreglo

                    System.out.print("Ingresa el departamento en el cual está el lugar\n>");
                    departamentosLugares[contadorLugar] = scanner.nextLine();

                    System.out.print("Ingresa la cantidad de kilómetros cuadrados que abarca el lugar\n>");
                    areaLugaresRegistrados[contadorLugar] = scanner.nextInt();

                    System.out.println("Lugar ingresado con éxito.");
                    contadorLugar++;// variable para llevar la cuenta de lugares registrados
                    break;
                // Imprime la lista de las areas con lugar de menor a mayor
                case 2:
                    if (contadorLugar == 0) {
                        System.out.println("No se han registrado lugares aún");
                    } else {
                        System.out.println(
                                "Los lugares ordenados de menor a mayor con respecto al área hasta el momento son:");
                        int areasOrdenadas[] = lista_lugar_area(contadorLugar, areaLugaresRegistrados,
                                lugaresRegistrados, departamentosLugares);
                        imprimir_lista_lugar_area(lugaresRegistrados, areasOrdenadas);
                    }
                    break;
                // Imprime el departamento con mas lugares registrados
                case 3:
                    if (contadorLugar == 0) {
                        System.out.println("No se han registrado lugares aún");
                    } else {
                        System.out.println("El departamento con más lugares biodiversos registrados es:");

                        String depPopular = dep_mas_registrado(contadorLugar, departamentosLugares);
                        int repDepPopular = num_repeticiones_dep(depPopular, contadorLugar, departamentosLugares);
                        System.out.println(depPopular + " con " + repDepPopular + " lugares");
                    }
                    break;

                default:
                    System.out.println("Valor fuera de las opciones, digite uno válido!");
                    break;
            }
        }
    }

    /**
     * Descripción: Este método calcula el número necesario de buses para
     * transportar a un grupo de personas,
     * asumiendo que cada bus tiene una capacidad de 25 personas. Si el número total
     * de personas no es
     * un múltiplo exacto de 25, se requiere un bus adicional para acomodar a las
     * personas restantes.
     *
     * @param int totalPersonas El número total de personas que necesitan ser
     *            transportadas.
     * 
     * @return El número total de buses necesarios para transportar a todas las
     *         personas.
     */
    public static int calcular_buses(int totalPersonas) {
        int totalBuses;
        if (totalPersonas % 25 == 0) {

            totalBuses = totalPersonas / 25;

        } else {

            totalBuses = 1 + (totalPersonas / 25);
        }
        return totalBuses;

    }

    /**
     * Descripción: Este método evalúa la temperatura y la humedad para determinar
     * si es un buen día
     * para caminar en Cali. Si la temperatura está entre 20°C y 25°C y la humedad
     * entre 40% y 60%,
     * se considera un buen día para caminar. De lo contrario, no es el mejor día.
     *
     * @param double tempGradosC La temperatura en grados Celsius.
     * @param double porHumedad El porcentaje de humedad relativa.
     * 
     * @return No retorna ningún valor (void). Imprime en consola un mensaje que
     *         indica si es un buen día
     *         para caminar en Cali o no.
     */
    public static void calcular_clima(double tempGradosC, double porHumedad) {

        if ((tempGradosC >= 20 && tempGradosC <= 25) && (porHumedad <= 60 && porHumedad >= 40)) {

            System.out.println("¡Hace un buen día para caminar por Cali!");

        } else {

            System.out.println("No es el mejor dia para caminar por cali");

        }

    }

    /**
     * Descripción: Este método evalúa la ruta ingresada por el usuario y retorna un
     * mensaje
     * que describe el punto de encuentro y el horario de la ruta seleccionada.
     *
     * @param String ruta Una cadena de texto que representa el nombre de la ruta
     *               seleccionada por el usuario.
     *               Puede ser "farallones", "oriente", o "laderas".
     * 
     * @return Imprime en consola un mensaje con la información
     *         de la ruta seleccionada.
     */
    public static void mensaje_de_ruta(String ruta) {
        // rutas
        String farallones, ladera, oriente;
        farallones = "La Ruta de los Farallones tiene como punto de encuentro Calle 16 - Universidad del Valle iniciando a las 6:40 am, y termina a las 4:00 pm.";
        ladera = "La Ruta de las Laderas tiene como punto de encuentro Calle 16 - Universidad del Valle iniciando a las 6:40 am, y termina a las 4:00 pm.";
        oriente = "La Ruta de el Oriente tiene como punto de encuentro Calle 16 - Universidad del Valle iniciando a las 6:40 am, y termina a las 4:00 pm.";
        // que ruta se escoge

        switch (ruta) {
            case "farallones":
                System.out.println("¡Excelente! " + farallones);
                break;
            case "oriente":
                System.out.println("¡Excelente! " + oriente);
                break;
            case "laderas":
                System.out.println("¡Excelente! " + ladera);
                break;
        }

    }

    /**
     * Descripción: Inicializa las variables globales utilizadas en el programa.
     * pos: El arreglo "lugaresRegistrados" queda inicializado.
     * pos: El arreglo "departamentosLugares" queda inicializado.
     * pos: El arreglo "areaLugaresRegistrados" queda inicializado.
     * pos: El contador "contadorLugar" queda inicializado en 0.
     * pos: El Scanner "scanner" queda inicializado.
     */
    public static void inicializarGlobales() {
        scanner = new Scanner(System.in);
        lugaresRegistrados = new String[30];
        departamentosLugares = new String[30];
        areaLugaresRegistrados = new int[30];
        contadorLugar = 0;

    }

    /**
     * Descripción: Imprime la lista de lugares y sus áreas correspondientes.
     * pre: El arreglo "lugar" no puede ser nulo y debe estar inicializado.
     * pre: El arreglo "area" no puede ser nulo y debe estar inicializado.
     * 
     * @param lugar String[] El arreglo que contiene los nombres de los lugares
     *              registrados.
     * @param area  int[] El arreglo que contiene las áreas de los lugares
     *              registrados en kilómetros cuadrados.
     */
    public static void imprimir_lista_lugar_area(String[] lugar, int[] area) {
        for (int i = 0; i < contadorLugar; i++) {
            System.out.println(">" + lugar[i] + "-" + area[i]);
        }
    }

    /**
     * Descripción: Determina el departamento con más lugares biodiversos
     * registrados.
     * pre: El arreglo "departamentosLugares" no puede ser nulo y debe estar
     * inicializado.
     * 
     * @param contadorLugar        int Número total de lugares registrados.
     * @param departamentosLugares String[] El arreglo que contiene los nombres de
     *                             los departamentos asociados a los lugares
     *                             registrados.
     * @return maxDep String es el departamento que mas se repitio
     */
    public static String dep_mas_registrado(int contadorLugar, String[] departamentosLugares) {
        int contDep = 0, contActual = 0;// para llevar el numero de repeticiones por departamento
        String maxDep = "", actualDep = ""; // para capturar el mas repetido

        // Contar lugares por departamento
        for (int i = 0; i < contadorLugar; i++) {
            contActual = 0;
            actualDep = departamentosLugares[i];
            for (int j = 0; j < contadorLugar; j++) {
                if (departamentosLugares[j].equals(actualDep)) {
                    contActual++;
                }
            }
            if (contActual > contDep) {
                contDep = contActual;
                maxDep = actualDep;
            }
        }

        return maxDep;
    }

    /**
     * Descripción: Determina el numero de repeticiones del departamento mas
     * registrado
     * pre: El arreglo "departamentosLugares" no puede ser nulo y debe estar
     * inicializado.
     * 
     * @param departamento         String Es el departamento que mas se repitio,
     *                             viene del metodo dep_mas_registrado()
     * @param contadorLugar        int Número total de lugares registrados.
     * @param departamentosLugares String[] El arreglo que contiene los nombres de
     *                             los departamentos asociados a los lugares
     *                             registrados.
     * @return contActual int es el numero de veces en el que se repitio el
     *         departamento del metodo dep_mas_registrado()
     */
    public static int num_repeticiones_dep(String departamento, int contadorLugar, String[] departamentosLugares) {
        int contActual = 0; // para capturar el numero de veces que se repite el departamento
        for (int i = 0; i < contadorLugar; i++) {
            if (departamentosLugares[i].equals(departamento)) {
                contActual++;
            }
        }
        return contActual;
    }

    /**
     * Descripción: Ordena los lugares de menor a mayor según el área y ajusta las
     * posiciones en los arreglos de áreas, lugares y departamentos.
     * pre: Los arreglos "areaLugar", "lugar" y "departamento" no pueden ser nulos y
     * deben estar inicializados.
     * 
     * @param contadorLugar int Número total de lugares registrados.
     * @param areaLugar     int[] El arreglo que contiene las áreas de los lugares
     *                      registrados en kilómetros cuadrados.
     * @param lugar         String[] El arreglo que contiene los nombres de los
     *                      lugares registrados.
     * @param departamento  String[] El arreglo que contiene los departamentos
     *                      asociados a los lugares registrados.
     * @return int[] El arreglo de áreas de los lugares ordenado de menor a mayor.
     */
    public static int[] lista_lugar_area(int contadorLugar, int[] areaLugar, String[] lugar, String[] departamento) {
        for (int i = 0; i < contadorLugar; i++) {
            int indice = i;
            for (int j = i + 1; j < contadorLugar; j++) {
                if (areaLugar[j] < areaLugar[indice]) {
                    indice = j;// guarda la posicion del area menor
                }
            }
            // Intercambiar los valores en los arreglos
            // Intercambiar en areaLugar
            int indiceArea = areaLugar[i];
            areaLugar[i] = areaLugar[indice];
            areaLugar[indice] = indiceArea;

            // Intercambiar en lugar
            String indiceLugar = lugar[i];
            lugar[i] = lugar[indice];
            lugar[indice] = indiceLugar;

            // Intercambiar en departamento
            String indiceDepartamento = departamento[i];
            departamento[i] = departamento[indice];
            departamento[indice] = indiceDepartamento;
        }

        return areaLugar;
    }

}
