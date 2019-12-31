package com.krzosa.todo.notes;

import com.krzosa.todo.login.User;
import com.krzosa.todo.login.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class NoteService {
    @Autowired
    UserRepository userRepository;

    public Integer FindIdFromPrincipal(Principal principal){
        User user = userRepository.findByUsername(principal.getName());
        return user.getId();
    }
}
