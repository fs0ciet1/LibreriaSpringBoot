package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:8081/")
public class UserController
{
        @Autowired
        private UserRepository userRepository;

        @GetMapping("/user")
        public List<User> fetchUser(){
            return userRepository.findAll();
        }
}
