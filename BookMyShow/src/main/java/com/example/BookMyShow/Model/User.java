package com.example.BookMyShow.Model;

import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;
import java.util.List;

@Getter
@Setter
@Entity
public class User extends  BaseModel{

    private String UserName;
    private String email;
    private String phoneNo;
    @OneToMany
    private List<Booking> bookings;

}
