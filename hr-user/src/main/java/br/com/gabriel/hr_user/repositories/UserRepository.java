package br.com.gabriel.hr_user.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gabriel.hr_user.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public Optional<User> findByEmail(String email);

}
