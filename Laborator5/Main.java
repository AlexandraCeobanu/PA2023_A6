package org.example.Laborator5;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CatalogUtil app=new CatalogUtil();
        Catalog catalog1=new Catalog("MyDocuments");
        Document doc1=new Document("1","Article1");
        Document doc2=new Document("2","Book1");
        catalog1.addDocument(doc1);
        catalog1.addDocument(doc2);
        //app.save(catalog1,"./catalog.json");
        System.out.println(app.load("./catalog.json"));
    }
    /*private void save(Catalog catalog, String path)
        throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                new File(path+catalog.getName()),
                catalog.toString());
    }
    private Catalog load(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(
                new File(path),
                Catalog.class);
        return catalog;
        //System.out.println(catalog.getName());
    }*/
}