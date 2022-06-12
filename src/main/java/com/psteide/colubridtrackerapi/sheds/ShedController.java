package com.psteide.colubridtrackerapi.sheds;

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
@RequestMapping("api/sheds")
public class ShedController {
    @Autowired
    private ShedService shedService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Iterable<Shed>> list() {
        Iterable<Shed> sheds = shedService.list();
        return createHashPlural(sheds);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Shed> read(@PathVariable Long id) {
        Shed shed = shedService
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No resource with that ID"));
        return createHashSingular(shed);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Shed> create(@Validated @RequestBody Shed shed) {
        Shed createdShed = shedService.create(shed);
        return createHashSingular(createdShed);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Shed> update(@RequestBody Shed shed, @PathVariable Long id) {
        Shed updatedShed = shedService
                .update(shed)
                .orElseThrow(() -> new ResourceNotFoundException("No resource with that ID"));

        return createHashSingular(updatedShed);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        shedService.deleteById(id);
    }

    private Map<String, Shed> createHashSingular(Shed shed) {
        Map<String, Shed> response = new HashMap<String, Shed>();
        response.put("shed", shed);

        return response;
    }

    private Map<String, Iterable<Shed>> createHashPlural(Iterable<Shed> sheds) {
        Map<String, Iterable<Shed>> response = new HashMap<String, Iterable<Shed>>();
        response.put("sheds", sheds);

        return response;
    }
}