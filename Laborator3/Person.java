package Laborator3;
public class Person implements  Comparable<Person>, Node {
    private String name=new String();
    Person(String name){
        this.name=name;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
