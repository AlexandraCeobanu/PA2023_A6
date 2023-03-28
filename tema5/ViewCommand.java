package org.example.tema5;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class ViewCommand extends GenericCommand  {
    ViewCommand()
    {
        this.name="View";
    }
    public void action(Object ...obj)
    {
        if((obj[0] instanceof Catalog)==false)
            throw new IllegalArgumentException("Argumentul 1 nu este o instanta a clasei Catalog");
        Catalog catalog= (Catalog) obj[0];
        if((obj[1] instanceof Document)==false)
            throw new IllegalArgumentException("Argumentul 2 nu este o instanta a clasei Document");
        Document doc=(Document) obj[1];
        Desktop desktop=Desktop.getDesktop();
        try{ desktop.open(catalog.findById(doc.getId()));}
        catch (NullPointerException e)
        {
            System.out.println("The  document doesn't exist");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



   /* @Override
    public void action(Catalog catalog, Document doc) throws IOException {
         Desktop desktop=Desktop.getDesktop();
            try{ desktop.open(catalog.findById(doc.getId()));}
             catch (NullPointerException e)
        {
            System.out.println("The  document doesn't exist");
        }
    }*/
}
