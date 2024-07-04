package com.srsvmj.train_booking_app.controller;

import com.srsvmj.train_booking_app.entity.Train;
import com.srsvmj.train_booking_app.repository.TrainRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.srsvmj.train_booking_app.service.TrainService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class TrainController {

    private final TrainService trainService;
    private final TrainRepository trainRepository;

    public TrainController(TrainService trainService, TrainRepository trainRepository) {
        this.trainService = trainService;
        this.trainRepository = trainRepository;
    }

    //1. GET, To Get all the trains, URL: http://localhost:8080/api/v1/trains
    @GetMapping("/trains")
    public List<Train> getAllTrains(){
        return trainService.getAllTrains();
    }

    //2. GET, To get train by id
    @GetMapping("/trains/{num}")
    public Optional<Train> getTrainByNumber(@PathVariable Long num){
        return trainService.getTrainByNumber(num);
    }

    //3. GET, To get the train by Name
  /*  @GetMapping("/trains/{name}")
    public Optional<Train> getTrainByName(@PathVariable("name") String name){
        return trainRepository.getTrainByName(name);
    }*/

    //4. To Add New Train
    @PostMapping("/trains")
    public ResponseEntity<String> addTrain(@RequestBody Train train){

        trainService.addTrain(train);

        return new ResponseEntity<>("Train Created Successfully", HttpStatus.CREATED);
    }

    //5. To Update the Train
    @PutMapping("/trains/{id}")
    public ResponseEntity<String> updateTrain(@PathVariable Long id, @RequestBody Train train){

        boolean isTrainUpdated = trainService.updateTrain(id, train);

        if (isTrainUpdated){
            return new ResponseEntity<>("Train Updated Successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Train Not Updated", HttpStatus.NOT_FOUND);
        }
    }

    //6. To Delete a Trian By id
    @DeleteMapping("/trains/{id}")
    public  ResponseEntity<String> deleteTrainById(@PathVariable Long id){

        boolean isTrainDeleted = trainService.deleteTrainById(id);

        if (isTrainDeleted){
            return new ResponseEntity<>("Train Deleted Successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Train Not Deleted", HttpStatus.NOT_FOUND);
        }
    }
}
