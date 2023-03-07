package tema2;

public class Airport extends Location{
    int numberOfTerminals,population;
    /**
     * constructorul clasei airport
     * @param name numele
     * @param x coordonata x
     * @param y coordonata y
     * @param numberOfTerminals numarul de terminale din aeroport
     */
    Airport(String name,int x, int y,int numberOfTerminals)
    {
        this.name=name;
        this.x=x;
        this.y=y;
        this.numberOfTerminals=numberOfTerminals;
    }
    @Override
    public int getNumberOfTerminals()
    {
        return numberOfTerminals;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "numberOfTerminals=" + numberOfTerminals +
                ", population=" + population +
                ", name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
