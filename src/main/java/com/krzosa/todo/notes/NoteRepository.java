package com.krzosa.todo.notes;

import com.krzosa.todo.notes.models.Note;
import org.springframework.data.repository.Repository;

public interface NoteRepository extends Repository<Note, Integer> {
}
