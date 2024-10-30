package com.omji.users.user.api;

import com.omji.users.user.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserAPI {
    private List<User> users = new ArrayList<>();
    @GetMapping
    public String index() {
        return "index";
    }
    @PostMapping("/add")
    public ResponseEntity<List<User>> addUser(@RequestBody User user) {
        user.setId(users.size() + 1);  // Simple auto-increment ID logic
        users.add(user);
        return new ResponseEntity<>(users, HttpStatus.ACCEPTED);

    }
    // to fetch all user in details
//    @GetMapping("/allUser")
//    public ResponseEntity<List<User>> getAllUser() {
////
//        return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
//    }

    @GetMapping("/allUserName")
    public ResponseEntity<List<String>> getAllUser() {
        List<String> username  =  new ArrayList<>();
        for (User user : users) {
            username.add(user.getUsername());
        }
        return new ResponseEntity<>(username, HttpStatus.ACCEPTED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User updatedUser) {
        // Check if users list is not empty
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // No users to update
        }

        // Find the user by ID
        for (User user : users) {
            if (user.getId().equals(id)) {
                // Update user details
                user.setUsername(updatedUser.getUsername());
                user.setEmail(updatedUser.getEmail());
                user.setPassword(updatedUser.getPassword());
                user.setPhone(updatedUser.getPhone());
                return new ResponseEntity<>(user, HttpStatus.OK);  // Return the updated user
            }
        }

        // If user is not found, return NOT FOUND status
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
