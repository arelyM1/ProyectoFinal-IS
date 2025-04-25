package mx.artista.artista;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
class ArtistaController {

    private final ArtistaRepository repository;
    ArtistaController(ArtistaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/artistas")
    List<Artista> all() {
      return repository.findAll();
    }

    @PostMapping("/artistas")
    Artista newArtista(@RequestBody Artista newArtista) {
      return repository.save(newArtista);
    }
    @GetMapping("/artistas/{id}")
    Artista one(@PathVariable Long id) {
      return repository.findById(id)
        .orElseThrow(() -> new ArtistaNotFoundException(id));
    }

    @PutMapping("/artistas/{id}")
    Artista replaceArtista(@RequestBody Artista newArtista, @PathVariable Long id) {
      return repository.findById(id)
        .map(artista -> {
          artista.setNombre(newArtista.getNombre());
          artista.setPaisOrigen(newArtista.getPaisOrigen());
          return repository.save(artista);
        })
        .orElseGet(() -> {
          newArtista.setId_artista(id);
          return repository.save(newArtista);
        });
    }
    @DeleteMapping("/artistas/{id}")
    void deleteArtista(@PathVariable Long id) {
      repository.deleteById(id);
    }

}
