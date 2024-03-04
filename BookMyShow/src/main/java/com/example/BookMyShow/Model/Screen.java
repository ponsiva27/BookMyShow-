package com.example.BookMyShow.Model;

import com.example.BookMyShow.Enum.Feature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen  extends BaseModel {

    private String name;
    @OneToMany
    private List<Seat> seats;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection   //to store a list of collection of enums
    private List<Feature> features;


}
