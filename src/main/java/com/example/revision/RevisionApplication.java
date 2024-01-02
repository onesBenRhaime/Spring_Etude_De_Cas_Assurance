package com.example.revision;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class RevisionApplication {

	public static void main(String[] args) {
		SpringApplication.run(RevisionApplication.class, args);
	}

}
