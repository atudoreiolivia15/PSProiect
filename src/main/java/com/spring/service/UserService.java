package com.spring.service;

import com.spring.model.User;
import com.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;  // Modificăm la PasswordEncoder general

    // Înregistrarea unui utilizator nou
    public User registerUser(User user) {
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser.isPresent()) {
            throw new IllegalStateException("User already exists");
        }

        // Criptarea parolei
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setDate(LocalDate.now());

        return userRepository.save(user);  // Salvarea utilizatorului în baza de date
    }

    // Autentificarea utilizatorului
    public User authenticateUser(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);

        if (userOptional.isEmpty()) {
            throw new IllegalStateException("User not found");
        }

        User user = userOptional.get();

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalStateException("Invalid credentials");
        }

        return user;
    }

    // Recuperarea tuturor utilizatorilor
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    // Metodă pentru actualizarea unui utilizator
    public User updateUser(User user) {
        return userRepository.save(user); // Actualizarea utilizatorului în baza de date
    }

    // Ștergerea unui utilizator după ID
    public String deleteUserById(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "User deleted successfully";
        } else {
            throw new IllegalStateException("User not found");
        }
    }
}
