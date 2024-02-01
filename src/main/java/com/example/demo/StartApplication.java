package com.example.demo;

import com.example.demo.repository.BookRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BookRepository bookRepository;


	@Override
	public void run(String... args) throws Exception
	{
	}
}
