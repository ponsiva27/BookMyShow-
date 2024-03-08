package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Model.Show;
import com.example.BookMyShow.Model.ShowSeat;
import com.example.BookMyShow.Model.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long> {

    List<ShowSeatType> findAllByShow(Show show);

}
