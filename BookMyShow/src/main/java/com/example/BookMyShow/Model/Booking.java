package com.example.BookMyShow.Model;

import com.example.BookMyShow.Enum.BookingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends  BaseModel {

    @ManyToOne
    private User user;
    @ManyToOne
    private Show show;
    private Date bookedAt;
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus status;
    @OneToMany
    private List<Payment> payments;
    @ManyToMany
    private List<ShowSeat> showSeats;
    private int amount;


}
