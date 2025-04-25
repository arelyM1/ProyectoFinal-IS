package mx.album.album;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(AlbumRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Album("Golden","2023-03-11")));
            log.info("Preloading " + repository.save(new Album("Face", "2023-24-03")));
            log.info("Preloading " + repository.save(new Album("Layover", "2023-08-11")));
            log.info("Preloading " + repository.save(new Album("Rosie", "2024-6-12")));
            log.info("Preloading " + repository.save(new Album("D-Day", "2023-21-04")));
        };
        };
    }

