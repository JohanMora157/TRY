package ui;

import java.util.Scanner;
import model.Controller;

public class PokeCollector {

    public Scanner reader;
    private Controller controladora = new Controller();

    public static void main(String[] args) {

        PokeCollector executable = new PokeCollector();

        executable.menu();
    }

    /**
     * Descripcion: Este metodo se encarga de iniciar las variables globales
     * pre: El Scanner reader debe estar declarado
     * pos: l Scanner reader queda inicializado
     */
    public PokeCollector() {

        reader = new Scanner(System.in);
        controladora = new Controller();

    }

    /**
     * Descripcion: Este metodo se encarga de desplegar el menu al usuario y mostrar
     * los mensajes de resultado para cada funcionalidad
     * pre: El Scanner reader debe estar inicializado
     */
    public void menu() {

        System.out.println("Bienvenido a PokeCollector!");

        boolean salir = false;

        do {

            System.out.println("\nMenu Principal:");
            System.out.println("1. Registrar una Carta (Create)");
            System.out.println("2. Consultar una Carta (Read)");
            System.out.println("3. Modificar una Carta (Update)");
            System.out.println("4. Eliminar una Carta (Delete)");
            System.out.println("5. Ordenar de mayo a menor los puntos de vida");
            System.out.println("6. mostrar lista con todas las cartas y sus atributos");
            System.out.println("0. Salir");
            System.out.println("\nDigite la opcion a ejecutar");
            int opcion = reader.nextInt();

            switch (opcion) {
                case 1:
                    registrarCarta();
                    break;
                case 2:
                    consultarCarta();
                    break;
                case 3:
                    modificarCarta();
                    break;
                case 4:
                    eliminarCarta();
                    break;
                case 5:
                    controladora.ordenarMayorMenorPv();
                    break;
                case 6:
                    System.out.println(controladora.construirListaDeCarta());
                    break;

                case 0:
                    System.out.println("\nGracias por usar nuestros servicios!");
                    salir = true;
                    reader.close();
                    break;

                default:
                    System.out.println("\nOpción inválida!");
                    break;
            }

        } while (!salir);

    }

    /**
     * Descripcion: Este metodo se encarga de preguntar al usuario los datos
     * necesarios para registrar una carta en el sistema
     * pre: El Scanner reader debe estar inicializado
     */
    public void registrarCarta() {
        String idValido = "";
        // id-nombre-hp-tipo-rareza
        reader.nextLine();

        while (true) {
            System.out.println("Ingrese el ID de la carta");
            String id = reader.nextLine();

            if (!controladora.analizarId(id)) {
                System.out.println("El ID ya existe, digite otro");
            } else {
                idValido = id;
                break;
            }
        }

        System.out.println("Ingrese el nombre del Pokémon de la carta");
        String nombre = reader.nextLine();

        System.out.println("Ingrese los puntos de vida de la carta");
        int puntosVida = reader.nextInt(); // limpiar buffer
        reader.nextLine();

        System.out.println("Ingrese el tipo de Pokémon de la carta (agua, fuego, etc)");
        String tipo = reader.nextLine();

        System.out.println("Ingrese la rareza de la carta (básico, raro, mítico, legendario)");
        String rareza = reader.nextLine();

        boolean resultado = controladora.guardarCartaEnMemoria(idValido, nombre, puntosVida, tipo, rareza);

        if (resultado) {
            System.out.println("Carta registrada exitosamente");
        } else {
            System.out.println("¡Error! Memoria llena.");
        }
    }

    /**
     * Descripcion: Este metodo se encarga de desplegar al usuario los datos de una
     * carta registrada en el sistema
     * pre: El Scanner reader debe estar inicializado
     */

