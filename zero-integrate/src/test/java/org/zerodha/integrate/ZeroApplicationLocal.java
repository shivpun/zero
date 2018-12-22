package org.zerodha.integrate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.config.EnableIntegration;

@EnableIntegration
@SpringBootApplication
public class ZeroApplicationLocal {
	
	public static void main(String []args) {
		SpringApplication.run(ZeroApplicationLocal.class, args);
	}
}
