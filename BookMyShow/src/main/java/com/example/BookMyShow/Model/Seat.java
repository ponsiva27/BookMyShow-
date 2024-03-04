package com.example.BookMyShow.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {

    private int seatNumber;
    @ManyToOne
    private SeatType seatType;
    private int columnValue;
    private int rowValue;


}
