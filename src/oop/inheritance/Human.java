package oop.inheritance;

public abstract class Human {

    private String name;

    public Human(String name) {
        this.name = name;
    }

    public abstract void enterUniversity();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
