package br.com.gabriel.hr_oauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.gabriel.hr_oauth.entities.User;
import br.com.gabriel.hr_oauth.feignClient.UserFeignClient;

@Service
public class UserService  implements UserDetailsService{

	@Autowired
	private UserFeignClient feignClient;
	
	
	private static Logger log = LoggerFactory.getLogger(UserService.class);
	
	public User findByEmail(String email) {
		User user = feignClient.findByEmail(email).getBody();
		
		if(user == null) {
			log.error("Email informado invalido: "+ email);
			throw new IllegalArgumentException("Email not found");
		
		}
		log.info("Email "+email+" Localizado");
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	User user = feignClient.findByEmail(username).getBody();
		
		if(user == null) {
			log.error("Email informado invalido: "+ username);
			throw new UsernameNotFoundException("Email not found");
		
		}
		log.info("Email "+username+" Localizado");

		return user;
				
	}
	
}
