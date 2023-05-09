package org.example.Laborator9.entity;

//import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
@Entity
@Table(name = "artists")
@NamedQueries({
        @NamedQuery(name = "Artist.findById",
                query = "select e from Artist e where e.id = :id"),
        @NamedQuery(name = "Artist.findByName",
                query = "select e from Artist e where e.name = :name"),
})

public class Artist extends AbstractEntity  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Album> albums;

    public Artist() {
    }

    public Artist(Integer id, String name)
    {
        this.id=id;
        this.name=name;
    }
    public void addAlbum(Album album)
    {
        albums.add(album);
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
