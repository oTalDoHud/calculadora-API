package com.calc.web.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.calc.web.model.User;
import com.calc.web.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public void run(String... args) throws Exception {
		
		User hud = new User("Hudson", "Hudson@gmail.com",
				"(11) 9 31155690", "123456");
		
		User kat = new User("Katharine", "Katharine@gmail.com",
				"(11) 9 51151340", "adberqrq3");
		
		User isra = new User("Israel", "Israel@gmail.com",
				"(11) 9 61112390", "1234dwa2356");
		
		userRepo.saveAll(Arrays.asList(hud, kat, isra));
	}

}
