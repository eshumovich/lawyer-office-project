package oop.inheritance;

public abstract class Human<T> {

    private String name;
    private T star;

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

    public T getStar() {
        return star;
    }

    public void setStar(T star) {
        this.star = star;
    }
}
