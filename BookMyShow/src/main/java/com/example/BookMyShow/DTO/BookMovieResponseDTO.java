package com.example.BookMyShow.DTO;

import com.example.BookMyShow.DTO.Enum.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookMovieResponseDTO {

    private long bookingId;
    private ResponseStatus status  ;

    private int amount;


}
