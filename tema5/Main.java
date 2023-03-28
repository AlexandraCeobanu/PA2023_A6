package org.example.tema5;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException, InvalidCatalogException, TemplateException, InvalidDocumentException {
        CatalogUtil app=new CatalogUtil();
        Catalog catalog1=new Catalog("MyDocuments");
        Document doc1=new Document("1","Article1","./Article1");
        Document doc2=new Document("2","Book1","./Book1");
        //doc1.addTag("autor","Blaa");
        catalog1.addDocument(doc1);
        catalog1.addDocument(doc2);
        //app.save(catalog1,"./catalog.json");
        //System.out.println(app.load("./catalog.json"));
        GenericCommand command1=new LoadCommand();
        command1.action("./catalog.json");
        GenericCommand command = new ViewCommand();
        command.action(catalog1, doc1);
        GenericCommand command2=new ReportCommand();
        command2.action(catalog1,doc1);
    }

}