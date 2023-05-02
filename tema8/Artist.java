package org.example.tema8;

public class Artist extends AbstractClass {
    private String name;
    private int id;
    public Artist(String name)
    {
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
