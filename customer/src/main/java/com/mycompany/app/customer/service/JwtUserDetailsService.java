package com.mycompany.app.customer.service;

import java.util.ArrayList;
import java.util.Optional;

import com.mycompany.app.customer.model.JwtRequest;
import com.mycompany.app.customer.model.JwtRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	public final JwtRequestRepository jwtRequestRepository;

	@Autowired
	public JwtUserDetailsService(JwtRequestRepository jwtRequestRepository) {
		this.jwtRequestRepository = jwtRequestRepository;
	}

	public Boolean check(String name){

		Optional<JwtRequest> adminCheck = jwtRequestRepository
				                           .findByUsername(name);

		return adminCheck.isPresent();
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		if ("javainuse".equals(username)) {
//			return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//					new ArrayList<>());
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}

		if(check(username)){
			return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
					new ArrayList<>());
		}else{
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}


}