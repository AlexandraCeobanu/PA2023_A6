package tema2;
 abstract class Location {
    protected String name=new String();
    protected int x,y;
    public String getName() {
        return name;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
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
     public int getPopulation() {
         return 0;
     }
     public int getNumberOfTerminals()
     {
         return 0;
     }
     public int getGasPrice()
     {
         return 0;
     }
     @Override
    public String toString() {
        return "Laborator2.Location{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

     /**
      * compara doua obiecte de tip Location
      * @param obj obiect de tip Object
      * @return false daca obiectele nu au acelasi nume si aceleasi coordonate, true, in caz contrar
      */
    @Override
    public boolean equals(Object obj)
    {
        if(obj==null) return false;
        if(!(obj instanceof Location )) return false;
        Location comp=(Location)  obj;
        if(comp.name.equals(name)==true && comp.x==x && comp.y==y )
            return true;
        return false;
    }
}

