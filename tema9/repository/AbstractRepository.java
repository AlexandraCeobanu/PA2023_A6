package org.example.Laborator9.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.Laborator9.entity.AbstractEntity;

import java.io.Serializable;

public class AbstractRepository <T extends AbstractEntity, ID extends Serializable>  {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamplePU");
        private EntityManager em = emf.createEntityManager();

        public T findById(ID id) {
            return (T) em.createNamedQuery("T.findById")
                    .setParameter("name",id)
                    .getSingleResult();
        }
    public T findByName(String name) {
        return (T) em.createNamedQuery("T.findByName")
                .setParameter("name",name)
                .getSingleResult();

    }
        public void persist(T entity) {
            try {
                em.getTransaction().begin();
                em.persist(entity);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            }
        }
    }
