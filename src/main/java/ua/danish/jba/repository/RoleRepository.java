package ua.danish.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.danish.jba.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	

}