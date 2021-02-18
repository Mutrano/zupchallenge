package com.mutra.zupchallenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutra.zupchallenge.domain.Vaccination;
import com.mutra.zupchallenge.repositories.VaccinationRepository;

@Service
public class VaccinationService {

	@Autowired
	VaccinationRepository vaccinationRepository;
	
	public void insert (Vaccination obj) {
		vaccinationRepository.save(obj);
	}
}
