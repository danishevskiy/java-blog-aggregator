package ua.danish.jba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.danish.jba.entity.Blog;
import ua.danish.jba.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
	
	List<Blog> findByUser(User user);	

}
