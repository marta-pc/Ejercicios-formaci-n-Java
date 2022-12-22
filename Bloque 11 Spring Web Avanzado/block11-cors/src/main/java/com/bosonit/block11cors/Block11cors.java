package com.bosonit.block11cors;

import com.bosonit.block11cors.infrastructure.controller.dto.output.ProfOutputDto;
import com.bosonit.block11cors.infrastructure.feign.ProfesorFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableFeignClients
@SpringBootApplication
@ImportAutoConfiguration({FeignAutoConfiguration.class})

public class Block11cors {

	public static void main(String[] args) {
		SpringApplication.run(Block11cors.class, args);
	}

//	@Autowired
//	ProfesorFeign profesorFeign;
//	 @Bean
//	 public CommandLineRunner getProfesorFeign (){
//	 	return args -> {
//	 		ProfOutputDto profOutputDto = profesorFeign.getById(1, "simple");
//	 		System.out.println(profOutputDto);
//	 	};
//	 }


}
