package org.example.Laborator8;

import java.sql.*;

public class AlbumDAO {
    public void create(int releaseYear,String name,String artist,String genre) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums (releaseYear,title,artist,genre) values (?,?,?,?)")) {
            pstmt.setInt(1, releaseYear);
            pstmt.setString(2, name);
            pstmt.setString(3, artist);
            pstmt.setString(4, genre);
            pstmt.executeUpdate();
        }
    }
    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from albums where title='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }
    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select title from albums where id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }
}
