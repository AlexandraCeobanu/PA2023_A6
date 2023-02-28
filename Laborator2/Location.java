package Laborator2;

public class Location {
   public enum Type{
        CITY,
        AIRPORT,
        gasSTATION
    }
    private String name=new String();
    private int x,y;
    private Type type;
    Location(String name,int x, int y,Type type)
    {
        this.name=name;
        this.x=x;
        this.y=y;
        this.type=type;
    }
    public String getName() {
        return name;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Type getType() {
        return type;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Laborator2.Location{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", type=" + type +
                '}';
    }
}
