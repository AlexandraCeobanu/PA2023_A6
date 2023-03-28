package org.example.tema5;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class LoadCommand extends GenericCommand{
    LoadCommand()
    {
        this.name="Load";
    }
    public void action(Object ...obj) throws IOException {
        String path= (String) obj[0];
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(
                new File(path),
                Catalog.class);
        System.out.println(catalog.toString());
    }
    /*@Override
    public void action(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(
                new File(path),
                Catalog.class);
    }*/
}
