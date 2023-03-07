package tema2;

import java.util.ArrayList;
import java.util.List;

public class Problem {
    private int nrLocations;
    private int nrRoads;
    List<Location> locations=new ArrayList<Location>();
    List<Road> roads=new ArrayList<Road>();
    Problem()
    {
        nrLocations=0;
        nrRoads=0;
    }

    /**
     * adauga o noua locatie in lista de locatii
     * @param location obiect de tip Location
     */
    public void addLocation(Location location)
    {
        if(checkLocation(location)==false)
        { locations.add( location);
            nrLocations=nrLocations+1;}
        else
        {
            System.out.println(location.toString()+"  already exists! ");
        }
    }
    /**
     * adauga un drum in lista de drumuri
     * @param road obiect de tip Road
     */
    public void addRoad(Road road)
    {
        if(checkRoad(road)==false)
        {roads.add( road);
            nrRoads=nrRoads+1;}
        else
        {
            System.out.println(road.toString() + "already exists! ");
        }
    }

    /**
     * afiseaza locatiile existente
     */
    public void showLocations()
    {
        for(int i=0;i<nrLocations;i++)
        {
            System.out.println(locations.get(i).toString());
        }
    }

    /**
     * afiseaza drumurile existente
     */
    public void showRoads()
    {
        for(int i=0;i<nrRoads;i++)
        {
            System.out.println(roads.get(i).toString());
        }
    }

    /**
     * verifica daca locatia data ca parametru exista deja in lista de locatii
     * @param obj obiect de tip Object
     * @return true daca exista ,false in caz contrar
     */
    public boolean checkLocation(Object obj)
    {
        for(int i=0;i<nrLocations;i++)
        {
            if(locations.get(i).equals(obj)==true)
                return true;
        }
        return false;
    }
    /**
     * verifica daca drumul dat ca parametru exista deja in lista de drumuri
     * @param obj obiect de tip Object
     * @return true daca exista ,false in caz contrar
     */
    public boolean checkRoad(Object obj)
    {
        for(int i=0;i<nrRoads;i++)
        {
            if(roads.get(i).equals(obj)==true)
                return true;
        }
        return false;
    }

    /**
     * calculeaza distanta euclidiana dintre doua locatii
     * @param location1 obiect de tip Location
     * @param location2 obiect de tip Location
     * @return distanta euclidiana dintre cele doua locatii date ca parametri
     */
    public double calculateDistance(Location location1,Location location2)
    {
        double xd=(location2.getX()-location1.getX());
        double yd=(location2.getY()-location1.getY());
        return  Math.sqrt(xd*xd+yd*yd);
    }

    /**
     * verifica daca exista un drum intre doua locatii: se compara lungimea drumului cu distanta euclidiana
     * @param location1 obiect de tip Location
     * @param location2 obiect de tip Location
     * @return true,daca exista, false, in caz contrar
     */
    public boolean checkRoute(Location location1,Location location2)
    {
        double distance=calculateDistance(location1,location2);
        for(int i=0;i<nrRoads;i++)
        {
            if(roads.get(i).getLength()>=distance)
                return true;
        }
        return false;
    }
}

