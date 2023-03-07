package tema2;
public class Main {
    public static void main(String[] args) {

        Problem problem1=new Problem();
        if(checkInstance(problem1)==true)
        {
            Location location1=  new City("Bucuresti",45,65,1000);
            Location location2 = new City("Iasi",100,70,100);
            problem1.addLocation(location1);
            problem1.addLocation(location2);
            problem1.addLocation(new Airport("Otopeni",100,65,5));
            problem1.addLocation(new GasStation("OMV",34,12,5));
             //problem1.showLocations();
            problem1.addRoad(new Road(1000,45));
            problem1.addRoad(new Road(56,60));
            //problem1.showRoads();

            System.out.println("There is road between the  locations: " + problem1.checkRoute(location1,location2));
        }
        else {
            System.out.println("the problem's instance is not valid");
        }
    }
    public static boolean checkInstance(Object obj)
    {
        if(obj==null) return false;
        return obj instanceof Problem;
    }
}