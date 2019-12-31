package com.krzosa.todo;

import com.krzosa.todo.login.User;
import com.krzosa.todo.login.UserRepository;
import com.krzosa.todo.notes.models.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class TodoContoller {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/todo")
    public String PassingNotesList(Model model, Principal principal){
        User user = userRepository.findByUsername(principal.getName());
        model.addAttribute(user.getNotes());
        return "todo";
    }
}
