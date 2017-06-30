package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class IndexController {

    private final UserRepository userRepository;

    @Autowired
    public IndexController(UserRepository repo) {
        this.userRepository = repo;
    }

    @GetMapping(path="/")
    public ResponseEntity index() {
        return new ResponseEntity<>(this.userRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(path="/")
    public ResponseEntity add(@RequestBody User user) {
        try {
            this.userRepository.save(user);
            return new ResponseEntity<User>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/")
    public ResponseEntity find(@RequestParam Long id) {
        try {
            User user = this.userRepository.findOne(id);
            if (user == null) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<User>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/")
    public ResponseEntity update(@RequestParam Long id, @RequestBody User user) {
        try {
            User currentUser = this.userRepository.findOne(id);
            if (currentUser == null) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            currentUser.rename(user.getUsername());
            currentUser.changeEmail(user.getEmail());
            currentUser.changePassword(user.getPassword());
            this.userRepository.save(currentUser);
            return new ResponseEntity<User>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
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
