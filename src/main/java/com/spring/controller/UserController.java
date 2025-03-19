package com.spring.controller;

import com.spring.model.User;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
//import com.spring.util.JwtTokenUtil;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
  //  @Autowired
   // private JwtTokenUtil jwtTokenUtil;
    // Recuperarea tuturor utilizatorilor
    @GetMapping("/getAll")
    @ResponseBody
    public List<User> getAllUsers() {
        return this.userService.retrieveAllUsers();
    }

    // Crearea unui utilizator nou
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return this.userService.registerUser(user);
    }
    // Autentificarea unui utilizator
//    @PostMapping("/login")
//    @ResponseStatus(HttpStatus.CREATED)
//    public String login(@RequestBody User loginUser) {
//        User user = userService.authenticateUser(loginUser.getUsername(),loginUser.getPassword())
//        // generarea tokenului JWT
//      //  String token = jwtTokenUtil.generateToken(user);
//
//
//    }

    // Actualizarea unui utilizator existent
    @PutMapping("/update")
    @ResponseBody
    public User updateUser(@RequestBody User user) {
        return this.userService.updateUser(user);
    }

    // Ștergerea unui utilizator după ID
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable Long id) {
        return this.userService.deleteUserById(id);
    }
}
