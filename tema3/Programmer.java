package tema3;

public class Programmer extends Person{
    String programingLanguage=new String();
    Programmer(String name,String birthDate,String programingLanguage)
    {
        this.name=name;
        this.programingLanguage=programingLanguage;
        this.birthDate=birthDate;
    }

    public void setProgramingLanguage(String programingLanguage) {
        this.programingLanguage = programingLanguage;
    }

    public String getProgramingLanguage() {
        return programingLanguage;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Programmer{name='");
        sb.append(getName());
        sb.append("', birthDate='");
        sb.append(getBirthDate());
        sb.append("', programingLanguage='");
        sb.append(getProgramingLanguage());
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
