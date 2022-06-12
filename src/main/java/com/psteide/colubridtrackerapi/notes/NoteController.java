package com.psteide.colubridtrackerapi.notes;

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
@RequestMapping("api/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Iterable<Note>> list() {
        Iterable<Note> notes = noteService.list();
        return createHashPlural(notes);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Note> read(@PathVariable Long id) {
        Note note = noteService
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No resource with that ID"));
        return createHashSingular(note);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Note> create(@Validated @RequestBody Note note) {
        Note createdNote = noteService.create(note);
        return createHashSingular(createdNote);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Note> update(@RequestBody Note note, @PathVariable Long id) {
        Note updatedNote = noteService
                .update(note)
                .orElseThrow(() -> new ResourceNotFoundException("No resource with that ID"));

        return createHashSingular(updatedNote);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        noteService.deleteById(id);
    }

    private Map<String, Note> createHashSingular(Note note) {
        Map<String, Note> response = new HashMap<String, Note>();
        response.put("note", note);

        return response;
    }

    private Map<String, Iterable<Note>> createHashPlural(Iterable<Note> notes) {
        Map<String, Iterable<Note>> response = new HashMap<String, Iterable<Note>>();
        response.put("notes", notes);

        return response;
    }
}