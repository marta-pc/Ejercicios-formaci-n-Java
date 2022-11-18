package block5.commandlinerunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
@Configuration
public class ClaseSecundaria {

    public ClaseSecundaria()
    {
        System.out.println("Iniciando ClaseSecundaria");
        var c = new ClaseInicial();
        System.out.println("Clase Inicial..."+ c.getClase())
        ;
    }
    @Bean
    ClaseConInterface devuelve()
    {
        ClaseConInterface c= new  ClaseConInterface();
        c.soy("El bean");
        return c;
    }
    @Bean
    CommandLineRunner arranca () {
        return p -> {
            System.out.println("Hola desde clase secundaria");
        };

    }

}
