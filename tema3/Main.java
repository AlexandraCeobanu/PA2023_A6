package tema3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Network network1=new Network();
        Person person1=new Programmer("Alex","2.03.1998","Java");
        Person person2=new Designer("Maria","1.03.1990","Web designer");
        Person person3=new Programmer("Andrei","15.12.1980","C++");
        Person person4=new Programmer("Andreea","10.11.1980","Java");
        Company company1 =new Company("Centric",1000);
        person1.addRelationship(person3,"work colleagues");
        person1.addRelationship(person4,"work colleagues");
        person2.addRelationship(person3,"best-friend");
        person3.addRelationship(company1,"team leader");
        network1.addNode(person1);
        network1.addNode(person2);
        network1.addNode(person3);
        network1.addNode(person4);
        network1.addNode(company1);
        System.out.println(network1);
        //network1.computeImportance();
    }
}