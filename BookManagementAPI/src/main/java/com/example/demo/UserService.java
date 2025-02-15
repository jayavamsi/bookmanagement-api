package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
   


    public User createUser(User user) {
        return userRepository.save(user);
    }
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }
    public List<Book> getBooksByIds(List<Long> bookIds) {
        return bookRepository.findAllById(bookIds);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
