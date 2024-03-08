package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /*public Optional<User> getUserByID(long userID) {
        return Optional.empty();
    }*/

     public Optional<User> findByEmail(String emailId);

}
