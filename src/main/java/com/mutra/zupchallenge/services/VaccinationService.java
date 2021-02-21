package com.mutra.zupchallenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutra.zupchallenge.domain.User;
import com.mutra.zupchallenge.domain.Vaccination;
import com.mutra.zupchallenge.dto.VaccinationDTO;
import com.mutra.zupchallenge.repositories.VaccinationRepository;

@Service
public class VaccinationService {

	@Autowired
	VaccinationRepository vaccinationRepository;
	
	@Autowired
	UserService userService;
	
	public Vaccination insert (VaccinationDTO dto) {
		Vaccination vaccination = fromDTO(dto);
		return vaccinationRepository.save(vaccination);
	}
	
	public Vaccination fromDTO(VaccinationDTO dto) {
		User user= userService.findByEmail(dto.getuserEmail());
		Vaccination vaccination = new Vaccination(null, dto.getVaccineName(), user, dto.getVaccinationDate());
		return vaccination;
	}
	
}
