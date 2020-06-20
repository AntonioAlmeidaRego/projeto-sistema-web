package br.com.sistemawebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.sistemawebapp.annotations.EntityUnique;
import br.com.sistemawebapp.model.Funcionario;
import br.com.sistemawebapp.util.EntityValidUtilImpl;

@SpringBootApplication
public class SistemaWebAppApplication {

	public static void main(String[] args) {
		System.out.println("TESTANDO 123...");
		EntityValidUtilImpl<Funcionario> impl = new EntityValidUtilImpl<Funcionario>();
		impl.isEntityValid(EntityUnique.class, new Funcionario());
		SpringApplication.run(SistemaWebAppApplication.class, args);
	}

}
