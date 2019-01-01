package com.lithy.flightreservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlightreservationApplication/* extends SpringBootServletInitializer*/{
	
	//use extends SpringBootServletInitializer and overrider that method to bundle the project as war file 
	//in pom.xml use <packaging>war</packaging>
	/*@Override
	protected SpringApplicationBuilder configure (SpringApplicationBuilder builder) {
		return builder.sources(FlightreservationApplication.class);
	}*/

	public static void main(String[] args) {
		SpringApplication.run(FlightreservationApplication.class, args);
	}
}
