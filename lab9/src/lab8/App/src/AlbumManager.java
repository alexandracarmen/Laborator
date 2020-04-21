package lab8.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import lab8.entity.Album;
import lab8.entity.Artist;
import lab8.labAnterior.AlbumController;
import lab8.labAnterior.ArtistController;
import lab8.repo.AlbumRepository;
import lab8.repo.ArtistRepository;
import lab8.util.PersistenceUtil;

import java.util.List;

public class AlbumManager {
    public static void AlbumManager() {
        EntityManagerFactory factory = PersistenceUtil.create("MusicAlbumsPU");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        Artist artist1 = new Artist(1, "Miles Davis", "USA");
        Artist artist2 = new Artist(2, "Elvis Presley", "USA");

        Album album1 = new Album(1,"Kind of Blue", 1, 1955);
        Album album2 = new Album(2,"Elvis Presley", 2, 1965);
        Album album3 = new Album(2,"The Sun Sessions", 2, 1975);

        ArtistRepository artist = new ArtistRepository();
        AlbumRepository album = new AlbumRepository();

        artist.create(artist1);
        artist.create(artist2);
        Artist artistiId = artist.findById(1);
        List<Artist> artistiNume = artist.findByName("Miles Davis");
        System.out.print(artistiId);
        System.out.print(artistiNume);

        album.create(album1);
        album.create(album2);
        album.create(album3);
        Album albumId = album.findById(1);
        List<Album> albumNume = album.findByName("The Sun Sessions");
        List<Album> albumArtist = album.findByArtist("Miles Davis");
        System.out.print(albumId);
        System.out.print(albumNume);
        System.out.print(albumArtist);
    }
}