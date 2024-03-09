package com.example.BookMyShow;

import com.example.BookMyShow.Controller.UserController;
import com.example.BookMyShow.DTO.SignupRequestDTO;
import com.example.BookMyShow.DTO.SignupResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing   //create Events whenever DB update Happens
@SpringBootApplication
public class BookMyShowApplication implements CommandLineRunner  {

	private UserController userController;


	@Autowired
	public BookMyShowApplication(UserController userController) {

		this.userController = userController;
	}

	@Override
	public void run(String... args) throws Exception {
		SignupRequestDTO requestDTO = new SignupRequestDTO();

		requestDTO.setEmailId("test@gmail.com.com");
		requestDTO.setUserName("Ponsiva");
		requestDTO.setPassword("12345");

		SignupResponseDTO   responseDTO = userController.signUp(requestDTO);

		System.out.println("Status is " + responseDTO.getStatus());
		System.out.println("Your User Id is " + responseDTO.getUserId());


	}

	public static void main(String[] args) {
		//Application starts
		SpringApplication.run(BookMyShowApplication.class, args);

	}


}
