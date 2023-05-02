package org.example.tema8;

import java.sql.*;

public class AlbumDAO {

    public void create(Album album) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums (releaseYear,title,artist,genre) values (?,?,?,?)")) {
            pstmt.setInt(1, album.getReleaseYear());
            pstmt.setString(2, album.getName());
            pstmt.setString(3, album.getArtist());
            pstmt.setString(4, album.getGenre());
            pstmt.executeUpdate();
        }
    }
    public Album findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from albums where title='" + name + "'")) {
            Album album = null;
            if(rs.next()){
                 album = new Album(rs.getInt("releaseYear"),rs.getString("title"),rs.getString("artist"),rs.getString("genre"));
            }
            return  album;
        }
    }
    public Album findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from albums where id='" + id + "'")) {
            Album album=null;
            if(rs.next()){
                album = new Album(rs.getInt("releaseYear"),rs.getString("title"),rs.getString("artist"),rs.getString("genre"));
            }
            return  album;
        }
    }
}

