package com.krzosa.todo.notes.controllers;

import com.krzosa.todo.TodoContoller;
import com.krzosa.todo.login.User;
import com.krzosa.todo.notes.NoteOperation;
import com.krzosa.todo.notes.repositories.NoteQueries;
import com.krzosa.todo.notes.repositories.NoteRepository;
import com.krzosa.todo.login.UserRepository;
import com.krzosa.todo.notes.models.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelExtensionsKt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class NoteContoller {
    @Autowired
    NoteRepository noteRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    NoteQueries noteQueries;

    @GetMapping(value="/add-btn")
    public String addButton(){


        return "todoNote";
    }
    @PostMapping(value="/delete-btn")
    public String deleteButton(@RequestParam Integer id, Model model, Principal principal){
        noteRepository.deleteById(id);
        User user = userRepository.findByUsername(principal.getName());
        List<Note> currentUsersNotes = noteQueries.NotesFromUserId(user.getId());
        model.addAttribute(currentUsersNotes);
        return "/todo";
    }
    @GetMapping(value="/edit-btn")
    public String editButton(Model model){
        //todo delete enum and just send the id
        model.addAttribute(NoteOperation.EDIT);
        return "todoNote";
    }
    @GetMapping(value="/submit-note")
    public String submitNote(@RequestParam String note, @RequestParam String colorSelect, Principal principal){
        User user = userRepository.findByUsername(principal.getName());
        //Note (NOTE, COLOR, USER)
        Note Nnote = new Note(note,
                colorSelect,
                userRepository.findByUsername(principal.getName()));

        noteRepository.save(Nnote);
        return "todoNote";
    }
}
