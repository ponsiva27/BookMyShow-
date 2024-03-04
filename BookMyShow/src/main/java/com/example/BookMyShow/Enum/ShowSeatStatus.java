package com.example.BookMyShow.Enum;

public enum ShowSeatStatus {
     BOOKED,
    AVAILABLE,
    BLOCKED //(Handle the concurrency when selecting a seats)

}
