package block5.commandlinerunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class ClaseTerciaria implements CommandLineRunner,  MiInterface {
    String nombre="Clasec ClaseTerciaria";
    public String quienSoy(){ return nombre;};
    public void soy(String name) {nombre= name;
    }
    @Override
    public void saluda() {
        System.out.println("Saludos desde clase inicial");
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Soy la tercera clase");
    }

    /*
    2) Modificar la tercera función para que imprima los valores pasados como parámetro al ejecutar el programa.

    @bean
    public class Saludo {
        protected String s1 = "Soy la";
        protected String s1 = "tercera clase";
    @bean
    public String gets1(){
        return s1; }
    @bean
    public String gets2(){
        return s2; }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(s1 + s2);
    }

    */
}
