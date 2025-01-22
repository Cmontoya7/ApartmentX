package com.gcu.apartmentx;

import com.gcu.apartmentx.models.LoginModel;
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
