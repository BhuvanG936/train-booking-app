package com.srsvmj.train_booking_app.impl;

import com.srsvmj.train_booking_app.entity.Train;
import com.srsvmj.train_booking_app.repository.TrainRepository;
import com.srsvmj.train_booking_app.service.TrainService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainServiceImpl implements TrainService {

    private final TrainRepository trainRepository;

    public TrainServiceImpl(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }


    @Override
    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }

    @Override
    public Optional<Train> getTrainByNumber(Long id) {
        return trainRepository.findById(id);
    }

    /*@Override
    public Optional<Train> getTrainByName(String name) {
        return trainRepository.getTrainByName(name);
    }*/

    @Override
    public void addTrain(Train train) {
        trainRepository.save(train);
    }

    @Override
    public boolean updateTrain(Long id, Train train) {

        Optional<Train> trainOptional = trainRepository.findById(id);

        if(trainOptional.isPresent()){

            Train trainToUpdate = trainOptional.get();

            trainToUpdate.setId(train.getId());
            trainToUpdate.setCity(train.getCity());
            trainToUpdate.setMobile(train.getMobile());
            trainToUpdate.setEmail(train.getEmail());
            trainToUpdate.setAddress(train.getAddress());
            trainToUpdate.setNationality(train.getNationality());
            trainToUpdate.setPincode(train.getPincode());
            trainToUpdate.setState(train.getState());
            trainToUpdate.setBirthPreference(train.getBirthPreference());
            trainToUpdate.setPassengerAge(train.getPassengerAge());
            trainToUpdate.setPassengerName(train.getPassengerName());
            trainToUpdate.setPassengerGender(train.getPassengerGender());

            trainRepository.save(trainToUpdate);
            return  true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteTrainById(Long id) {
        if(trainRepository.existsById(id)){

            trainRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
