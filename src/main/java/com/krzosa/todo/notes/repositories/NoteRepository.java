package com.krzosa.todo.notes.repositories;

import com.krzosa.todo.notes.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Integer> {

}
