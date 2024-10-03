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

                System.out.println(controladora.mensaje_de_ruta(selecRuta));
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

        boolean registerRout = controladora.addRoutToVoluntary(nombre, selecRuta, tempGradosC, porHumedad,
                numParticipantes, numGuias);

        int totalPersonas = numParticipantes + numGuias;// calcular total de personas (guias y participantes)

        // Imprime mensaje con el total de personas
        System.out.println("Al ser un total de " + totalPersonas
                + " personas que harán parte de la actividad, se necesitarán un total de:");

        // Imprime mensaje con el numero de buses
        System.out.println(controladora.calcular_num_buses_passRoute(nombre, selecRuta, tempGradosC, porHumedad,
                numGuias, numGuias, numGuias));
        if (controladora.calcular_clima_passRoute(nombre, selecRuta, tempGradosC, porHumedad, numParticipantes,
                numGuias)) {
            System.out.println("¡Hace un buen día para caminar por Cali!");

        } else {
            System.out.println("No es el mejor dia para caminar por cali");

        }

        if (registerRout) {
            System.out.println("Ruta registrada exitosamente");
        } else {
            System.out.println("¡Error! Memoria llena.");

        }

    }

    // FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF

    public void faseTwoCop() {
        System.out.println(
                "Bienvenido voluntario a la aplicación de Gestión de Lugares Biodiversos COP 16 Cali - Colombia.");
        System.out.println("Te presentamos las siguientes opciones, ingresa:");
        // while para que el usuario pueda repetir opciones
        while (true) {
            System.out.println("1. Para registrar un lugar con diversidad biológica.\n" +
                    "2. Para consultar los lugares ordenados de menor a mayor con respecto al área.\n" +
                    "3. Para consultar el departamento que tiene más lugares con diversidad biológica registrados hasta el momento.\n"
                    + "4. Agregar especie a un lugar\n" +
                    "5. Agregar comunidad a un lugar\n" +
                    "6. Agregar representante a una comunidad\n" +
                    "7. Modificar un atributo de una especie\n" +
                    "0. Para salir del programa.");

            System.out.print(">");
            int opcion = scanner.nextInt();
            // Condicion para romper el while o para salir del ciclo
            if (opcion == 0) {
                break;
            }
            scanner.nextLine();
            // switch con las opciones del programa
            switch (opcion) {
                // Tomar o registar el lugar, su departamento y su area
                case 1:
                    registerPlace();
                    break;
                // Imprime la lista de las areas con lugar de menor a mayor
                case 2:
                    ordenar_menor_mayor();
                    break;
                // Imprime el departamento con mas lugares registrados
                case 3:
                    dep_mas_registrado();
                    break;

                case 4:
                    registerSpecie();
                    break;

                case 5:
                    registerCommunity();
                    break;
                case 6:
                    registerRepresentative();
                    break;
                case 7:
                    updateSpecie();
                    break;
                case 8:
                    lugarConMasEspecies();
                    break;

                default:
                    System.out.println("Valor fuera de las opciones, digite uno válido!");
                    break;
            }
        }

    }

    public void ordenar_menor_mayor() {
        System.out.println(
                "Los lugares ordenados de menor a mayor con respecto al área hasta el momento son:");
        controladora.ordenar_menor_mayor();

        System.out.println(controladora.construir_lista_lugares());
    }

    public void dep_mas_registrado() {
        System.out.println("El departamento con más lugares biodiversos registrados es:");

        System.out.println(">" + controladora.dep_mas_registrado());
    }

    public void registerSpecie() {
        System.out.println(controladora.construir_lista_lugares());
        System.out.println("Digite el lugar donde se encuentra la especie");
        String nombreLugar = scanner.nextLine();

        System.out.println("Digite el nombre de la especie");
        String nombreEspecie = scanner.nextLine();

        System.out.println("Digite la foto de la especie");
        String URLSpecie = scanner.nextLine();

        System.out.println("Digite la cantidad de la especie");
        int cantidadEspecie = scanner.nextInt();

        boolean consulta = controladora.addSpecieToPlace(nombreLugar, nombreEspecie, URLSpecie, cantidadEspecie);
        if (consulta) {
            System.out.println("La especeie se agrego con ecito al lugrar [" + nombreLugar + "]");

        } else {
            System.out.println("¡Error!");

        }

    }

    public void registerCommunity() {
        System.out.println(controladora.construir_lista_lugares());
        System.out.println("Digite el lugar donde se encuentra la comunidad");
        String nombreLugar = scanner.nextLine();

        System.out.println("Digite el nombre de la comunidad");
        String nombreComunidad = scanner.nextLine();

        System.out.println("Digite la cantidad de habitantes de la comunidad");
        int cantidadHabitantes = scanner.nextInt();

        boolean consulta = controladora.addCommunityToPlace(nombreLugar, nombreComunidad, cantidadHabitantes);
        if (consulta) {
            System.out.println("La comunidad se agrego con exito al lugrar [" + nombreLugar + "]");

        } else {
            System.out.println("¡Error! Memoria llena.");

        }

    }

    public void registerPlace() {
        System.out.print("Ingresa el nombre del lugar biodiverso\n>");
        String nombreLugar = scanner.nextLine();// guarda en el arreglo

        System.out.print("\nIngresa el departamento en el cual está el lugar\n>");
        String departamentoLugar = scanner.nextLine();

        System.out.print("\nIngresa la cantidad de kilómetros cuadrados que abarca el lugar\n>");
        int areaLugar = scanner.nextInt();

        scanner.nextLine();

        System.out.println("inserte un URL de la foto del lugar");
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

    }

    public void registerRepresentative() {
        System.out.println(controladora.construir_lista_lugares());
        System.out.println("Digite el lugar donde se encuentra la comunidad");
        String nombreLugar = scanner.nextLine();

        System.out.println("Digite el nombre del representante");
        String name = scanner.nextLine();

        System.out.println("Digite el numero de telefono del representante");
        String phoneNumber = scanner.nextLine();

        boolean consulta = controladora.addRepresentativeToCommunity(nombreLugar, name, phoneNumber);

        if (consulta) {
            System.out.println("El representante se agrego con exito al lugrar [" + nombreLugar + "]");

        } else {
            System.out.println("¡Error! Memoria llena.");

        }

    }

    public void updateSpecie() {

        System.out.println("Digite el lugar donde habita la especie a modificar");
        String placeSpecieUpdate = scanner.nextLine();

        System.out.println("Digite el nombre de la especie a modificar");
        String nameSpecieUpdate = scanner.nextLine();

        System.out.println("Que atributo desea modificar de la especie \n1. Nombre \n2. Cantidad \n3. Foto");
        int opcion = scanner.nextInt();

        String mod = "";

        switch (opcion) {
            case 1:
                scanner.nextLine();
                System.out.println("Digite el nuevo nombre de la especie");
                mod = scanner.nextLine();
                break;

            case 2:
                scanner.nextLine();
                System.out.println("Digite la nueva cantidad de la especie");
                mod = scanner.nextLine();
                break;

            case 3:
                scanner.nextLine();
                System.out.println("Digite la nueva URL de la foto de la especie");
                mod = scanner.nextLine();
                break;

            default:
                System.out.println("opcion invalida!");
                break;
        }
        if (controladora.trueModifySpecie(placeSpecieUpdate, nameSpecieUpdate, mod, opcion)) {
            System.out.println("la especie se modifico con exito");
        } else {
            System.out.println("error al modificar la especie");
        }

    }

    public void lugarConMasEspecies() {
        System.out.println(" el que mas tiene es " + controladora.PlaceTop());

    }

}
