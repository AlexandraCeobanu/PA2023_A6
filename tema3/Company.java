package tema3;
public class Company implements  Node{
    private String name=new String();
    int numberOfEmployees;
    Company(String name,int numberOfEmployees)
    {
        this.name=name;
        this.numberOfEmployees=numberOfEmployees;
    }
    public  int compareTo(Company other) {
        return this.name.compareTo(other.getName());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                '}';
    }
    @Override
    public int getNumberOfRelationships()
    {
        return 0;
    }
}


