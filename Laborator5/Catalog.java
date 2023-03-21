package org.example.Laborator5;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name=new String();

    private List<Document> documentList=new ArrayList<>();
    Catalog(String name)
    {
        this.name=name;
    }
    Catalog()
    {

    }
    public void addDocument(Document doc)
    {
        documentList.add(doc);
    }
    public Document findById(String id)
    {
        for(Document doc:documentList)
        {
            if(doc.getId().compareTo(id)==0)
                return doc;
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public List<Document> getDocumentList() {
        return documentList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", documentList=" + documentList +
                '}';
    }
}

