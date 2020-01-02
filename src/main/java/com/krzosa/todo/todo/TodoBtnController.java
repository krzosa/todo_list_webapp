package com.krzosa.todo.todo;

import com.krzosa.todo.note.NoteEntity;
import com.krzosa.todo.note.NoteQueries;
import com.krzosa.todo.note.NoteRepository;
import com.krzosa.todo.user.UserEntity;
import com.krzosa.todo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class TodoBtnController {
    @Autowired
    NoteRepository noteRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    NoteQueries noteQueries;

    @GetMapping(value="/add-btn")
    public String addButton(){
        return "todoNoteAdd";
    }
    @PostMapping(value="/delete-btn")
    public String deleteButton(@RequestParam Integer id, Model model, Principal principal){
        noteRepository.deleteById(id);
        UserEntity user = userRepository.findByUsername(principal.getName());
        List<NoteEntity> currentUsersNotes = noteQueries.NotesFromUserId(user.getId());
        model.addAttribute(currentUsersNotes);
        return "todoList";
    }
    @GetMapping(value="/edit-btn")
    public String editButton(@RequestParam Integer id, Model model){
        NoteEntity noteEdit = noteRepository.findById(id).get();
        model.addAttribute("NoteEdit", noteEdit);
        return "todoNoteEdit";
    }
    @GetMapping(value="/submit-note")
    public String submitNote(@RequestParam String note, @RequestParam String colorSelect, Principal principal){
        //Note (NOTE, COLOR, USER)
        NoteEntity nnote = new NoteEntity(note,
                colorSelect,
                userRepository.findByUsername(principal.getName()));

        noteRepository.save(nnote);
        return "todoNoteAdd";
    }
    @GetMapping(value="/submit-note-edit")
    public String submitNoteEdit(@RequestParam Integer id, @RequestParam String note, @RequestParam String colorSelect, Principal principal, Model model){
        //EDITING
        NoteEntity nnote = new NoteEntity(id, note, //Note (NOTE, COLOR, USER)
                colorSelect,
                userRepository.findByUsername(principal.getName()));
        noteRepository.save(nnote);

        //giving a list of all user's notes to html file
        UserEntity user = userRepository.findByUsername(principal.getName());
        List<NoteEntity> currentUsersNotes = noteQueries.NotesFromUserId(user.getId());
        model.addAttribute(currentUsersNotes);
        return "todoList";
    }
}
