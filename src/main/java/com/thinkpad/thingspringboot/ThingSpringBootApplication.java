package com.thinkpad.thingspringboot;

import com.thinkpad.thingspringboot.repository.ThingRepository;
import com.thinkpad.thingspringboot.repository.impl.ThingRepositoryImpl;
import com.thinkpad.thingspringboot.service.ThingService;
import com.thinkpad.thingspringboot.service.impl.ThingServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ThingSpringBootApplication {

	@Bean
	public ThingRepository thingRepository(){
		return new ThingRepositoryImpl();
	}

	@Bean
	public ThingService thingService() {
		return new ThingServiceImpl();
	}

	public static void main(String[] args) {
		SpringApplication.run(ThingSpringBootApplication.class, args);
	}
}
