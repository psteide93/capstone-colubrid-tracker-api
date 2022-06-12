package com.psteide.colubridtrackerapi.weights;

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
@RequestMapping("api/weights")
public class WeightController {
    @Autowired
    private WeightService weightService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Iterable<Weight>> list() {
        Iterable<Weight> weights = weightService.list();
        return createHashPlural(weights);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Weight> read(@PathVariable Long id) {
        Weight weight = weightService
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No resource with that ID"));
        return createHashSingular(weight);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Weight> create(@Validated @RequestBody Weight weight) {
        Weight createdWeight = weightService.create(weight);
        return createHashSingular(createdWeight);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Weight> update(@RequestBody Weight weight, @PathVariable Long id) {
        Weight updatedWeight = weightService
                .update(weight)
                .orElseThrow(() -> new ResourceNotFoundException("No resource with that ID"));

        return createHashSingular(updatedWeight);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        weightService.deleteById(id);
    }

    private Map<String, Weight> createHashSingular(Weight weight) {
        Map<String, Weight> response = new HashMap<String, Weight>();
        response.put("weight", weight);

        return response;
    }

    private Map<String, Iterable<Weight>> createHashPlural(Iterable<Weight> weights) {
        Map<String, Iterable<Weight>> response = new HashMap<String, Iterable<Weight>>();
        response.put("weights", weights);

        return response;
    }
}