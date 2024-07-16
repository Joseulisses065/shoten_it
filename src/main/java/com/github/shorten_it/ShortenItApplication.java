package com.github.shorten_it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ShortenItApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShortenItApplication.class, args);
	}

}
