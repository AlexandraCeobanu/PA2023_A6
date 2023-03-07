package tema2;

public class GasStation extends Location {
    private int gasPrice;
    /**
     * constructorul clasei GasStation
     * @param name numele statiei de alimentare
     * @param x coordonata x
     * @param y coordonata y
     * @param gasPrice pretul combustibilului
     */
    GasStation(String name,int x, int y,int gasPrice)
    {
        this.name=name;
        this.x=x;
        this.y=y;
        this.gasPrice=gasPrice;
    }
    @Override
    public int getGasPrice() {
        return gasPrice;
    }

    @Override
    public String toString() {
        return "GasStation{" +
                "gasPrice=" + gasPrice +
                ", name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
