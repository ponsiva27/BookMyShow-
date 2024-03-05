package com.example.BookMyShow.Service;

import com.example.BookMyShow.Exception.ShowNotFoundException;
import com.example.BookMyShow.Exception.UserNotFoundException;
import com.example.BookMyShow.Model.Booking;
import com.example.BookMyShow.Model.Show;
import com.example.BookMyShow.Model.User;
import com.example.BookMyShow.Repository.ShowRepository;
import com.example.BookMyShow.Repository.ShowSeatRepository;
import com.example.BookMyShow.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

        UserRepository userRepository;
        ShowRepository showRepository;

        ShowSeatRepository showSeatRepository;

        @Autowired
        public BookingService(UserRepository userRepository, ShowRepository showRepository, ShowSeatRepository showSeatRepository) {
            this.userRepository = userRepository;
            this.showRepository = showRepository;
            this.showSeatRepository = showSeatRepository;
        }


       public Booking bookMovie(long userId, long showId, List<Long> showSeatId) throws UserNotFoundException, ShowNotFoundException {


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
                    return null;

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


       }
}
