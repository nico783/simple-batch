package com.example.simplebatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.simplebatch.job.Job;

@SpringBootApplication
public class SimplebatchApplication {
	
	@Autowired
	private Job job;

	public static void main(String[] args) {
		SpringApplication.run(SimplebatchApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			
			// TODO: Vérifier si un autre batch est en train de s'executer ou non
			System.out.println("Démarrage");
 			
			// Execute job
			job.execute();
			
			System.out.println("Fin");
		};
	}
}
