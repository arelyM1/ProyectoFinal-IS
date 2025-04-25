package mx.album.album;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
//import java.util.String;

@Entity
public class Album {
    
    private @Id
    @GeneratedValue Long id_album;
    private String titulo;
    private String fecha_lanzamiento;
   
    public Album() {
    }

    Album(String titulo, String fecha_lanzamiento) {
        this.titulo = titulo;
        this.fecha_lanzamiento = fecha_lanzamiento;
    }

    public Long getIdAlbum() {
        return id_album;
    }

    public void setIdAlbum(Long id_album) {
        this.id_album = id_album;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getFecha_lanzamiento() {
        return fecha_lanzamiento;
    }
    public void setFecha_lanzamiento(String fecha_lanzamiento) {
        this.fecha_lanzamiento = fecha_lanzamiento;
    }
    @Override
    public String toString() {
        return "Album{" +
                "ID del Album=" + id_album +
                ", Titulo del Album='" + titulo + '\'' +
                ", Fecha de Lanzamiento='" + fecha_lanzamiento + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Album)) return false;

        Album Album = (Album) o;

        if (!id_album.equals(Album.id_album)) return false;
        if (!titulo.equals(Album.titulo)) return false;
        return fecha_lanzamiento.equals(Album.fecha_lanzamiento);
    }
    @Override
    public int hashCode() {
        int result = id_album.hashCode();
        result = 31 * result + titulo.hashCode();
        result = 31 * result + fecha_lanzamiento.hashCode();
        return result;
    }

}