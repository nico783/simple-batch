package com.example.simplebatch;

import com.example.simplebatch.job.Job;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SimplebatchApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SimplebatchApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(Job job) {
		return args -> {
			System.out.println("Démarrage du batch");
			long startTime = System.currentTimeMillis();
			job.execute();
			long endTime = System.currentTimeMillis();
			System.out.println("Durée du traitement: " + (endTime-startTime)/1000 + " secondes.");
			System.out.println("Fin du traitement.");
		};
	}
}
