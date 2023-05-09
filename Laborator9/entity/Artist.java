package org.example.Laborator9.entity;

import javax.persistence.*;

@Entity
@Table(name = "artist")
@NamedQueries({
        @NamedQuery(name = "Artist.findById",
                query = "select e from Artist e where e.id = ?1"),
        @NamedQuery(name = "Artist.findByName",
                query = "select e from Artist e where e.name = ?1"),
        })

public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;

    public Artist() {
    }

   public Artist(Integer id, String name)
    {
        this.id=id;
        this.name=name;
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

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}