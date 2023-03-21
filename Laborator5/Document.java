package org.example.Laborator5;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Document implements Serializable {
    private String id=new String();
    private String name=new String();
    private Map<String,String> tags=new HashMap<>();
    private String location=new String();
    Document()
    {

    }
    Document(String id,String name)
    {
        this.id=id;
        this.name=name;
    }
    public void addTag(String key,String value)
    {
        tags.put(key,value);
    }
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Map<String, String> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tags=" + tags +
                '}';
    }
}

