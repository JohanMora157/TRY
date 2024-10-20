package model;

public class Match {

    private Team team1;
    private Team team2;
    private int goalsTeam1;
    private int goalsTeam2;
    private Referee[] referees;

    public Match(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
        referees = new Referee[2];

    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public int getGoalsTeam1() {
        return goalsTeam1;
    }

    public void setGoalsTeam1(int goalsTeam1) {
        this.goalsTeam1 = goalsTeam1;
    }

    public int getGoalsTeam2() {
        return goalsTeam2;
    }

    public void setGoalsTeam2(int goalsTeam2) {
        this.goalsTeam2 = goalsTeam2;
    }

    public Referee[] getReferees() {
        return referees;
    }

    public void setReferees(Referee[] referees) {
        this.referees = referees;
    }

    public void playMatch() {
        this.goalsTeam1 = (int) (Math.random() * 5);
        this.goalsTeam2 = (int) (Math.random() * 5);
    }

    public String getMatchResult() {

        return "Resultado del partido: " + team1.getNameTeam() + " " + goalsTeam1 + " - " + goalsTeam2 + " "
                + team2.getNameTeam();
    }

}
