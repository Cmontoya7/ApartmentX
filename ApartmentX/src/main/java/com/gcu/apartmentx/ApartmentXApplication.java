package com.gcu.apartmentx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ApartmentXApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApartmentXApplication.class, args);
	}
}