package model;

public class Team {
    private String nameTeam;
    private String country;
    private String nameCoach;
    private Player[] players;

    public Team(String nameTeam, String country, String nameCoach) {
        this.nameTeam = nameTeam;
        this.country = country;
        this.nameCoach = nameCoach;
        this.players = new Player[20];
    }

    public String getNameTeam() {
        return nameTeam;
    }

    public void setNameTeam(String nameTeam) {
        this.nameTeam = nameTeam;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNameCoach() {
        return nameCoach;
    }

    public void setNameCoach(String nameCoach) {
        this.nameCoach = nameCoach;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public boolean addPlayer(Player newPlayer) {
        for (int i = 0; i < players.length; i++) {

            if (players[i] == null) {
                players[i] = newPlayer;
                return true;
            }
        }

        return false;

    }

    @Override
    public String toString() {
        return "Team [nameTeam=" + nameTeam + ", country=" + country + ", nameCoach=" + nameCoach + "]";
    }

}
