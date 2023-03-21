package org.example.tema4;

import java.util.*;

public class Student implements Comparable<Student> {
    String name = new String();
    List<Project> admissibleProjects = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addAdmissibleProjects(List<Project> projects) {
        admissibleProjects = projects;
    }

    public List<Project> getAdmissibleProjects() {
        return admissibleProjects;
    }

    public int getNumberOfAdmissibleProjects() {
        return admissibleProjects.size();
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.getNumberOfAdmissibleProjects(), other.getNumberOfAdmissibleProjects());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student name: ");
        sb.append(getName());
        sb.append("- List of Admissible projects: [ ");
        for (Project p : admissibleProjects) {
            sb.append(p.getName());
            sb.append(", ");
        }
        sb.append(" ]");
        return sb.toString();
    }
}
