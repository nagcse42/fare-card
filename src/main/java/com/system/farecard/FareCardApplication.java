package com.system.farecard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@ComponentScan("com.system.farecard")
@CrossOrigin(origins = "http://localhost:4200")
public class FareCardApplication {

	public static void main(String[] args) {
		SpringApplication.run(FareCardApplication.class, args);
	}

}
