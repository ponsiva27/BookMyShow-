package com.example.BookMyShow.Service;

import com.example.BookMyShow.Model.SeatType;
import com.example.BookMyShow.Model.Show;
import com.example.BookMyShow.Model.ShowSeat;
import com.example.BookMyShow.Model.ShowSeatType;
import com.example.BookMyShow.Repository.ShowSeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PriceCalculatorService {

    ShowSeatTypeRepository showSeatTypeRepository;
    @Autowired
    public PriceCalculatorService(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }
    public int calculatePrice(List<ShowSeat> showseats , Show show) {

        //Given the show, get the seatType and their corresponding price
        List<ShowSeatType>  savedShowSeatstype = showSeatTypeRepository.findAllByShow(show);


        //2. depends on the seattype , get the price
        int amount=0;
        for(ShowSeat selectedShowSeats : showseats) {
            SeatType selectedSeatType  = selectedShowSeats.getSeat().getSeatType();
            for(ShowSeatType dbshowSeattype : savedShowSeatstype ){
                if(dbshowSeattype.getSeatType()==selectedSeatType) {
                    amount = amount+dbshowSeattype.getPrice();
                    break;
                }
            }
        }

        return amount;
    }

// user selection of Showseats
    //showid  showtype
    //1        Gold
    //1        silver
    //3        silver

    //----- In DataBase--- showseatType Table
    //  ShowId ShowSeatType Price
    //   1      Gold         200
    //   1      Silver       150
    //   1      BRONZE       100
    //   2      Gold         150
    //   2      Silver       100
}
