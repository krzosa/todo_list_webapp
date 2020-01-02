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

@Controller
public class TodoBtnController {
    @Autowired
    TodoService todoService;

    @GetMapping(value="/add-btn")
    public String addButton(){
        return "todoNoteAdd";
    }
    @PostMapping(value="/delete-btn")
    public String deleteButton(@RequestParam Integer id, Model model, Principal principal){
        todoService.deleteNoteById(id);
        todoService.sendListOfTodosToHtmlTemplate(model, principal);
        return "todoList";
    }
    @GetMapping(value="/edit-btn")
    public String editButton(@RequestParam Integer id, Model model){
        todoService.findNoteByIdAndPassItsAttributesToHtmlTemplate(id, model);
        return "todoNoteEdit";
    }
    @GetMapping(value="/submit-note")
    public String submitNote(@RequestParam String note, @RequestParam String colorSelect, Principal principal){
        todoService.saveNote(note, colorSelect, principal);
        return "todoNoteAdd";
    }
    @GetMapping(value="/submit-note-edit")
    public String submitNoteEdit(@RequestParam Integer id, @RequestParam String note, @RequestParam String colorSelect, Principal principal, Model model){
        todoService.saveNote(note, colorSelect, principal);
        todoService.sendListOfTodosToHtmlTemplate(model, principal);
        return "todoList";
    }
}
