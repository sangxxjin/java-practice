package org.sangxxjin.javapractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JavaPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaPracticeApplication.class, args);
	}

}
