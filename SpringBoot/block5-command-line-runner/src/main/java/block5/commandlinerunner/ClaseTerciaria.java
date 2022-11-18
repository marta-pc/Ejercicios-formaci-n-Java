package block5.commandlinerunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
@Component
public class ClaseTerciaria implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Soy la tercera clase");
    }
}
