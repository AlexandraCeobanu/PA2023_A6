package org.example.tema5;

import java.util.List;

public class AddCommand extends GenericCommand{
    AddCommand()
    {
        this.name="Add";
    }

    public void action(Object ...obj) throws IllegalArgumentException {
        Catalog catalog ;
        Document doc=null;
        if((obj[0] instanceof Catalog)==false)
            throw new IllegalArgumentException("Argumentul nu este o instanta a clasei Catalog");
            catalog = (Catalog) obj[0];
        if((obj[1] instanceof Document)==false)
            throw new IllegalArgumentException("Argumentul nu este o instanta a clasei Document");
        doc=(Document) obj[1];
        catalog.getDocumentList().add(doc);
    }
    /*@Override
    public void action(Catalog catalog,Document doc)  {
            catalog.getDocumentList().add(doc);
    }*/
}
