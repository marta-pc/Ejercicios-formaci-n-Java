package block5.commandlinerunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
@Component
public class ClaseSecundaria {

    @Bean
    CommandLineRunner claseSecundaria () {
        return p -> {
            System.out.println("Hola desde clase secundaria");
        };

    }

}
