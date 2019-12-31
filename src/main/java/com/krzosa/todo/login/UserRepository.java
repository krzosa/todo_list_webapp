package com.krzosa.todo.login;

import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, Integer> {
    User findByUsername(String username);
}
