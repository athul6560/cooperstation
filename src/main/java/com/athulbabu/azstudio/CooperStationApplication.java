package com.athulbabu.azstudio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;



@SpringBootApplication
@EntityScan( basePackages = {"com.athulbabu.azstudio.model"} )
public class CooperStationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CooperStationApplication.class, args);
	}

}
