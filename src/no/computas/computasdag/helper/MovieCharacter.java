package no.computas.computasdag.helper;

/**
 * @Author: vda
 */
public class MovieCharacter {
    private String name;
    private String actor;

    public MovieCharacter(String name, String actor) {
        this.name = name;
        this.actor = actor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
