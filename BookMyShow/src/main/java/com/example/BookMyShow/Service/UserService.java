package com.example.BookMyShow.Service;

import com.example.BookMyShow.Model.User;
import com.example.BookMyShow.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

        Optional<User> userOptional = userRepository.findByEmail(emailId);

        if (userOptional.isPresent()) {
            throw new RuntimeException("user Already Exists");
        }
        //password hasing
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEncoded = passwordEncoder.encode(password);

        //create the user
        User user = new User();
        user.setUserName(userName);
        user.setEmail(emailId);
        user.setPassword(passwordEncoded);
        user.setBookings(new ArrayList<>());

        //save the user and get the user Id from it.
        User registerUser = userRepository.save(user);

        return registerUser;
    }

    public User login(String emailId, String password) {
        Optional<User> optionaluser = userRepository.findByEmail(emailId);

        if (optionaluser.isEmpty()) {
            throw new RuntimeException("Given Email id is not Present, Please Sign up First");
        }

        User existingUser = optionaluser.get();

        //2. Match the given password with the encryption shared for the user.
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if(!passwordEncoder.matches(password, existingUser.getPassword())) {
             throw new RuntimeException("Password is Incorrect");
        }

        return existingUser;
    }


}
