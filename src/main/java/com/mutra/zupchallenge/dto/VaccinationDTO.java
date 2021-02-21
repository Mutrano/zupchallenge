package com.mutra.zupchallenge.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;


public class VaccinationDTO {
	
	private Integer id;
	
	@NotEmpty(message="O nome da vacina não pode ser vazio")
	private String vaccineName;
	
	@NotEmpty(message="O E-mail de usuário não pode ser vazio")
	@Email(message="E-mail de usuário inválido")
	private String userEmail;
	
	@NotNull(message="A data de vacinação não pode ser nula")
	@PastOrPresent(message = "A data de vacinação deve ser no passado ou presente")
	private LocalDate vaccinationDate;

	public VaccinationDTO() {

	}

	public VaccinationDTO(Integer id, String vaccineName, @Email String userEmail,
			@PastOrPresent LocalDate vaccinationDate) {
		this.id = id;
		this.vaccineName = vaccineName;
		this.userEmail = userEmail;
		this.vaccinationDate = vaccinationDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public String getuserEmail() {
		return userEmail;
	}

	public void setEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public LocalDate getVaccinationDate() {
		return vaccinationDate;
	}

	public void setVaccinationDate(LocalDate vaccinationDate) {
		this.vaccinationDate = vaccinationDate;
	}
	
	
}