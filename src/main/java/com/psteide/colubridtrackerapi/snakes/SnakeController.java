package com.psteide.colubridtrackerapi.snakes;

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
@RequestMapping("api/snakes")
public class SnakeController {
    @Autowired
    private SnakeService snakeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Iterable<Snake>> list() {
        Iterable<Snake> snakes = snakeService.list();
        return createHashPlural(snakes);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Snake> read(@PathVariable Long id) {
        Snake snake = snakeService
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No snake with that ID"));
        return createHashSingular(snake);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Snake> create(@Validated @RequestBody Snake snake) {
        Snake createdResource = snakeService.create(snake);
        return createHashSingular(createdResource);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Snake> update(@RequestBody Snake snake, @PathVariable Long id) {
        Snake updatedResource = snakeService
                .update(snake)
                .orElseThrow(() -> new ResourceNotFoundException("No snake with that ID"));

        return createHashSingular(updatedResource);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        snakeService.deleteById(id);
    }

    private Map<String, Snake> createHashSingular(Snake snake) {
        Map<String, Snake> response = new HashMap<String, Snake>();
        response.put("snake", snake);

        return response;
    }

    private Map<String, Iterable<Snake>> createHashPlural(Iterable<Snake> snakes) {
        Map<String, Iterable<Snake>> response = new HashMap<String, Iterable<Snake>>();
        response.put("snakes", snakes);

        return response;
    }
}