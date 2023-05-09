package org.example.Laborator9.repository;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.Laborator9.entity.Album;
import org.example.Laborator9.entity.Artist;

import jakarta.persistence.EntityManager;
import org.example.Laborator9.entity.Genre;


public class GenreRepository  extends AbstractRepository<Genre, Integer> {
    private final Integer id;
    private final String name;

    public GenreRepository(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamplePU");
    EntityManager em = emf.createEntityManager();
    public Genre findByName(String name) {
        return (Genre) em.createNamedQuery("Genre.findByName")
                .setParameter("name",name )
                .getSingleResult();
    }
    public Genre findById(Integer id) {
        return (Genre) em.createNamedQuery("Genre.findById")
                .setParameter("name",id )
                .getSingleResult();
    }
   /* public void create (Artist artist)
    {
        em.persist(artist);
        em.getTransaction().commit();
    }*/
}
