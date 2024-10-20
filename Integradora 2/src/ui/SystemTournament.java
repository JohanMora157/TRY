package ui;

import java.util.Calendar;
import java.util.Scanner;
import model.Tournament;

public class SystemTournament {

    private final Scanner scanner;
    private final Tournament control;
    private String start = "2024-01-01";
    private String end = "2024-02-01";

    public SystemTournament() {
        scanner = new Scanner(System.in);
        control = new Tournament();

        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        startDate.set(2024, Calendar.JANUARY, 1);
        endDate.set(2024, Calendar.FEBRUARY, 1);
        control.setDate(startDate);
        control.setDate(endDate);
    }

    public static void main(String[] args) {
        SystemTournament exe = new SystemTournament();
        exe.menu();
        exe.control.preUpdate();
    }

    public void menu() {
        System.out.println("-Bienvenido al programa para registrar un torneo--");
        int opcion;
        // Consume newline left-over
        while (true) {
            System.out.println(
                    "OPCIONES\n1. Registrar un torneo\n2. Registrar un equipo\n3. Registrar un jugador\n4. Registrar un arbitro\n5.generar grupos A y B\n6.Imprimir grupos A y B\n7. Mostrar partidos\n\n0  . Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1 -> registerTournament();
                case 2 -> registerTeam();
                case 3 -> registerPlayer();
                case 4 -> registerReferee();
                case 5 -> generateGroupAB();
                case 6 -> printGroups();
                case 7 -> showMatches();

                case 0 -> System.exit(0);
                default -> System.out.println("Opcion no valida");
            }

        }
    }

    public void registerTournament() {
        System.out.print("REGISTRAR TORNEO\nDigite el nombre del torneo \n> ");
        String nameTournament = scanner.nextLine();

        System.out.print("Digite la fecha de inicio del torneo (YYYY-MM-DD) \n> ");
        String startDateStr = scanner.nextLine();
        Calendar startDate = Calendar.getInstance();
        String[] startDateParts = startDateStr.split("-");
        startDate.set(Integer.parseInt(startDateParts[0]), Integer.parseInt(startDateParts[1]) - 1,
                Integer.parseInt(startDateParts[2]));

        control.setName(nameTournament);
        control.setDate(startDate);
    }

    public void registerTeam() {
        System.out.print("REGISTRAR EQUIPO\nDigite el nombre del equipo \n> ");
        String nameTeam = scanner.nextLine();

        System.out.print("Digite el pais del equipo \n> ");
        String countryTeam = scanner.nextLine();

        System.out.print("Digite el nombre del coach del equipo \n> ");
        String coachTeam = scanner.nextLine();

        if (control.addTeam(nameTeam, countryTeam, coachTeam)) {
            System.out.println("Equipo registrado correctamente");
        } else {
            System.out.println("Error al registrar el equipo	");
        }
    }

    public void registerPlayer() {

        System.out.println("REGISTRAR JUGADOR\n" + control.showTeams());

        System.out.print("Digite el nombre del equipo al que pertenece el jugador \n> ");
        String nameTeam = scanner.nextLine();

        System.out.print("Digite el pais del jugador \n> ");
        String countryPlayer = scanner.nextLine();

        System.out.print("Digite el nombre del jugador \n> ");
        String namePlayer = scanner.nextLine();

        System.out.print("Digite el dorsal del jugador \n> ");
        String dorsalPlayer = scanner.nextLine();

        System.out.println(
                "Digite la posicion del jugador \n1. Portero\n2. Defensa\n3. Centrocampista\n4. Delantero\n> ");
        int positionPlayer = scanner.nextInt();

        if (control.addPlayerToTeam(nameTeam, countryPlayer, namePlayer, dorsalPlayer, positionPlayer)) {
            System.out.println("Jugador registrado correctamente");
        } else {
            System.out.println("Error al registrar el jugador");
        }
    }

    public void registerReferee() {

        System.out.print("REGISTRAR REFEREE\nDigite el nombre del referee \n> ");
        String nameReferee = scanner.nextLine();

        System.out.print("Digite el pais del referee \n> ");
        String countryReferee = scanner.nextLine();

        System.out.println("Dgite el id del referee \n> ");
        String idReferee = scanner.nextLine();

        System.out.println("Digite el tipo de referee \n1. Principal\n2. Auxiliar\n> ");
        int typeReferee = scanner.nextInt();

        if (control.addReferee(nameReferee, countryReferee, idReferee, typeReferee)) {
            System.out.println("Referee registrado correctamente");
        } else {
            System.out.println("Error al registrar el referee");
        }

    }

    public void generateGroupAB() {

        System.out.println(control.createGroupsAB());
    }

    public void printGroups() {

        System.out.println(control.printGroupAB());
        System.out.println(control.generateMatchDates(control.getDate()));
    }

    public void showMatches() {
        control.addMatches();
        System.out.println(control.printMatches());
    }

}
