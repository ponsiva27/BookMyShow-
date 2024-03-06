package com.example.BookMyShow.Service;

import com.example.BookMyShow.Enum.BookingStatus;
import com.example.BookMyShow.Enum.ShowSeatStatus;
import com.example.BookMyShow.Exception.ShowNotFoundException;
import com.example.BookMyShow.Exception.ShowSeatNotAvailableException;
import com.example.BookMyShow.Exception.UserNotFoundException;
import com.example.BookMyShow.Model.Booking;
import com.example.BookMyShow.Model.Show;
import com.example.BookMyShow.Model.ShowSeat;
import com.example.BookMyShow.Model.User;
import com.example.BookMyShow.Repository.BookingRepository;
import com.example.BookMyShow.Repository.ShowRepository;
import com.example.BookMyShow.Repository.ShowSeatRepository;
import com.example.BookMyShow.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;

import java.io.Serializable;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

        UserRepository userRepository;
        ShowRepository showRepository;

        ShowSeatRepository showSeatRepository;

        BookingRepository bookingRepository;

        @Autowired
        public BookingService(UserRepository userRepository, ShowRepository showRepository,
                              ShowSeatRepository showSeatRepository, BookingRepository bookingRepository) {
            this.userRepository = userRepository;
            this.showRepository = showRepository;
            this.showSeatRepository = showSeatRepository;
            this.bookingRepository = bookingRepository;
        }


       public Booking bookMovie(long userId, long showId, List<Long> showSeatId) throws UserNotFoundException, ShowNotFoundException, ShowSeatNotAvailableException {


           ////3.  ------Start a transaction (take a lock) soft locking
           //1 . Get the user from the userID
           //2. Get the show from the ShowID

           //   get the ShowSeatObject from showseatIDs

           //4, check the status are available = AVAILABLE or Blocked after 15 mins
           //5. if showseat status not available , throw an error
           //6.  update the status to blocked and note the lockedAt time.
           //7. save the showseatObject to DB.

           //-------- End of transaction--------- (release the lock)
           //8. create a booking object and return to the controller.


                  //  Step1
                   Optional<User> userOptional =  userRepository.findById(userId);

                   if(userOptional.isEmpty()) {
                       throw new UserNotFoundException("Given User ID doesn't exist");
                   }
                   User user = userOptional.get();


                   // Step 2

                   Optional<Show> showOptional  =  showRepository.findById(showId);

                   if(showOptional.isEmpty()) {
                       throw new ShowNotFoundException("ShowID not found . Please Entry different Show ID");
                   }

                   Show bookedShow = showOptional.get();

                   //step 3
                 List<ShowSeat> showseats  =  showSeatRepository.findAllById(showSeatId);

                 //Step 4 & 5
                for(ShowSeat showseatsvalue : showseats) {
                    Date lockedAt = showseatsvalue.getLockedAt();
                    if(showseatsvalue.getStatus()== ShowSeatStatus.BOOKED  ||
                            (showseatsvalue.getStatus() == ShowSeatStatus.BLOCKED && Duration.between(new Date().toInstant(), lockedAt.toInstant()).toMinutes() <15)) {
                            throw new ShowSeatNotAvailableException("Selected seats not available at the moment,  Please retry again later");
                    }

                }

                // step 6
                // update the status of the available showseats to booked
                for(ShowSeat avialableshowSeat : showseats) {
                     avialableshowSeat.setStatus(ShowSeatStatus.BLOCKED);
                     avialableshowSeat.setLockedAt(new Date());
                }

                // Step 7
               List<ShowSeat> savedshowseats = showSeatRepository.saveAll(showseats);

                //Step 8

                Booking booking = new Booking();
                booking.setBookedAt(new Date());
                booking.setUser(user);
                booking.setShow(bookedShow);
                booking.setShowSeats(savedshowseats);
                booking.setStatus(BookingStatus.PENDING);
                booking.setAmount(0);
                booking.setPayments(new ArrayList<>());


                //When we store this object into DB , it will return back the object with Booking ID.
              Booking savedBooking =  bookingRepository.save(booking);

                return  savedBooking;
       }
}
