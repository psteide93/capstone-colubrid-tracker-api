package com.psteide.colubridtrackerapi.notes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    public Iterable<Note> list() {
        return noteRepository.findAll();
    }

    public Optional<Note> findById(Long id) {
        return noteRepository.findById(id);
    }

    public Note create(Note note) {
        return noteRepository.save(note);
    }

    public Optional<Note> update(Note note) {
        Optional<Note> foundNote = noteRepository.findById(note.getId());

        if (foundNote.isPresent()) {
            Note updatedNote = foundNote.get();
            updatedNote.setDate(note.getDate());
            updatedNote.setNote(note.getNote());

            noteRepository.save(updatedNote);
            return Optional.of(updatedNote);
        } else {
            return Optional.empty();
        }
    }

    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }
}
