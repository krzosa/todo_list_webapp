package com.krzosa.todo;

import com.krzosa.todo.login.User;
import com.krzosa.todo.login.UserRepository;
import com.krzosa.todo.notes.repositories.NoteQueries;
import com.krzosa.todo.notes.models.Note;
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
        User user = userRepository.findByUsername(principal.getName());
        List<Note> currentUsersNotes = noteQueries.NotesFromUserId(user.getId());


        model.addAttribute(currentUsersNotes);
        return "todo";
    }
    @PostMapping("/todo")
    public String PassingNotesListPost(Model model, Principal principal){
        User user = userRepository.findByUsername(principal.getName());
        List<Note> currentUsersNotes = noteQueries.NotesFromUserId(user.getId());

        model.addAttribute(currentUsersNotes);
        return "todo";
    }
}
