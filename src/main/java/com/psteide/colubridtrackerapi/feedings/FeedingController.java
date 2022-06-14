package com.psteide.colubridtrackerapi.feedings;

import java.util.Map;
import java.util.HashMap;

import com.psteide.colubridtrackerapi.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping("api/feedings")
public class FeedingController {
    @Autowired
    private FeedingService feedingService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Iterable<Feeding>> list() {
        Iterable<Feeding> feedings = feedingService.list();
        return createHashPlural(feedings);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Feeding> read(@PathVariable Long id) {
        Feeding feeding = feedingService
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No resource with that ID"));
        return createHashSingular(feeding);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Feeding> create(@Validated @RequestBody Feeding feeding) {
        Feeding createdFeeding = feedingService.create(feeding);
        return createHashSingular(createdFeeding);
    }

    // @PostMapping("/{feedingId}/snakes/{snakeId}")
    // @ResponseStatus(HttpStatus.CREATED)
    // Feeding assignSnaketoFeeding(
    // @PathVariable long feedingId,
    // @PathVariable long snakeId) {
    // Feeding feeding = feedingService.findById(feedingId).get();
    // Snake snake = snakeService.findById(snakeId).get();
    // feeding.assignSnake(snake);
    // return feedingService.create(feeding);
    // }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Feeding> update(@RequestBody Feeding feeding, @PathVariable Long id) {
        Feeding updatedFeeding = feedingService
                .update(feeding)
                .orElseThrow(() -> new ResourceNotFoundException("No resource with that ID"));

        return createHashSingular(updatedFeeding);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        feedingService.deleteById(id);
    }

    private Map<String, Feeding> createHashSingular(Feeding feeding) {
        Map<String, Feeding> response = new HashMap<String, Feeding>();
        response.put("feeding", feeding);

        return response;
    }

    private Map<String, Iterable<Feeding>> createHashPlural(Iterable<Feeding> feedings) {
        Map<String, Iterable<Feeding>> response = new HashMap<String, Iterable<Feeding>>();
        response.put("feedings", feedings);

        return response;
    }
}