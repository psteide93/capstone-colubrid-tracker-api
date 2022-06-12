package com.psteide.colubridtrackerapi.weights;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeightService {
    @Autowired
    private WeightRepository weightRepository;

    public Iterable<Weight> list() {
        return weightRepository.findAll();
    }

    public Optional<Weight> findById(Long id) {
        return weightRepository.findById(id);
    }

    public Weight create(Weight weight) {
        return weightRepository.save(weight);
    }

    public Optional<Weight> update(Weight weight) {
        Optional<Weight> foundWeight = weightRepository.findById(weight.getId());

        if (foundWeight.isPresent()) {
            Weight updatedWeight = foundWeight.get();
            updatedWeight.setDate(weight.getDate());
            updatedWeight.setWeight(weight.getWeight());

            weightRepository.save(updatedWeight);
            return Optional.of(updatedWeight);
        } else {
            return Optional.empty();
        }
    }

    public void deleteById(Long id) {
        weightRepository.deleteById(id);
    }
}
