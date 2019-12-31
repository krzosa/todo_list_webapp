package com.krzosa.todo.notes.controllers;

import com.krzosa.todo.notes.NoteOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoteContoller {
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
    public String submitNote(){

        return "todo";
    }
}
