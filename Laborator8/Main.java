package org.example.Laborator8;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            Database.createConnection();
           /* var artists = new ArtistDAO();
            var albums = new AlbumDAO();
            artists.create("Pink Floyd");
            artists.create("Michael Jackson");
            var genres = new GenreDAO();
            genres.create("Rock"); //TODO: Funk, Soul, Pop
            Database.getConnection().commit();*/
            //var albums = new AlbumDAO();
            //albums.create(1979, "The Wall", "Pink Floyd", "Rock");
            //findByName
            //albums.create(1982, "Thriller", "Michael Jackson", "Funk,Soul,Pop");
            Database.getConnection().commit();
            //TODO: print all the albums in the database
            var albums = new AlbumDAO();
            System.out.println("Albumul cu id 6 este " + albums.findById(6));
            Connection con = Database.getConnection();
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
    }