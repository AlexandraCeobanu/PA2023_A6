package org.example.Laborator9;

import com.github.javafaker.Faker;
import jakarta.persistence.Query;
import org.example.Laborator9.entity.Album;
import org.example.Laborator9.entity.Artist;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.Laborator9.entity.Genre;
import org.example.Laborator9.repository.AbstractRepository;
import org.example.Laborator9.repository.AlbumRepository;
import org.example.Laborator9.repository.ArtistRepository;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        testJPA();

    }
    public static void testJPA() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamplePU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Faker faker = new Faker();
        List<Artist> artists = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            String artistName = faker.artist().name();
            Artist artist=new Artist(1,artistName);
            artists.add(artist);
            em.persist(artist);
        }

        List<Genre> genres = new ArrayList<>();
        boolean exists=false;
        int i=0;
        while(i<10) {
            String name_genre = faker.music().genre();
            for(Genre genre : genres )
            {
                if(genre.getName().equals(name_genre)) {
                    exists=true;
                }
            }
            if(exists==false)
            {
                Genre genreNou = new Genre(1, name_genre);
                genres.add(genreNou);
                em.persist(genreNou);
                i++;
            }
            exists=false;
        }
        for ( i = 1; i <= 20; i++) {
            String title = faker.book().title();
            int releaseYear = faker.number().numberBetween(1960, 2023);
            int number_artist = faker.number().numberBetween(1,50);
            int number_genre = faker.number().numberBetween(0,9);
            Artist artist = artists.get(number_artist);
            List<Genre> genres2 = new ArrayList<>();
            Genre genre = genres.get(number_genre);
            genres2.add(genre);
            Album album=new Album(releaseYear,title,artist,genres2);
            em.persist(album);
        }

        //AlbumRepository album=new AlbumRepository();
       // System.out.println("Albumul cu id-ul specificat este : " + album.findById(1058));

        long startTime = System.currentTimeMillis();
        List<Artist> artistsList = em.createQuery("SELECT a FROM Artist a", Artist.class).getResultList();
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        System.out.println("Interogarea s -a realizat in  " + time + " milisecunde");

        for(Artist artist:artistsList)
        {
            System.out.println(artist);
        }


        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}




/* Artist artist = new Artist(1,"Beatles");
        em.persist(artist);
        Artist a = (Artist)em.createQuery(
                        "select e from Artist e where e.name='Beatles'")
                .getSingleResult();
        a.setName("The Beatles");
        em.getTransaction().commit();*/
        /*AlbumRepository album=new AlbumRepository(1979,"lal","Michael","rock");
        System.out.println("Albumul cu id-ul specificat este : " + album.findById(501));*/

       /* List<Artist> artists = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            Artist artist = new Artist(i,"Artist"+i);
            artists.add(artist);
        }
        List<Album> albums = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Album album = new Album(i,"Album"+i,"Artist"+i,"rock");
            albums.add(album);
        }
        for (Artist artist : artists) {
            em.persist(artist);
        }
        for (Album album : albums) {
            em.persist(album);
        }
        em.getTransaction().commit();

        long startTime = System.currentTimeMillis();
        em.createQuery("SELECT COUNT(a) FROM Album a WHERE a.title LIKE '%by Artist%'").getSingleResult();
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        System.out.println("Am gasit " + count + " albums in " + elapsedTime + " milliseconds.");*/
