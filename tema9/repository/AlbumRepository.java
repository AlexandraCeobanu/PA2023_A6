package org.example.Laborator9.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.Laborator9.entity.Album;
import org.example.Laborator9.entity.Artist;
import org.example.Laborator9.entity.Genre;

import java.util.ArrayList;
import java.util.List;

public class AlbumRepository extends AbstractRepository<Album, Integer>  {
    private int releaseYear ;
    private String title;
    private Artist artist;
    private List<Genre> genres = new ArrayList<>();
    private int id;
    public AlbumRepository(int releaseYear,String name,Artist artist,List<Genre> genres){
        this.releaseYear=releaseYear;
        this.artist=artist;
        this.genres=genres;
        this.title=name;
    }
    public AlbumRepository(){}
    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }



    public int getReleaseYear() {
        return releaseYear;
    }

    public Artist getArtist() {
        return artist;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamplePU");
    EntityManager em = emf.createEntityManager();
    public Album findByName(String name) {
        return (Album) em.createNamedQuery("Album.findByName")
                .setParameter("title",title )
                .getSingleResult();
    }
    public Album findById(Integer id) {
        return (Album) em.createNamedQuery("Album.findById")
                .setParameter("id",id )
                .getSingleResult();
    }
}
