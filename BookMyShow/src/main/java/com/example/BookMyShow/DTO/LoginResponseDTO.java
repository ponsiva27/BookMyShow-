package com.example.BookMyShow.DTO;

import com.example.BookMyShow.DTO.Enum.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDTO {

    private long id;
    private ResponseStatus status;

}
