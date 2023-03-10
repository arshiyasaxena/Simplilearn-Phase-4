package org.Arshiya.fsd.p4.api.controller;

import org.Arshiya.fsd.p4.api.dto.User;
import org.Arshiya.fsd.p4.api.exception.OnlineTestServiceException;
import org.Arshiya.fsd.p4.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api",
				produces = { MediaType.APPLICATION_JSON_VALUE })
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/login")
	public User login(@Validated @RequestBody User user) throws OnlineTestServiceException {
		return service.login(user.getEmail(), user.getPassword(), user.getRole());
	}
	
	@PostMapping("/register")
	public User register(@Validated @RequestBody User user) throws OnlineTestServiceException {
		user.setEnabled(true);
		return service.register(user);
	}

}
