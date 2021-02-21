package com.mutra.zupchallenge.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mutra.zupchallenge.domain.Vaccination;
import com.mutra.zupchallenge.dto.VaccinationDTO;
import com.mutra.zupchallenge.services.VaccinationService;

@RestController
@RequestMapping(value="/vaccinations")
public class VaccinationResource {
	@Autowired 
	VaccinationService vaccinationService;
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody VaccinationDTO dto ){
		Vaccination vacc = vaccinationService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vacc.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
