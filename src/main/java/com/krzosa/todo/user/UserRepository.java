package com.krzosa.todo.user;

import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<UserEntity, Integer> {
    UserEntity findByUsername(String username);
}
