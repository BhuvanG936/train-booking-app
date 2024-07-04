package com.srsvmj.train_booking_app.service;

import com.srsvmj.train_booking_app.entity.Train;
import com.srsvmj.train_booking_app.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public interface TrainService {

    List<Train> getAllTrains();

    Optional<Train> getTrainByNumber(Long id);

    void addTrain(Train train);

    boolean updateTrain(Long id, Train train);

    boolean deleteTrainById(Long id);

}
