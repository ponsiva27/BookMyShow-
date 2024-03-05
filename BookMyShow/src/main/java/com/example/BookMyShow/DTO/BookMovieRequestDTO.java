package com.example.BookMyShow.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class BookMovieRequestDTO {

    private long userId;
    
    private long showId;

    private List<Long> showSeatId;

    
}
