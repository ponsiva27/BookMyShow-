package com.example.BookMyShow.Model;
import com.example.BookMyShow.Enum.Feature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@Entity (name = "Shows")
public class Show extends BaseModel {

    @ManyToOne
    private Movie  movies;

    @ManyToOne
    private Screen screens;
    @Enumerated (EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> feature;
    private Date startAt;
    private Date endAt;

}
