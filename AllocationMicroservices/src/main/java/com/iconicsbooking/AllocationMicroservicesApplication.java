package com.iconicsbooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.iconicsbooking.service.IconicBookingService;

@SpringBootApplication
public class AllocationMicroservicesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AllocationMicroservicesApplication.class, args);
	}

	
	@Autowired
	IconicBookingService iconicBookingService;

	@Override
	public void run(String... args) throws Exception {

	}

}
