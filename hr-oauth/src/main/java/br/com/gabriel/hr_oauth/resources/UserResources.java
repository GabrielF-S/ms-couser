package br.com.gabriel.hr_oauth.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriel.hr_oauth.entities.User;
import br.com.gabriel.hr_oauth.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResources {

	@Autowired
	private UserService service;

	@GetMapping("/search")
	public ResponseEntity<User> getByEmail(@RequestParam String email) {

		try {
			User user = service.findByEmail(email);
			return ResponseEntity.ok(user);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}
	}

}
