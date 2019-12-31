package com.krzosa.todo.notes.repositories;

import com.krzosa.todo.notes.models.Note;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface NoteQueries extends Repository<Note, Integer> {
    @Query("SELECT u FROM Note u where u.user.id = :#{#userId}")
    List<Note> NotesFromUserId(Integer userId);
}
