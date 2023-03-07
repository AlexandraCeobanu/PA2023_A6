package Laborator3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Node> nodes=new ArrayList<>();
        Person person1=new Person("Valentina");
        Person person2=new Person("Alexandra");
        List<Person> persons=new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        Collections.sort(persons);
        System.out.println(persons);
        /*
        nodes.add(new Person("Alexandra"));
        nodes.add(new Person("Ana"));
        nodes.add(new Person("Veronica"));
        nodes.add(new Person("Carla"));
        nodes.add(new Company("Amazon"));
        System.out.println(nodes)*/
    }
}