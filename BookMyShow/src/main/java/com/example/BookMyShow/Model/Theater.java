package com.example.BookMyShow.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@Entity
public class Theater  extends BaseModel{

    private String name;
    @OneToMany
    private List<Screen> screen;
    @ManyToOne
    private Region region;

}
