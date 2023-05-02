package org.example.tema8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            Database.createConnection();
            //importData();
            //AbstractDAO<AlbumDAO> album= new AlbumDAO();
            /*var artist1=new Artist("Pink Floyd");
            var artist2=new Artist("Michael Jackson");
            var artists = new ArtistDAO();
            artists.create(artist1);
            artists.create(artist2);

            var album1=new Album(1979, "The Wall", "Pink Floyd", "Rock");
            var album2=new Album(1982, "Thriller", "Michael Jackson", "Funk,Soul,Pop");
            var albums = new AlbumDAO();
            albums.create(album1);
            albums.create(album2);

            var genre1=new Genre("Rock");
            var genre2=new Genre("Funk");
            var genre3=new Genre("Soul");
            var genre4=new Genre("Pop");
            var genres = new GenreDAO();
            genres.create(genre1);
            genres.create(genre2);
            genres.create(genre3);
            genres.create(genre4);
            Database.getConnection().commit();*/

            //TODO: print all the albums in the database
            Connection con = Database.getConnection();
            var albums = new AlbumDAO();
            System.out.println("Albumul cu id 6 este : " +albums.findById(600));

            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select title from albums");
                while (rs.next()) {
                    System.out.println(rs.getString(1));
                }
                Database.getConnection().close();
            } catch (SQLException e) {
                System.err.println(e);
                Database.rollback();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void importData() throws SQLException {
        File file =new File("D:\\albumlist.csv");
        String line = "";
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            line= br.readLine();
            line= br.readLine();
            while (line != null)
            {
                String[] data = line.split(cvsSplitBy);
                Album album=new Album(Integer.parseInt(data[1]),data[2],data[3],data[4]);
                var albums =new AlbumDAO();
                albums.create(album);
                //System.out.println(data[0]+" " +data[1] +" " + data[2] + " " + data[3] + " " + data[4]);

                line= br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Database.getConnection().commit();
        Database.rollback();
    }
}