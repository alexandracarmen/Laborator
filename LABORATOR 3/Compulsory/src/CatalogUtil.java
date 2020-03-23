
import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class CatalogUtil {
    protected static void save(Catalog catalog) {
        File file = new File( catalog.getPath() );
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = new FileOutputStream( file );

            oos = new ObjectOutputStream( fos );
            oos.writeObject( catalog );
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Catalog load(String path) throws InvalidObjectException {
        File file = new File( path );
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream( file );
            ois = new ObjectInputStream( fis );
            Catalog catalog = (Catalog) ois.readObject();
            return catalog;
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        throw new InvalidObjectException( "fail" );
    }

    public static void view(Document doc) {
        Desktop desktop = Desktop.getDesktop();
        try {
            URI uri = new URI( doc.getLocation() );
            if (desktop != null) {
                desktop.browse( uri );
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

    }
}