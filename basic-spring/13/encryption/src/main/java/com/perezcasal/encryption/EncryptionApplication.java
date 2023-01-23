package com.perezcasal.encryption;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class EncryptionApplication {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(EncryptionApplication.class, args);

		PasswordEncoder passwordEncoder = applicationContext.getBean(PasswordEncoder.class);

		User user = new User();
		user.setUsername("elio");
		user.setPassword(passwordEncoder.encode("admin"));

		UserRepository userRepository = applicationContext.getBean(UserRepository.class);
		userRepository.save(user);
	}

}
