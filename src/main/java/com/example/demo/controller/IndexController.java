package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.entity.UserFactoryInterface;
import com.example.demo.entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class IndexController {

	private final UserRepository userRepository;

	private final UserFactoryInterface userFactory;

	@Autowired
	public IndexController(UserRepository repo, UserFactoryInterface userFactory) {
		this.userRepository = repo;
		this.userFactory = userFactory;
	}

	@GetMapping(path = "/")
	public ResponseEntity index() {
		return new ResponseEntity<>(this.userRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping(path = "/")
	public ResponseEntity add(
		@RequestParam("username") String username,
		@RequestParam("email") String email,
		@RequestParam("password") String password
	) {
		try {
			User user = this.userFactory.make(username, email, password);
			this.userRepository.save(user);
			return new ResponseEntity<User>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping(path = "/")
	public ResponseEntity delete(@RequestParam Long id) {
		try {
			User user = this.userRepository.findOne(id);
			if (user == null) {
				return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
			}
			this.userRepository.delete(user);
			return new ResponseEntity<User>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
