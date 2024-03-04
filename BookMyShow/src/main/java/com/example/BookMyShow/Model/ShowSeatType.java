package com.example.BookMyShow.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel {

    @ManyToOne
    private Show Show;
    @ManyToOne
    private Seat seat;
    private int price;

}
