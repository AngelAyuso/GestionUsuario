package com.gestion.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "com.gestion.usuarios.repository")
@SpringBootApplication
public class GestionUsuariosApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(GestionUsuariosApplication.class, args);
	}

}
