package block5.commandlinerunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ClaseInicial {

@Autowired
    ClaseTerciaria claseTerciaria;

    public ClaseInicial( )
    {
      //  this.claseTerciaria=claseTerciaria;
        //System.out.println("Iniciando ...."+claseTerciaria.quienSoy());
    }
    public ClaseTerciaria getClase()
    {
        return claseTerciaria;
    }
    @PostConstruct
    public void claseInicial (){
        System.out.println("Hola desde clase inicial: "+claseTerciaria);
    }


}
