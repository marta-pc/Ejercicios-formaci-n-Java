package block5.commandlinerunner;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ClaseInicial {

    @PostConstruct
    public void claseInicial (){
        System.out.println("Hola desde clase inicial");
    }
}
