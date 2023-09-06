package com.jsp.user.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jsp.user.dto.User;
import com.jsp.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	

	 @PostMapping
	    public ResponseEntity<String> saveUser(@RequestBody User user) {
	        ResponseEntity<String> savedUser = userService.saveUser(user);

	        if (savedUser != null) {
	            return new ResponseEntity<>("User created", HttpStatus.CREATED);
	        } else {
	            return new ResponseEntity<>("Failed to create user", HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
       System.out.println(user.getUserPersonal().getFirstName());
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User user) {
       boolean updatedUser = userService.updateUser(id, user);

        if (updatedUser) {
        	return ResponseEntity.ok("{'isSuccess': true, 'message': 'Record Updated Successfully'}");
        } else {
            return ResponseEntity.status(500).body("{'isSuccess': false, 'message': 'Failed to Update Record'}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        boolean deleted = userService.deleteUser(id);
        if (deleted) {
            return ResponseEntity.ok("{'isSuccess': true, 'message': 'Record Deleted Successfully'}");
        } else {
            return ResponseEntity.status(500).body("{'isSuccess': false, 'message': 'Failed to Delete Record'}");
        }
    }
}
