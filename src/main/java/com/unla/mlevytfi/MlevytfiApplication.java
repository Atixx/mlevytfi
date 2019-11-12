package com.unla.mlevytfi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MlevytfiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MlevytfiApplication.class, args);
	}
}
