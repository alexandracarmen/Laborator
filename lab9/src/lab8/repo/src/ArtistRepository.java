package lab8.repo;

import lab8.entity.Album;
import lab8.entity.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ArtistRepository {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("MusicAlbumsPU");
    static EntityManager em = emf.createEntityManager();

    public static void create(Artist a) {
        em.getTransaction().begin();
        em.persist(a);
        em.flush();
        em.close();
        emf.close();
    }
    public static Artist findById(Integer id){
        Artist artist1 = em.find(Artist.class, id);
        return artist1;
    }
    public static List<Artist> findByName(String name){
        String sqlQuery = "select * from artists where name = ?";
        Query q = em.createNativeQuery(sqlQuery, Artist.class);
        q.setParameter( 1, name);
        List<Artist> artistList = q.getResultList();
        return artistList;
    }
}