package com.sarvika.demo.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sarvika.demo.model.User;
import com.sarvika.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

	private final UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		if (userRepository.count() == 0) {
			User user1 = new User();
			user1.setName("Alice");
			user1.setEmail("alice@example.com");
			userRepository.save(user1);

			User user2 = new User();
			user2.setName("Bob");
			user2.setEmail("bob@example.com");
			userRepository.save(user2);

			User user3 = new User();
			user3.setName("Charlie");
			user3.setEmail("charlie@example.com");
			userRepository.save(user3);

			log.info("Pre-loaded 3 users into the database.");
		}
	}
}
