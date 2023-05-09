package org.example.Laborator9.entity;

//import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
@Entity
@Table(name = "albums")
@NamedQueries({
        @NamedQuery(name = "Album.findById",
                query = "select e from Album e where e.id = :id"),
        @NamedQuery(name = "Album.findByName",
                query = "select e from Album e where e.title = :title"),
})

public class Album extends AbstractEntity  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "releaseYear", nullable = false)
    private Integer releaseYear;
    @Column(name = "title", nullable = false)
    private String title;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "album_genre",
            joinColumns = { @JoinColumn(name = "album_id") },
            inverseJoinColumns = { @JoinColumn(name = "genre_id") }
    )
    private List<Genre> genres = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "artist", referencedColumnName = "name")
    private Artist artist;
    public Album() {
    }

    public Album(int releaseYear,String title,Artist artist,List<Genre> genres){
        this.releaseYear=releaseYear;
        this.artist=artist;
        this.title=title;
        this.genres=genres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public List<Genre> getGenres() {
        return genres;
    }


    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", releaseYear=" + releaseYear +
                ", title='" + title + '\'' +
                ", genres=" + genres +
                ", artist=" + artist +
                '}';
    }
}
