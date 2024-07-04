package com.srsvmj.train_booking_app.repository;

import com.srsvmj.train_booking_app.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {

 //   Optional<Train> getTrainByName(String name);

}
