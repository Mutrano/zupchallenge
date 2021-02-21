package com.mutra.zupchallenge.repositories;

import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mutra.zupchallenge.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	
	@Transactional(readOnly = true)
	Optional<User> findByEmail(String email);
	
	@Transactional(readOnly = true)
	Optional<User> findByCpf(String cpf);
}
