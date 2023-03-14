package org.example.laborator4;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        var students= IntStream.rangeClosed(0,2)
                .mapToObj(i->new Student("S"+i))
                .toArray(Student[]::new);

        var projects= IntStream.rangeClosed(0,2)
                .mapToObj(i->new Project("P"+i))
                .toArray(Project[]::new);

        List<Student> studentsList=new LinkedList<>();
        for(Student s:students)
            studentsList.add(s);
        Collections.sort(studentsList);
        System.out.println(studentsList);

        Set<Project> projectsList=new TreeSet<>();
        for(Project p: projects)
            projectsList.add(p);
        System.out.println(projectsList);
    }
}