package model;

import java.util.Calendar;
import java.util.Random;

public class Tournament {

    private String name;
    private Calendar date;
    private final Random random;
    private int verifyGroup = 0;
    private final Team[] groupA;
    private final Team[] groupB;

    private final Team[] teams;
    private final Referee[] referees;
    private final Match[] matches;

    public Tournament() {

        this.teams = new Team[8];
        this.referees = new Referee[12];
        random = new Random();
        groupA = new Team[4];
        groupB = new Team[4];
        matches = new Match[24];
        preUpdate();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public boolean addTeam(String nameTeam, String country, String nameCoach) {

        for (int i = 0; i < teams.length; i++) {
            if (teams[i] == null) {
                teams[i] = new Team(nameTeam, country, nameCoach);
                return true;
            }
        }
        return false;
    }

    public boolean addReferee(String id, String nameReferee, String countryReferee, int type) {

        TypeReferee t = TypeReferee.AUXILIARY;
        switch (type) {
            case 1 -> t = TypeReferee.MAIN;
            case 2 -> t = TypeReferee.AUXILIARY;
        }

        for (int i = 0; i < referees.length; i++) {
            if (referees[i] == null) {
                referees[i] = new Referee(id, nameReferee, countryReferee, t);
                return true;
            }
        }
        return false;
    }

    public String showTeams() {
        String list = "";

        for (int i = 0; i < teams.length; i++) {

            if (teams[i] != null) {
                list += teams[i].toString() + "\n";
            }
        }
        return list;
    }

    public Team searchTeam(String nameTeam) {

        for (int i = 0; i < teams.length; i++) {
            if (teams[i] != null) {
                if (teams[i].getNameTeam().equals(nameTeam)) {
                    return teams[i];
                }
            }
        }
        return null;
    }

    public boolean addPlayerToTeam(String nameTeam, String country, String name, String dorsal, int position) {

        PositionPlayer p = PositionPlayer.FOREWARD;

        switch (position) {
            case 1 -> p = PositionPlayer.FOREWARD;
            case 2 -> p = PositionPlayer.DEFENDER;
            case 3 -> p = PositionPlayer.MIDFIELDER;
            case 4 -> p = PositionPlayer.GOALKEEPER;
        }

        if (teams[0] != null) {
            Team searchTeam = searchTeam(nameTeam);
            if (searchTeam == null) {
                return false;
            }

            Player newPlayer = new Player(country, name, dorsal, p);

            return searchTeam.addPlayer(newPlayer);
        } else {
            return false;

        }

    }

    public void preUpdate() {

        teams[0] = new Team("Cali", "Colombia", "Pepito");
        teams[1] = new Team("Medellin", "Brasil", "Juanito");
        teams[2] = new Team("Bogota", "Ecuador", "Pablito");
        teams[3] = new Team("Bucaramanga", "Inglaterra", "Carlos");
        teams[4] = new Team("liverpool", "Chile", "klopp");
        teams[5] = new Team("city", "Gales", "pep");
        teams[6] = new Team("united", "España", "hag");
        teams[7] = new Team("wolves", "Mexico", "traore");

        referees[0] = new Referee("1", "Juan", "Colombia", TypeReferee.MAIN);
        referees[1] = new Referee("2", "Pedro", "Brasil", TypeReferee.MAIN);
        referees[2] = new Referee("3", "Maria", "Colombia", TypeReferee.MAIN);
        referees[3] = new Referee("4", "Laura", "australia", TypeReferee.MAIN);
        referees[4] = new Referee("5", "Jose", "EEUU", TypeReferee.AUXILIARY);
        referees[5] = new Referee("6", "Ana", "Salvadaor", TypeReferee.AUXILIARY);
        referees[6] = new Referee("7", "Carlos", "Venezuela", TypeReferee.AUXILIARY);
        referees[7] = new Referee("8", "Sofia", "Colombia", TypeReferee.AUXILIARY);
        referees[8] = new Referee("9", "Luis", "Bolivia", TypeReferee.AUXILIARY);
        referees[9] = new Referee("10", "Lucia", "Uruguay", TypeReferee.AUXILIARY);
        referees[10] = new Referee("11", "Diego", "Paraguay", TypeReferee.AUXILIARY);
        referees[11] = new Referee("12", "Valentina", "Peru", TypeReferee.AUXILIARY);

    }

    public String createGroupsAB() {

        if (verifyGroup == 0) {
            String listA = "GROUP A\n", listB = "GROUP B\n";

            if (teams[7] != null) {

                int indexA = 0;
                int indexB = 0;

                boolean[] assigned = new boolean[teams.length];

                while (indexA < 4 || indexB < 4) {
                    int randomIndex = random.nextInt(teams.length);
                    // Verifica si el equipo ya ha sido asignado
                    if (!assigned[randomIndex]) {
                        if (indexA < 4) {
                            groupA[indexA++] = teams[randomIndex];
                        } else if (indexB < 4) {
                            groupB[indexB++] = teams[randomIndex];
                        }
                        assigned[randomIndex] = true; // Marca el equipo como asignado
                    }
                }

                // Generar la lista de equipos para el Grupo A
                for (int l = 0; l < groupA.length; l++) {
                    listA += groupA[l].toString() + "\n";
                }

                // Generar la lista de equipos para el Grupo B
                for (int k = 0; k < groupB.length; k++) {
                    listB += groupB[k].toString() + "\n";
                }
                verifyGroup = 1;
                return listA + "\n" + listB;

            }
            return "No hay suficientes equipos para generar grupos A y B.";

        } else {

            return "Ya se han generado los grupos A y B";
        }

    }

    public String printGroupAB() {

        String listA = "GROUP A\n", listB = "GROUP B\n";

        for (int l = 0; l < groupA.length; l++) {
            listA += groupA[l].toString() + "\n";
        }

        // Generar la lista de equipos para el Grupo B
        for (int k = 0; k < groupB.length; k++) {
            listB += groupB[k].toString() + "\n";
        }
        verifyGroup = 1;
        return listA + "\n" + listB;
    }

    public String generateMatchDates(Calendar initialDate) {
        if (verifyGroup == 0) {
            return "Primero debe generar los grupos A y B.";
        }

        String schedule = "";
        Calendar matchDate = (Calendar) initialDate.clone();
        int matchCount = 0;

        for (int i = 0; i < groupA.length; i++) {
            for (int j = i + 1; j < groupA.length; j++) {
                if (matchCount == 2) {
                    matchDate.add(Calendar.DAY_OF_MONTH, 3);
                    matchCount = 0;
                }
                schedule += "Partido: " + groupA[i].getNameTeam() + " vs " + groupA[j].getNameTeam()
                        + " - Fecha: " + matchDate.getTime() + "\n";
                matchCount++;
            }
        }

        for (int i = 0; i < groupB.length; i++) {
            for (int j = i + 1; j < groupB.length; j++) {
                if (matchCount == 2) {
                    matchDate.add(Calendar.DAY_OF_MONTH, 3);
                    matchCount = 0;
                }
                schedule += "Partido: " + groupB[i].getNameTeam() + " vs " + groupB[j].getNameTeam()
                        + " - Fecha: " + matchDate.getTime() + "\n";
                matchCount++;
            }
        }

        return schedule;
    }

    public boolean addMatches() {

        int index = 0;
        for (int i = 0; i < groupA.length; i++) {
            for (int j = i + 1; j < groupA.length; j++) {
                matches[index] = new Match(groupA[i], groupA[j]);
                index++;
            }
        }

        for (int i = 0; i < groupB.length; i++) {
            for (int j = i + 1; j < groupB.length; j++) {
                matches[index] = new Match(groupB[i], groupB[j]);
                index++;
            }
        }

        return true;

    }

    public String printMatches() {
        String list = "";
        for (int i = 0; i < matches.length; i++) {
            if (matches[i] != null) {
                matches[i].playMatch();
                list += matches[i].getMatchResult() + "\n";
            }
        }
        return list;

    }

}
