package com.krzosa.todo.todo;

import com.krzosa.todo.user.UserEntity;
import com.krzosa.todo.user.UserRepository;
import com.krzosa.todo.note.NoteQueries;
import com.krzosa.todo.note.NoteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class TodoContoller {

    @Autowired
    UserRepository userRepository;

    @Autowired
    NoteQueries noteQueries;

    @GetMapping("/todo")
    public String PassingNotesListGet(Model model, Principal principal){
        UserEntity user = userRepository.findByUsername(principal.getName());
        List<NoteEntity> currentUsersNotes = noteQueries.NotesFromUserId(user.getId());
        model.addAttribute(currentUsersNotes);
        return "todoList";
    }
    @PostMapping("/todo")
    public String PassingNotesListPost(Model model, Principal principal){
        UserEntity user = userRepository.findByUsername(principal.getName());
        List<NoteEntity> currentUsersNotes = noteQueries.NotesFromUserId(user.getId());
        model.addAttribute(currentUsersNotes);
        return "todoList";
    }
}
