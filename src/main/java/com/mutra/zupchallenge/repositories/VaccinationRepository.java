package com.mutra.zupchallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mutra.zupchallenge.domain.Vaccination;
@Repository
public interface VaccinationRepository extends JpaRepository<Vaccination,Integer>{
}
