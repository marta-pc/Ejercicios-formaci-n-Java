package block5.commandlinerunner;

import org.springframework.stereotype.Component;

@Component
public class ClaseConInterface implements MiInterface {

    @Override
    public void saluda() {
        System.out.println("Saludos desde clase inicial");
    }
    String nombre="Clasecon iNTERFACE";
    public String quienSoy(){ return nombre;};
    public void soy(String name) {nombre= name;
    }
}
