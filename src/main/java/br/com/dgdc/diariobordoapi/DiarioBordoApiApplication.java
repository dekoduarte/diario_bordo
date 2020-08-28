package br.com.dgdc.diariobordoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class DiarioBordoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiarioBordoApiApplication.class, args);
	}

}
