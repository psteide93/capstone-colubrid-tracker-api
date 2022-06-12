package com.psteide.colubridtrackerapi.feedings;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedingService {
    @Autowired
    private FeedingRepository feedingRepository;

    public Iterable<Feeding> list() {
        return feedingRepository.findAll();
    }

    public Optional<Feeding> findById(Long id) {
        return feedingRepository.findById(id);
    }

    public Feeding create(Feeding feeding) {
        return feedingRepository.save(feeding);
    }

    public Optional<Feeding> update(Feeding feeding) {
        Optional<Feeding> foundFeeding = feedingRepository.findById(feeding.getId());

        if (foundFeeding.isPresent()) {
            Feeding updatedFeeding = foundFeeding.get();
            updatedFeeding.setDate(feeding.getDate());
            updatedFeeding.setItem(feeding.getItem());

            feedingRepository.save(updatedFeeding);
            return Optional.of(updatedFeeding);
        } else {
            return Optional.empty();
        }
    }

    public void deleteById(Long id) {
        feedingRepository.deleteById(id);
    }
}