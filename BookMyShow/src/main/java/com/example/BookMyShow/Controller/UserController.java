package com.example.BookMyShow.Controller;

import com.example.BookMyShow.DTO.Enum.ResponseStatus;
import com.example.BookMyShow.DTO.SignupRequestDTO;
import com.example.BookMyShow.DTO.SignupResponseDTO;
import com.example.BookMyShow.Model.User;
import com.example.BookMyShow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    public SignupResponseDTO signUp(SignupRequestDTO signupRequestDTO) {
          SignupResponseDTO signupResponseDTO = new SignupResponseDTO();

          try {
           User user =     userService.signUp(
                        signupRequestDTO.getEmailId(),
                        signupRequestDTO.getUserName(),
                        signupRequestDTO.getPassword()
                        );

              signupResponseDTO.setStatus(ResponseStatus.SUCCESS);
              signupResponseDTO.setUserId(user.getId());

          }
          catch(Exception e) {
                signupResponseDTO.setStatus(ResponseStatus.FAILURE);
          }

          return signupResponseDTO;
    }
}
