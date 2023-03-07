package Laborator3;
public class Company implements Comparable<Company>, Node{
   private String name=new String();
   Company(String name)
   {
      this.name=name;
   }
   @Override
   public int compareTo(Company other) {
      return this.name.compareTo(other.name);
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
}
