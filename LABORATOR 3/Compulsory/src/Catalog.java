
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Catalog implements Serializable {

    private String name;
    private String path;
    private List<Document> documents = new ArrayList<Document>();

    public Document findById(String id) {
        return documents.stream()
                .filter( d -> d.getId().equals( id ) ).findFirst().orElse( null );
    }


    public void add(Document document) {
        documents.add( document );
    }

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", documents=" + documents +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Catalog)) return false;
        Catalog catalog = (Catalog) o;
        return Objects.equals( getName(), catalog.getName() ) &&
                Objects.equals( getPath(), catalog.getPath() ) &&
                Objects.equals( getDocuments(), catalog.getDocuments() );
    }

    @Override
    public int hashCode() {
        return Objects.hash( getName(), getPath(), getDocuments() );
    }

}
