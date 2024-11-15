package model;

public class Referee {
    private String id;
    private String name;
    private String country;
    private TypeReferee type;

    public Referee(String id, String name, String country, TypeReferee type) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public TypeReferee getType() {
        return type;
    }

    public void setType(TypeReferee type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Referee [id=" + id + ", name=" + name + ", country=" + country + "]";
    }
}