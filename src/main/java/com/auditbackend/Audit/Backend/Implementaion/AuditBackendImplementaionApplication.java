package com.auditbackend.Audit.Backend.Implementaion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class AuditBackendImplementaionApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuditBackendImplementaionApplication.class, args);
		
	}

}
