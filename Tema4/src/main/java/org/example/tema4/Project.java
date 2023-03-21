package org.example.tema4;

public class Project implements Comparable<Project> {
    String name=new String();
    Project(String name)
    {
        this.name=name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Project other) {
        return this.name.compareTo(other.getName());
    }
}

