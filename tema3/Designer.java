package tema3;

public class Designer extends Person {
    String specialization=new String();
    Designer(String name,String birthDate,String specialization)
    {
        this.name=name;
        this.birthDate=birthDate;
        this.specialization=specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Programmer{name='");
        sb.append(getName());
        sb.append("', birthDate='");
        sb.append(getBirthDate());
        sb.append("', specialization='");
        sb.append(getSpecialization());
        sb.append("', relationships=[");
        for(Node key: relationships.keySet())
        {
            String value=relationships.get(key);
            sb.append(key.getName());
            sb.append("-");
            sb.append(value);
            sb.append(", ");
        }
        sb.append("]}");
        return sb.toString();
    }
}
