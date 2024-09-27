package ui;

import java.util.Scanner;
import model.Cop16;

public class SystemG {

    private Scanner scanner;
    private String[] lugaresRegistrados;
    private String[] departamentosLugares;
    private int[] areaLugaresRegistrados;
    private int contadorLugar;

    private Cop16 controladora = new Cop16();

    public static void main(String[] args) {
        SystemG executable = new SystemG();
        executable.faseOneCop();

    }

    public SystemG() {

        scanner = new Scanner(System.in);
        lugaresRegistrados = new String[30];
        departamentosLugares = new String[30];
        areaLugaresRegistrados = new int[30];
        contadorLugar = 0;

        controladora = new Cop16();

    }

    public void faseOneCop() {
        Scanner scanner = new Scanner(System.in);
        // SystemG executable = new SystemG();
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

    }

}