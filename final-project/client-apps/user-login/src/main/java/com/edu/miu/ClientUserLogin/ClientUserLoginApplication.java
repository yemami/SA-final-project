package com.edu.miu.ClientUserLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ClientUserLoginApplication implements CommandLineRunner {
	@Autowired
	RestTemplate restTemplate;

	public static void main(String[] args) {

		SpringApplication.run(ClientUserLoginApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String serverUrl = "http://localhost:8070/users/login";
		LoginRequest loginRequest = new LoginRequest("Abel", "abel");
		restTemplate.postForLocation(serverUrl, loginRequest);

	}

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}
