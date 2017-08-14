package ua.danish.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.danish.jba.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	

}
