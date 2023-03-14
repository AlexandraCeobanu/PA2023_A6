package tema3;

import java.util.HashMap;
import java.util.Map;

public class Person implements Node {
    protected String name=new String();
    protected String birthDate=new String();

    protected Map<Node,String> relationships =new HashMap<>();

   /* Person(String name){
        this.name=name;
        this.birthDate=birthDate;
    }*/

    Person() {
    }

    public Map<Node, String> getRelationships() {
        return relationships;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthDate() {
        return birthDate;
    }
    public void addRelationship(Node node,String value)
    {
        relationships.put(node,value);
        if (node instanceof Person)
        {
        Person comp = (Person) node;
        comp.getRelationships().put(this,value);
        }
    }
    @Override
    public int getNumberOfRelationships()
    {
        return relationships.size();
    }
    public  int compareTo(Person other) {
        return this.name.compareTo(other.getName());
    }
}
