package br.com.gabriel.hr_user.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.hr_user.entities.User;
import br.com.gabriel.hr_user.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserResource {
	

	@Autowired
	private Environment env;
	
	@Autowired
	private static Logger log = LoggerFactory.getLogger(User.class);
	
	@Autowired
	UserRepository repository;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> lista = repository.findAll();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
	
		log.info("Port = "+ env.getProperty("local.server.port"));
		User user = repository.findById(id).get();
		return ResponseEntity.ok(user);
	
	}
	
	@GetMapping("/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email){
		
		User user = repository.findByEmail(email).get();
		return ResponseEntity.ok(user);
	}


}
