package block5.commandlinerunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication

public class CommandLineRunnerApplication {
@Autowired
ClaseTerciaria claseTerciaria;

	public static void main(String[] args) {
		SpringApplication.run(CommandLineRunnerApplication.class, args);

	}

}
