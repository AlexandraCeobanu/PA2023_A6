package org.example.tema8;

public class Album extends AbstractClass {
    private int releaseYear ;
    private String name;
    private String artist;
    private String genre;
    private int id;
    public Album(int releaseYear,String name,String artist,String genre){
        this.releaseYear=releaseYear;
        this.artist=artist;
        this.genre=genre;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Album{" +
                "releaseYear=" + releaseYear +
                ", name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                ", id=" + id +
                '}';
    }
}
