package br.com.sistemawebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.sistemawebapp.annotations.EntityUnique;
import br.com.sistemawebapp.model.Funcionario;
import br.com.sistemawebapp.util.EntityValidUtilImpl;

@SpringBootApplication
public class SistemaWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaWebAppApplication.class, args);
	}

}
