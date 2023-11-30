package br.com.ipohealth.appgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AppgsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppgsApplication.class, args);
	}

}
