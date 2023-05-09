package org.example.Laborator9.entity;

//import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
@Entity
@Table(name = "genres")
@NamedQueries({
        @NamedQuery(name = "Genre.findById",
                query = "select e from Genre e where e.id = ?1"),
        @NamedQuery(name = "Genre.findByName",
                query = "select e from Genre e where e.name = ?1"),
})

public class Genre extends AbstractEntity  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "genres")
    private List<Album> albums = new ArrayList<>();
    public Genre() {
    }

    public Genre(Integer id, String name)
    {
        this.id=id;
        this.name=name;
    }

    public Integer getId() {
        return id;
    }

    public List<Album> getAlbums() {
        return albums;
    }
    public void addAlbum(Album album)
    {
        albums.add(album);
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

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
