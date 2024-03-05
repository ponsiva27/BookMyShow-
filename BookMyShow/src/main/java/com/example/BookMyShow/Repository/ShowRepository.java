package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository <Show, Long> {


}
