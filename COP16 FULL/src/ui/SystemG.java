package ui;

import java.util.Scanner;
import model.Cop16;

public class SystemG {

    private Scanner scanner;
    // private String[] lugaresRegistrados;
    // private String[] departamentosLugares;
    // private int[] areaLugaresRegistrados;
    // private int contadorLugar;

    private Cop16 controladora = new Cop16();

    public static void main(String[] args) {
        SystemG executable = new SystemG();
        executable.faseOneCop();
        executable.faseTwoCop();

    }

    public SystemG() {

        scanner = new Scanner(System.in);
        // lugaresRegistrados = new String[30];
        // departamentosLugares = new String[30];
        // areaLugaresRegistrados = new int[30];
        // contadorLugar = 0;

        controladora = new Cop16();

    }

    public void faseOneCop() {
        // Scanner scanner = new Scanner(System.in);
        // SystemG executable = new SystemG();
        System.out.println(
                "--Bienvenido voluntario a la aplicación de Interacción de Rutas Ecológicas COP 16 Cali - Colombia. \n¿Cuál es tu nombre?--");
        String nombre = scanner.nextLine();

        // Registrar cedula del voluntario
        System.out.println("Por favor, digita tu cédula.");
        String cedula = scanner.nextLine();
        // scanner.nextLine();

        boolean resultado = controladora.guardar_voluntario(cedula, nombre);
        if (resultado == true) {
            System.out.println("Usuario registrado exitosamente");
        } else {
            System.out.println("¡Error! Memoria llena.");

        }

        // Bienvenida y seleccion de ruta
        System.out.println("¡Bienvenido, " + nombre + "!");
        System.out.println("¿Qué ruta registrarás el día de hoy?" + "\n" + "1-Farallones \n2-Oriente \n3-Laderas");

        String selecRuta = "";
        boolean pasar = false;// boolean para frenar el while
        // while que repite el scanner cuando el usuario digita la ruta mal
        while (pasar == false) {
            selecRuta = scanner.nextLine();
            selecRuta = selecRuta.toLowerCase();

            if (selecRuta.equals("farallones")) {

                System.out.print(controladora.mensaje_de_ruta(selecRuta));
                pasar = true;// frenar while

            } else if (selecRuta.equals("oriente")) {

                System.out.println(controladora.mensaje_de_ruta(selecRuta));
                pasar = true;// frenar while

            } else if (selecRuta.equals("laderas")) {

                System.out.println(controladora.mensaje_de_ruta(selecRuta));
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

        if (controladora.calcular_clima(tempGradosC, porHumedad)) {
            System.out.println("¡Hace un buen día para caminar por Cali!");

        } else {
            System.out.println("No es el mejor dia para caminar por cali");

        }

        int totalPersonas = numParticipantes + numGuias;// calcular total de personas (guias y participantes)

        // Imprime mensaje con el total de personas
        System.out.println("Al ser un total de " + totalPersonas
                + " personas que harán parte de la actividad, se necesitarán un total de:");

        // Imprime mensaje con el numero de buses
        System.out.println((controladora.calcular_buses(totalPersonas))
                + " buses para llevarla a cabo de manera exitosa. ¡Nos vemos en la COP16!");

        if (controladora.guardar_ruta(selecRuta, tempGradosC, porHumedad, numParticipantes, numGuias,
                controladora.calcular_buses(totalPersonas))) {
            System.out.println("Ruta registrada exitosamente");
        } else {
            System.out.println("¡Error! Memoria llena.");

        }

    }

    //

    public void faseTwoCop() {
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
                    String nombreLugar = scanner.nextLine();// guarda en el arreglo

                    System.out.print("Ingresa el departamento en el cual está el lugar\n>");
                    String departamentoLugar = scanner.nextLine();

                    System.out.print("Ingresa la cantidad de kilómetros cuadrados que abarca el lugar\n>");
                    int areaLugar = scanner.nextInt();

                    scanner.nextLine();

                    System.out.println("interte un URL de la foto del lugar");
                    String fotoLugar = scanner.nextLine();

                    System.out.println("Digite los recursos economicos del lugar");
                    double recursosLugar = scanner.nextDouble();

                    boolean consulta = controladora.guardar_lugar(fotoLugar, recursosLugar, nombreLugar,
                            departamentoLugar, areaLugar);
                    if (consulta) {
                        System.out.println("Lugar ingresado con éxito.");

                    } else {
                        System.out.println("¡Error! Memoria llena.");
                    }

                    break;
                // Imprime la lista de las areas con lugar de menor a mayor
                case 2:

                    System.out.println(
                            "Los lugares ordenados de menor a mayor con respecto al área hasta el momento son:");
                    controladora.ordenar_menor_mayor();
                    System.out.println(controladora.construir_lista_lugares());

                    break;
                // Imprime el departamento con mas lugares registrados
                case 3:

                    System.out.println("El departamento con más lugares biodiversos registrados es:");

                    System.out.println(controladora.dep_mas_registrado());

                    break;

                default:
                    System.out.println("Valor fuera de las opciones, digite uno válido!");
                    break;
            }
        }

    }

}