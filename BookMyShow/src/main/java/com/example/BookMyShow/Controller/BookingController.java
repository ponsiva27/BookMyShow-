package com.example.BookMyShow.Controller;

import com.example.BookMyShow.DTO.BookMovieRequestDTO;
import com.example.BookMyShow.DTO.BookMovieResponseDTO;
import com.example.BookMyShow.DTO.Enum.ResponseStatus;
import com.example.BookMyShow.Enum.BookingStatus;
import com.example.BookMyShow.Model.Booking;
import com.example.BookMyShow.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class BookingController {


    private BookingService bookingService;

    @Autowired
    public BookingController (BookingService bookingService) {

        this.bookingService = bookingService;
    }

    public BookMovieResponseDTO bookMovie(BookMovieRequestDTO requestDTO) {

         //Creating a response Object
         BookMovieResponseDTO  responseDTO = new BookMovieResponseDTO();

         try {
             // booking service to pass the inputs to the bookMovie logic
             Booking booking = bookingService.bookMovie(
                     requestDTO.getUserId(),
                     requestDTO.getUserId(),
                     requestDTO.getShowSeatId());

             // adding the response to the responseDTO and finally returns it as a response object
             responseDTO.setBookingId(booking.getId());
             responseDTO.setStatus(ResponseStatus.SUCCESS);
             responseDTO.setAmount(booking.getAmount());
         }
            catch (Exception e ) {
             responseDTO.setStatus(ResponseStatus.FAILURE);
            }

         return responseDTO;

    }
}
