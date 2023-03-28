package org.example.tema5;

import freemarker.template.TemplateException;

import javax.print.Doc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericCommand {
   protected String name=new String();
    protected List<Document> documents =new ArrayList<>();

    public String getName() {
        return name;
    }

    public List<Document> getArguments() {
        return documents;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArguments(List<Document> docs) {
        this.documents = docs;
    }
    public void action(Object...obj) throws IOException, TemplateException, IllegalArgumentException,InvalidCatalogException,InvalidDocumentException {}
    //public  void action(Catalog catalog,Document doc) throws IOException, InvalidCatalogException, TemplateException{};
    //public  void action(String path) throws IOException, TemplateException{};
    //public  void action(Catalog catalog) throws IOException, InvalidCatalogException,TemplateException{};

}
