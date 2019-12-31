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
        model.addAttribute(NoteOperation.ADD);
        return "todoNote";
    }
    @GetMapping(value="/delete-btn")
    public String deleteButton(){
        //here I have to somehow pass the id of the note, i think
        return "todo";
    }
    @GetMapping(value="/edit-btn")
    public String editButton(){

        return "todoNote";
    }
    @GetMapping(value="/submit-note")
    public String submitNote(@RequestParam String note, @RequestParam String colorSelect, Principal principal){
        User user = userRepository.findByUsername(principal.getName());
        //Note (NOTE, COLOR, USER)
        Note Nnote = new Note(note,
                colorSelect,
                userRepository.findByUsername(principal.getName()));

        user.addNotes(Nnote);
        noteRepository.save(Nnote);
        return "todo";
    }
}
