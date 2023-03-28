package org.example.tema5;

import java.sql.SQLOutput;
import java.util.List;

public class ListCommand extends GenericCommand{
    ListCommand()
    {
        this.name="List";
    }
    public void action(Object ...obj)
    {
        if((obj[0] instanceof Catalog)==false)
            throw new IllegalArgumentException("Argumentul nu este o instanta a clasei Catalog");
        Catalog catalog= (Catalog) obj[0];
        System.out.println(catalog.getDocumentList());
    }
    /*@Override
    public void action(Catalog catalog) {
        System.out.println(catalog.getDocumentList());
    }*/
}
