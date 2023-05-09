package org.example.Laborator9.repository;

import org.example.Laborator9.entity.Artist;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link org.example.Laborator9.entity.Artist} entity
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

    private EntityManager em;
    public Artist findByName(String name) {
        return (Artist) em.createNamedQuery("Artist.findByName")
                .setParameter("name",name )
                .getSingleResult();
}}
