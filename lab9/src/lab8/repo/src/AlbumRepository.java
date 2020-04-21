package lab8.repo;

import lab8.entity.Album;
import lab8.entity.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class AlbumRepository {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("MusicAlbumsPU");
    static EntityManager em = emf.createEntityManager();

    public static void create(Album a)
    {
        em.getTransaction().begin();
        em.persist(a);
        em.flush();
        em.close();
        emf.close();
    }
    public static Album findById(Integer id){
        Album album1 = em.find(Album.class, id);
        return album1;
    }
    public static List<Album> findByName(String name){
        String sqlQuery = "select * from albums where name = ?";
        Query q = em.createNativeQuery(sqlQuery, Album.class);
        q.setParameter( 1, name);
        List<Album> albumList = q.getResultList();
        return albumList;
    }
    public static List<Album> findByArtist(String name){
        String sqlQuery = "select al.name from albums al join artists a on al.artist_id = a.id where a.name = ?"; //mi-a dat autocomplete sql-ul la join
        Query q = em.createNativeQuery(sqlQuery, Album.class);
        q.setParameter( 1, name);
        List<Album> albumList = q.getResultList();
        return albumList;
    }
}