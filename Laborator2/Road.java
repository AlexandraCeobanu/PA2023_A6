package Laborator2;

public class Road {
    public enum Type2{
        HIGHWAYS,
        EXPRESS,
        COUNTRY
    }
    private Type2 type;
    private int length;
    private int speedLimit;
    Road(int length,int speedLimit,Type2 type)
    {
        this.length=length;
        this.speedLimit=speedLimit;
        this.type=type;
    }

    public void setType(Type2 type) {
        this.type = type;
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

    public Type2 getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Laborator2.Road{" +
                "type=" + type +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
                '}';
    }
}
