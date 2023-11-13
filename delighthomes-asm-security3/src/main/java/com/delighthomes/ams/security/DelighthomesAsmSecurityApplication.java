package com.delighthomes.ams.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DelighthomesAsmSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(DelighthomesAsmSecurityApplication.class, args);
	}

}
