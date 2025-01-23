package com.gcu.apartmentx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.gcu"})
public class ApartmentXApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApartmentXApplication.class, args);
	}

}
