package com.example.BookMyShow.Service;

import com.example.BookMyShow.Model.User;
import com.example.BookMyShow.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User signUp(String emailId, String userName, String password) {
          //1. validate if the user email is already exist

         Optional<User>  userOptional =  userRepository.findByEmail(emailId);

         if(userOptional.isPresent()) {
             throw new RuntimeException("user Already Exists");
         }

         //create the user
         User user = new User();
         user.setUserName(userName);
         user.setEmail(emailId);
         user.setPassword(password);
         user.setBookings(new ArrayList<>());

         //save the user and get the user Id from it.
         User registeredUser = userRepository.save(user);

         return registeredUser;
    }
}
