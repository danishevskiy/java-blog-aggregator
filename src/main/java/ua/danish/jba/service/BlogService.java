package ua.danish.jba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.danish.jba.entity.Blog;
import ua.danish.jba.entity.User;
import ua.danish.jba.repository.BlogRepository;
import ua.danish.jba.repository.UserRepository;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private UserRepository userRepository;

	public void save(Blog blog, String name) {
		User user = userRepository.findByName(name);
		blog.setUser(user);
		blogRepository.save(blog);
	}

	public void delete(int id) {
		blogRepository.delete(id);
	}

}
