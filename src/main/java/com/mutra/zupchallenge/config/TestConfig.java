package com.mutra.zupchallenge.config;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mutra.zupchallenge.domain.User;
import com.mutra.zupchallenge.domain.Vaccination;
import com.mutra.zupchallenge.services.UserService;
import com.mutra.zupchallenge.services.VaccinationService;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
@Autowired
UserService userService;

@Autowired
VaccinationService vaccinationService;



@Override
public void run(String... args) throws Exception {
	// TODO Auto-generated method stub
	User user = new User(null, "Mário", "mutrano@gmail.com", "06193268081", LocalDate.of(1999,7, 2));
	userService.insert(user);
	Vaccination vac = new Vaccination(null, "zé gotinha", user, LocalDate.now());
	vaccinationService.insert(vac);
}
	
	
}