    public void consultarCarta() {
        if (controladora.memoria[0] != null) {
            reader.nextLine();
            System.out.println(controladora.construirListaDeCarta());
            System.out.println("Ingrese el ID de la carta a consultar");
            String idAConsultar = reader.nextLine();
            String consulta = controladora.mostrarCarta(idAConsultar);

            if (consulta == null) {
                System.out.println("No existe una carta registrada con ese ID");

            } else {
                System.out.println("La carta es: " + consulta);
            }

        } else {
            System.out.println("No hay cartas registradas");
        }

    }

    /**
     * Descripcion: Este metodo se encarga de bucar la carta segun el id dado por el
     * usuario o devolver un null si no esta la carta
     * pre: el arreglo memoria debe de estar inicializado
     */

    /**
     * Descripcion: Este metodo se encarga de recorrer todo el arreglo de memoria e
     * ir imprimiendo todo lo que tenga contenido en el
     * pre: el arreglo memoria debe de estar inicializado
     */

    /**
     * Descripcion: Este metodo se encarga de preguntar al usuario los datos
     * necesarios para modificar una carta en el sistema
     * pre: El Scanner reader debe estar inicializado
     */

    public void modificarCarta() {
        if (controladora.memoria[0] != null) {
            reader.nextLine();
            System.out.println(controladora.construirListaDeCarta());

            System.out.println("Ingrese el ID de la carta a modificar");
            String id = reader.nextLine();

            System.out.println("Que atributo desea modificar? \n" + "1=Nombre \n" + "2=Puntos de vida \n" + "3=Tipo"
                    + "\n" + "4=Rareza");
            int opcion = reader.nextInt();
            String mod = "";
            switch (opcion) {
                case 1:
                    reader.nextLine();

                    System.out.println("Proporcione el nuevo nombre del pokemon en la carta ");
                    mod = reader.nextLine();

                    break;
                case 2:
                    reader.nextLine();

                    System.out.println("Proporcione los nuevos puntos de vida de la carta");
                    mod = reader.nextInt() + "";

                    break;
                case 3:
                    reader.nextLine();

                    System.out.println("Proporcione el nuevo tipo del pokemon en la carta (Agua, Fuego, etc.)");
                    mod = reader.nextLine();

                    break;
                case 4:
                    reader.nextLine();

                    System.out.println("Proporcione la nueva rareza de la carta");
                    mod = reader.nextLine();

                default:
                    System.out.println("Opcion invalida");
                    break;
            }

            if (!controladora.trueModifyCard(opcion, mod, id)) {
                System.out.println("No existe una carta registrada con ese ID");

            } else {
                System.out.println("La carta se acaba de modificar");

            }

        } else {
            System.out.println("No hay cartas registradas");
        }

    }

    /**
     * Descripcion: Este metodo se encarga bucar la carta segun el id dado por el
     * usuario o devolver un null si no esta la carta
     * pre: el arreglo memoria debe de estar inicializado
     */

    /**
     * Descripcion: Este metodo se encarga de preguntar al usuario los datos
     * necesarios para eliminar una carta en el sistema
     * pre: El Scanner reader debe estar inicializado
     */

    public void eliminarCarta() {
        if (controladora.memoria[0] != null) {
            reader.nextLine();
            System.out.println(controladora.construirListaDeCarta());
            System.out.println("Ingrese el ID de la carta a eliminar");
            String idABorrar = reader.nextLine();
            String consulta = controladora.deleteCard(idABorrar);
            if (consulta == null) {
                System.out.println("La carta se elimino correctamente");

            } else {
                System.out.println("No se pudo eliminar la carta");
            }

        } else {
            System.out.println("No hay cartas registradas");
        }

    }
    /**
     * Descripcion: Este metodo se encarga bucar la carta segun el id dado por el
     * usuario o devolver un null si no esta la carta
     * pre: el arreglo memoria debe de estar inicializado
     */

    /**
     * Descripcion: Este metodo se encarga de ordenar de mayor a menor todo el
     * arreglo de cartas
     * pre: el arreglo memoria debe de estar inicializado
     */

}