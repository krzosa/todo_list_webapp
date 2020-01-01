package com.krzosa.todo.notes.controllers;

import com.krzosa.todo.login.User;
import com.krzosa.todo.notes.repositories.NoteQueries;
import com.krzosa.todo.notes.repositories.NoteRepository;
import com.krzosa.todo.login.UserRepository;
import com.krzosa.todo.notes.models.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String editButton(@RequestParam Integer id, Model model){
        Note noteEdit = noteRepository.findById(id).get();

        model.addAttribute("NoteEdit", noteEdit);
        return "todoNoteEdit";
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
    @GetMapping(value="/submit-note-edit")
    public String submitNoteEdit(@RequestParam Integer id, @RequestParam String note, @RequestParam String colorSelect, Principal principal, Model model){
        //EDITING
        User user = userRepository.findByUsername(principal.getName());
        Note Nnote = new Note(id, note, //Note (NOTE, COLOR, USER)
                colorSelect,
                userRepository.findByUsername(principal.getName()));
        noteRepository.save(Nnote);

        //giving todo.html a list of all the notes of the current user
        user = userRepository.findByUsername(principal.getName());
        List<Note> currentUsersNotes = noteQueries.NotesFromUserId(user.getId());
        model.addAttribute(currentUsersNotes);
        return "todo";
    }
}
