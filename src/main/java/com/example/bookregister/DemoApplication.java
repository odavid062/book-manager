package com.example.bookregister;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class DemoApplication {

	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		logger.info("Iniciando a aplicação Spring Boot...");
		SpringApplication.run(DemoApplication.class, args);
		logger.info("Aplicação iniciada com sucesso! 🚀");
	}
}