package org.example.tema4;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        Faker faker = new Faker();
        var students= IntStream.rangeClosed(0,2)
                .mapToObj(i->new Student(faker.name().fullName()))
                .toArray(Student[]::new);

        var projects= IntStream.rangeClosed(0,2)
                .mapToObj(i->new Project(faker.number().digit()))
                .toArray(Project[]::new);

        students[0].addAdmissibleProjects(Arrays.asList(projects[0],projects[1],projects[2]));
        students[1].addAdmissibleProjects(Arrays.asList(projects[0],projects[1]));
        students[2].addAdmissibleProjects(Arrays.asList(projects[0]));


        //for(Student s: students)
         //System.out.println(s);

        Problem problem1= new Problem();
        for(Student s: students)
            problem1.addStudents(s);
        for(Project p: projects)
            problem1.addProjects(p);
        problem1.findPairs();
        System.out.println(problem1);
       // System.out.println();
       // System.out.println("Students that have a number of preferences lower than the average number of preferences: ");
       // problem1.printStudents();
        /*
        List<Student> studentsList=new LinkedList<>();
        for(Student s:students)
            studentsList.add(s);
        Collections.sort(studentsList);
        System.out.println(studentsList);

        Set<Project> projectsList=new TreeSet<>();
        for(Project p: projects)
            projectsList.add(p);
        System.out.println(projectsList);*/

    }
}