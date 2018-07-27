package com.yianyouxuan.auth.controller;

import com.yianyouxuan.auth.domain.User;
import com.yianyouxuan.auth.repository.UserRepository;
import com.yianyouxuan.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/current", method = RequestMethod.GET)
	public Principal getUser(Principal principal) {
		return principal;
	}

	@GetMapping
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	@PreAuthorize("#oauth2.hasScope('server')")
	@RequestMapping(method = RequestMethod.POST)
	public void createUser(@Valid @RequestBody User user) {
		userService.create(user);
	}
}
