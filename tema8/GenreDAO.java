package org.example.tema8;
import java.sql.*;

public class GenreDAO  {
    private String name;
    public void create(Genre genre) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into genres (name) values (?)")) {
            pstmt.setString(1, genre.getName());
            pstmt.executeUpdate();
        }
        this.name=name;
    }
    public Genre findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from genres where name='" + name + "'")) {
            Genre genre = null;
            if(rs.next()){
                genre=new Genre(rs.getString("name"));}
            return genre;
            // return rs.next() ? rs.getString(1) : null;
        }
    }
    public Genre findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from genres where id='" + id + "'")) {
            Genre genre = null;
            if(rs.next()){
                genre=new Genre(rs.getString("name"));}
            return genre;
            // return rs.next() ? rs.getString(1) : null;
        }
    }
}


