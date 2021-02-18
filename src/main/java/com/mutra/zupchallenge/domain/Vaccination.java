package com.mutra.zupchallenge.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "tb_vaccination")
public class Vaccination {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String vaccineName;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	private LocalDate vaccinationDate;

	public Vaccination() {

	}

	public Vaccination(Integer id, String vaccineName, User user, LocalDate vaccinationDate) {
		this.vaccineName = vaccineName;
		this.user = user;
		this.vaccinationDate = vaccinationDate;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public LocalDate getVaccinationDate() {
		return vaccinationDate;
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
		Vaccination other = (Vaccination) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
