package com.example.payment_study1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PaymentStudy1Application {

	public static void main(String[] args) {
		SpringApplication.run(PaymentStudy1Application.class, args);
	}

}
