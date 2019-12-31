package com.krzosa.todo.notes.controllers;

import com.krzosa.todo.login.User;
import com.krzosa.todo.notes.NoteOperation;
import com.krzosa.todo.notes.NoteRepository;
import com.krzosa.todo.login.UserRepository;
import com.krzosa.todo.notes.models.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class NoteContoller {
    @Autowired
    NoteRepository noteRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping(value="/add-btn")
    public String addButton(Model model){

        return "todoNote";
    }
    //todo: delete error
    @PostMapping(value="/delete-btn")
    public String deleteButton(@RequestParam Integer id, Principal principal){
        User user = userRepository.findByUsername(principal.getName());

        noteRepository.deleteById(id);
        return "todo";
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

        user.addNote(Nnote);
        noteRepository.save(Nnote);
        return "todoNote";
    }
}
