package Laborator2;

public class Laborator2 {
    public static void main(String[] args) {
        Location location1=new Location("Bucuresti",45,65, Location.Type.CITY);
        System.out.println(location1.getType());
        System.out.println(location1.getX());
        System.out.println(location1.toString());
        Road road1=new Road(1234,50, Road.Type2.HIGHWAYS);
        System.out.println(road1.toString());
    }
}