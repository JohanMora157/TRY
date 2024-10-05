package ui;

import java.util.Scanner;
import model.Cop16;

public class SystemCOP16 {

    private Scanner scanner;
    private Cop16 controladora = new Cop16();

    public static void main(String[] args) {
        SystemCOP16 executable = new SystemCOP16();
        executable.faseOneCop();
        executable.faseTwoCop();

    }

    public SystemCOP16() {

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
                    "8. Consultar el lugar con más especies\n" +
                    "9. Consultar comunidades sin hospital y sin escuela\n" +
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
                case 9:
                    comunidadWProblems();
                    break;

                default:
                    System.out.println("Valor fuera de las opciones, digite uno válido!");
                    break;
            }
        }

    }

    public void ordenar_menor_mayor() {
        if (controladora.checkPlace() == true) {
            System.out.println(
                    "Los lugares ordenados de menor a mayor con respecto al área hasta el momento son:");
            controladora.ordenar_menor_mayor();

            System.out.println(controladora.construir_lista_lugares());
        } else {
            System.out.println("No hay lugares registrados aun");
        }
    }

    public void dep_mas_registrado() {
        if (controladora.checkPlace() == true) {
            System.out.println("El departamento con más lugares biodiversos registrados es:");

            System.out.println(">" + controladora.dep_mas_registrado());
        } else {
            System.out.println("No hay lugares registrados aun");
        }

    }

    public void registerSpecie() {

        if (controladora.checkPlace() == true) {
            System.out.println(controladora.construir_lista_lugares());
            String nombreLugar = "";
            while (true) {

                System.out.println("Digite el lugar donde se encuentra la especie");
                nombreLugar = scanner.nextLine();

                if (controladora.checkExistPlace(nombreLugar)) {
                    break;
                } else {
                    System.out.println("Lugar no registrado");

                }

            }
            String nombreEspecie = "";
            while (true) {
                System.out.println("Digite el nombre de la especie");
                nombreEspecie = scanner.nextLine();
                if (controladora.checkRepeatSpecie(nombreLugar, nombreEspecie)) {

                    break;
                } else {
                    System.out.println("Especie repetida");
                }

            }

            System.out.println("Digite la foto de la especie");
            String URLSpecie = scanner.nextLine();

            System.out.println("Digite la cantidad de la especie");
            int cantidadEspecie = scanner.nextInt();

            String tipoEspecie = "";
            while (true) {
                scanner.nextLine();
                System.out.println("Digite el tipo de la especie [Fauna o Flora]");
                tipoEspecie = scanner.nextLine();
                if (controladora.checkTypeSpecie(tipoEspecie)) {
                    break;
                } else {
                    System.out.println("Tipo de especie invalido");

                }

            }

            boolean consulta = controladora.addSpecieToPlace(nombreLugar, nombreEspecie, URLSpecie, tipoEspecie,
                    cantidadEspecie);
            if (consulta) {
                System.out.println("La especie se agrego con exito al lugrar [" + nombreLugar + "]");

            } else {
                System.out.println("¡Error!");

            }
        } else {
            System.out.println("No hay lugares registrados aun");

        }

    }

    public void registerCommunity() {

        if (controladora.checkPlace() == true) {
            System.out.println(controladora.construir_lista_lugares());

            String nombreLugar = "";
            while (true) {

                System.out.println("Digite el lugar donde se encuentra la comunidad");
                nombreLugar = scanner.nextLine();

                if (controladora.checkExistPlace(nombreLugar)) {
                    break;
                } else {
                    System.out.println("Lugar no registrado");

                }

            }

            System.out.println("Digite el nombre de la comunidad");
            String nombreComunidad = scanner.nextLine();
            String tipoComunidad = "";
            while (true) {
                System.out.println("Digite el tipo de la comunidad \n1.Afrocolombiana\n2.Indigena\n3.Raizal");
                tipoComunidad = scanner.nextLine();
                if (controladora.checkTypeCommunity(tipoComunidad)) {

                    break;
                } else {
                    System.out.println("Tipo de comunidad invalido");
                }
            }

            System.out.println("Digite la cantidad de habitantes de la comunidad");
            int cantidadHabitantes = scanner.nextInt();

            String problem1 = "";
            String problem2 = "";
            String problem3 = "";
            String problem4 = "";
            scanner.nextLine();
            System.out.println("La comunidad tiene hopsital? SI/NO");
            String YoN1 = scanner.nextLine();
            if (YoN1.toLowerCase().equals("no")) {
                problem1 = "No hospital";

            }
            System.out.println("La comunidad tiene escuela? SI/NO");
            String YoN2 = scanner.nextLine();
            if (YoN2.toLowerCase().equals("no")) {
                problem2 = "No escuela";

            }
            System.out.println("La comunidad tiene agua potable? SI/NO");
            String YoN3 = scanner.nextLine();
            if (YoN3.toLowerCase().equals("no")) {
                problem3 = "No agua potable";

            }
            System.out.println("La comunidad tiene falta acceso a la alimentacion? SI/NO");
            String YoN4 = scanner.nextLine();
            if (YoN4.toLowerCase().equals("si")) {
                problem4 = "No alimentacion";

            }

            System.out.println("");
            boolean consulta = controladora.addCommunityToPlace(nombreLugar, tipoComunidad, nombreComunidad,
                    cantidadHabitantes,
                    problem1,
                    problem2, problem3, problem4);
            if (consulta) {
                System.out.println("La comunidad se agrego con exito al lugrar [" + nombreLugar + "]");

            } else {
                System.out.println("¡Error! Memoria llena.");

            }

        } else {
            System.out.println("No hay lugares registrados aun");
        }

    }

    public void registerPlace() {

        System.out.print("Ingresa el nombre del lugar biodiverso\n>");
        String nombreLugar = scanner.nextLine();// guarda en el arreglo
        String departamentoLugar = "";
        while (true) {

            System.out.print("\nIngresa el departamento en el cual está el lugar\n>");
            departamentoLugar = scanner.nextLine();
            if (controladora.checkDepartment(departamentoLugar)) {
                break;
            } else {
                System.out.println("departamento invalido");
            }
        }

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
        if (controladora.checkPlace() == true) {
            if (controladora.checkCommunity() == true) {
                System.out.println(controladora.construir_lista_lugares());

                String nombreLugar = "";
                while (true) {

                    System.out.println("Digite el lugar donde se encuentra la comunidad ");
                    nombreLugar = scanner.nextLine();

                    if (controladora.checkExistPlace(nombreLugar)) {
                        break;
                    } else {
                        System.out.println("Lugar no registrado");

                    }

                }

                System.out.println("Digite el nombre del representante");
                String name = scanner.nextLine();

                System.out.println("Digite el numero de telefono del representante");
                String phoneNumber = scanner.nextLine();

                boolean consulta = controladora.addRepresentativeToCommunity(nombreLugar, name, phoneNumber);

                if (consulta) {
                    System.out.println(
                            "El representante se agrego con exito a la comunidad del lugrar [" + nombreLugar + "]");

                } else {
                    System.out.println("¡Error! Memoria llena.");

                }

            } else {
                System.out.println("No hay comunidades aun");
            }

        } else {
            System.out.println("No hay lugares registrados aun");
        }

    }

    public void updateSpecie() {
        if (controladora.checkPlace() == true) {

            if (controladora.checkSpecie() == true) {
                System.out.println(controladora.construir_lista_lugares());

                String placeSpecieUpdate = "";
                while (true) {

                    System.out.println("Digite el lugar donde habita la especie a modificar");
                    placeSpecieUpdate = scanner.nextLine();

                    if (controladora.checkExistPlace(placeSpecieUpdate)) {
                        break;
                    } else {
                        System.out.println("Lugar no registrado");

                    }

                }

                System.out.println(controladora.construir_lista_Species(placeSpecieUpdate));
                if (controladora.construir_lista_Species(placeSpecieUpdate).length() != 0) {

                    System.out.println("Digite el nombre de la especie a modificar");
                    String nameSpecieUpdate = scanner.nextLine();

                    System.out
                            .println("Que atributo desea modificar de la especie \n1. Nombre \n2. Cantidad \n3. Foto");
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
                } else {
                    System.out.println("No hay especies en el lugar!");
                }

            } else {
                System.out.println("No hay especies aun");
            }

        } else {
            System.out.println("No hay lugares registrados aun");
        }
    }

    public void lugarConMasEspecies() {
        if (controladora.checkPlace() == true) {

            System.out.println(" El lugar con mas especies es :" + controladora.PlaceTop());
        } else {

            System.out.println("No hay lugares registrados aun");
        }

    }

    public void comunidadWProblems() {

        if (controladora.checkCommunity()) {
            System.out.println(controladora.communityWTwoProblems());

        } else {
            System.out.println("No hay comunidades aun");
        }

    }

}
