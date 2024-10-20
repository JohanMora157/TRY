package model;

public class Player {

    private String country;
    private String name;
    private String dorsal;
    private PositionPlayer position;

    public Player(String country, String name, String dorsal, PositionPlayer position) {
        this.country = country;
        this.name = name;
        this.dorsal = dorsal;
        this.position = position;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDorsal() {
        return dorsal;
    }

    public void setDorsal(String dorsal) {
        this.dorsal = dorsal;
    }

    public PositionPlayer getPosition() {
        return position;
    }

    public void setPosition(PositionPlayer position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Player [country=" + country + ", name=" + name + ", dorsal=" + dorsal + "]";
    }
}
