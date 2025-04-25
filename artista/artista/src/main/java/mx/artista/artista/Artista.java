package mx.artista.artista;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
class Artista {

  private @Id
  @GeneratedValue Long id_artista;
  private String nombre;
  private String paisOrigen;

  public Artista() {}

  public Artista(String nombre, String paisOrigen) {
    this.nombre = nombre;
    this.paisOrigen = paisOrigen;
  }

  public Long getId_Artista() {
    return this.id_artista;
  }

  public String getNombre() {
    return this.nombre;
  }

  public String getPaisOrigen() {
    return this.paisOrigen;
  }

  public void setId_artista(Long id_artista) {
    this.id_artista = id_artista;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setPaisOrigen(String paisOrigen) {
    this.paisOrigen = paisOrigen;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Artista))
      return false;
    Artista artista = (Artista) o;
    return Objects.equals(this.id_artista,artista.id_artista) && Objects.equals(this.nombre,artista.nombre) && Objects.equals(this.paisOrigen,artista.paisOrigen);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id_artista, this.nombre, this.paisOrigen);
  }

  @Override
  public String toString() {
    return "Artistas{" + "id_artista=" + this.id_artista + ", nombre='" + this.nombre + '\'' + ", pais de origen='" + this.paisOrigen + '\'' + '}';
  }
}