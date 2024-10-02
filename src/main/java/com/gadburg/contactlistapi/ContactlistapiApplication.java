package com.gadburg.contactlistapi;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.gadburg.contactlistapi.entity.Contact;
import com.gadburg.contactlistapi.repository.ContactRepository;

@SpringBootApplication
public class ContactlistapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactlistapiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ContactRepository contactRepository){
		return (String... args) -> {

				List<Contact> contacts = Arrays.asList(	
					new Contact("Pablo", "pablo@gmail.com", LocalDateTime.now()),
					new Contact("Pepe", "pepe@gmail.com", LocalDateTime.now()),
					new Contact("Pepa", "pepa@gmail.com", LocalDateTime.now()),
					new Contact("Javi", "javi@gmail.com", LocalDateTime.now()),
					new Contact("Test", "test@gmail.com", LocalDateTime.now()),
					new Contact ("test","test@gmail.com", LocalDateTime.now()),
					new Contact("tiempo","tiempo@gmail.com", LocalDateTime.now()),
					new Contact("nuevo","nuevo@gmail.com", LocalDateTime.now())
				);
				contactRepository.saveAll(contacts);
		};
	}

	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
