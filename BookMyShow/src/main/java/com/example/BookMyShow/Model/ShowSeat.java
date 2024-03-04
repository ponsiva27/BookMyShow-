package com.example.BookMyShow.Model;

import com.example.BookMyShow.Enum.ShowSeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends  BaseModel {

    @ManyToOne
    private Show Show;
    @ManyToOne
    private Seat seat;
    @Enumerated (EnumType.ORDINAL)
    private ShowSeatStatus status;


}
