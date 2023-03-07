package tema2;

public class City extends Location{
     private int population;

    /**
     * constructorul clasei city
     * @param name numele orasului
     * @param x coordonata x
     * @param y coordonata y
     * @param population numarul de locuitori din oras
     */
    City(String name,int x, int y,int population)
    {
        this.name=name;
        this.x=x;
        this.y=y;
        this.population=population;
    }
    public void setPopulation(int population)
    {
        this.population=population;
    }
    @Override
    public int getPopulation()
    {
        return population;
    }

    @Override
    public String toString() {
        return "City{" +
                ", name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", population=" + population +
                '}';
    }
}
