package org.example.tema8;
import java.sql.*;

public class ArtistDAO  {
    public void create(Artist artist) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into artists (name) values (?)")) {
            pstmt.setString(1, artist.getName());
            pstmt.executeUpdate();
        }
    }
    public Artist findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from artists where name='" + name + "'")) {
            Artist artist = null;
            if(rs.next()){
                artist=new Artist(rs.getString("name"));}
            return artist;
            // return rs.next() ? rs.getString(1) : null;
        }
    }
    public Artist findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from artists where id='" + id + "'")) {
            Artist artist = null;
            if(rs.next()){
                artist=new Artist(rs.getString("name"));}
            return artist;
            // return rs.next() ? rs.getString(1) : null;
        }
    }

}


