package ua.danish.jba.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.danish.jba.entity.Blog;
import ua.danish.jba.entity.Item;
import ua.danish.jba.entity.Role;
import ua.danish.jba.entity.User;
import ua.danish.jba.repository.BlogRepository;
import ua.danish.jba.repository.ItemRepository;
import ua.danish.jba.repository.RoleRepository;
import ua.danish.jba.repository.UserRepository;


@Transactional
@Service
public class InitDbService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@PostConstruct 
	public void init(){
		Role roleUser = new Role();
		roleUser.setName("USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleUser.setName("ADMIN");
		roleRepository.save(roleAdmin);
		
		User userAdmin = new User();
		userAdmin.setName("admin");
		userAdmin.setPassword("admin");
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		
		Blog blog = new Blog();
		blog.setName("JavaStudyUA");
		blog.setUrl("http://feeds.feedburner.com/javavids?format=xml");
		blog.setUser(userAdmin);
		blogRepository.save(blog);
		
		Item item = new Item();
		item.setBlog(blog);
		item.setTitle("first");
		item.setLink("http://www.javavids.com");
		item.setPublishedDate(new Date());
		itemRepository.save(item);
		
		Item item2 = new Item();
		item2.setBlog(blog);
		item2.setTitle("second");
		item2.setLink("http://www.javavids.com");
		item2.setPublishedDate(new Date());
		itemRepository.save(item2);
	}

}