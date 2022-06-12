package com.psteide.colubridtrackerapi.sheds;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShedService {
    @Autowired
    private ShedRepository shedRepository;

    public Iterable<Shed> list() {
        return shedRepository.findAll();
    }

    public Optional<Shed> findById(Long id) {
        return shedRepository.findById(id);
    }

    public Shed create(Shed shed) {
        return shedRepository.save(shed);
    }

    public Optional<Shed> update(Shed shed) {
        Optional<Shed> foundShed = shedRepository.findById(shed.getId());

        if (foundShed.isPresent()) {
            Shed updatedShed = foundShed.get();
            updatedShed.setDate(shed.getDate());
            updatedShed.setObservation(shed.getObservation());

            shedRepository.save(updatedShed);
            return Optional.of(updatedShed);
        } else {
            return Optional.empty();
        }
    }

    public void deleteById(Long id) {
        shedRepository.deleteById(id);
    }
}
