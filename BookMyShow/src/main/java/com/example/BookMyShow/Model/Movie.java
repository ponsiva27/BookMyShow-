package com.example.BookMyShow.Model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;
@Getter
@Setter
@Entity
public class Movie  extends BaseModel{

    private String movieName;
    private String description;


}
