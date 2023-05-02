package org.example.Laborator9.repository;


import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.Laborator9.entity.Artist;

import jakarta.persistence.EntityManager;

/**
 * A DTO for the {@link Artist} entity
 */
public class ArtistRepository  {
    private final Integer id;
    private final String name;

    public ArtistRepository(Integer id, String name) {
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
    public Artist findByName(String name) {
        return (Artist) em.createNamedQuery("Artist.findByName")
                .setParameter("name",name )
                .getSingleResult();
    }
    public Artist findById(Integer id) {
        return (Artist) em.createNamedQuery("Artist.findById")
                .setParameter("name",id )
                .getSingleResult();
    }
   /* public void create (Artist artist)
    {
        em.persist(artist);
        em.getTransaction().commit();
    }*/
}

