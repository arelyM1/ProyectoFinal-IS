package mx.artista.artista;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    @Bean
    CommandLineRunner initDatabase(ArtistaRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Artista("Luis Miguel", "Mexico")));
            log.info("Preloading " + repository.save(new Artista("Jeon Jungkook", "Corea del Sur")));
            log.info("Preloading " + repository.save(new Artista("Kim Taehyung", "Corea del Sur")));
            log.info("Preloading " + repository.save(new Artista("Park Rose", "Australia")));
            log.info("Preloading " + repository.save(new Artista("Yoon Gi", "Corea del Sur")));
        };
    }
}
