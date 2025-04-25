package mx.album.album;

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
@CrossOrigin(origins = "http://localhost:4200") // Permitir solicitudes desde el frontend
public class AlbumController {
    private final AlbumRepository repository;

    public AlbumController(AlbumRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/album")
    List<Album> all(){
    return repository.findAll();
}
    @PostMapping("/album")
    Album newEmployee(@RequestBody Album newEmployee) {
        return repository.save(newEmployee);
    }

    // Single item
    @GetMapping("/album/{id}")
    Album one(@PathVariable Long id_album) {
        return repository.findById(id_album)
                .orElseThrow(() -> new AlbumNotFoundException(id_album));
    }

    @PutMapping("/album/{id}")
    Album replaceAlbum(@RequestBody Album newAlbum, @PathVariable Long id) {
        return repository.findById(id)
                .map(album -> {
                    album.setTitulo(newAlbum.getTitulo());
                    album.setFecha_lanzamiento(newAlbum.getFecha_lanzamiento());
                    return repository.save(album);
                })
                .orElseGet(() -> {
                    newAlbum.setIdAlbum(id);
                    return repository.save(newAlbum);
                });
    }

    @DeleteMapping("/album/{id}")
    void deleteAlbum(@PathVariable Long id_album) {
        repository.deleteById(id_album);
    }

    

}
