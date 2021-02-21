package com.mutra.zupchallenge.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.br.CPF;

import com.mutra.zupchallenge.domain.User;

public class UserDTO {

	private Integer id;

	@NotEmpty(message="O nome não pode ser vazio")
	private String name;

	@NotEmpty(message="O E-mail não pode ser vazio")
	@Email(message = "E-mail inválido")
	private String email;
	
	@NotEmpty(message= "O CPF não pode ser vazio")
	@CPF(message = "CPF inválido")
	private String cpf;
	
	@NotNull(message="A data de nascimento não pode ser nula")
	@Past(message = "A data de nascimento deve ser uma data passada")
	private LocalDate dateOfBirth;

	public UserDTO() {

	}

	public UserDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.cpf = user.getCpf();
		this.dateOfBirth = user.getDateOfBirth();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
