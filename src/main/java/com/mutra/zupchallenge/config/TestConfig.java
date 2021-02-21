package com.mutra.zupchallenge.config;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataIntegrityViolationException;

import com.mutra.zupchallenge.domain.User;
import com.mutra.zupchallenge.domain.Vaccination;
import com.mutra.zupchallenge.dto.UserDTO;
import com.mutra.zupchallenge.dto.VaccinationDTO;
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
	User user1 = new User(null, "Mário", "mutrano@gmail.com", "06193268081", LocalDate.of(1999,7, 2));
	UserDTO dto1 = new UserDTO(user1);
//	User user2 = new User(null, "Joana", "mutrano@gmail.com", "03740004096", LocalDate.of(1999,7, 2));
//	UserDTO dto2 = new UserDTO(user2);
//	userService.insert(dto1);
	try {
//		userService.insert(dto2);
	}
	catch(DataIntegrityViolationException e) {
		System.out.println(e.getMessage());
	}
	Vaccination vac = new Vaccination(null, "zé gotinha", user1, LocalDate.now());
	VaccinationDTO vacDto = new VaccinationDTO(null, vac.getVaccineName(), vac.getUser().getEmail(), vac.getVaccinationDate());
//	vaccinationService.insert(vacDto);
}
	
	
}
