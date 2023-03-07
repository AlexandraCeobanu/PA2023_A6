package tema2;
public class Road {
    private int length;
    private int speedLimit;
    Road(int length,int speedLimit)
    {
        this.length=length;
        this.speedLimit=speedLimit;
    }


    public void setLength(int length) {
        this.length = length;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public int getLength() {
        return length;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }


    @Override
    public String toString() {
        return "Road{" +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
                '}';
    }
    /**
     * compara doua obiecte de tip  Road
     * @param obj obiect de tip Object
     * @return false daca obiectele nu au acelasi nume si aceleasi coordonate, true, in caz contrar
     */
    @Override
    public boolean equals(Object obj)
    {
        if(obj==null) return false;
        if(!(obj instanceof Road )) return false;
        Road comp=(Road)  obj;
        if(comp.length == length && comp.speedLimit==speedLimit )
            return true;
        return false;
    }
}

