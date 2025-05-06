package com.mongodb.springboot2.services;

import com.mongodb.springboot2.domain.User;
import com.mongodb.springboot2.repository.UserRepository;
import com.mongodb.springboot2.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(()
                -> new ObjectNotFoundException("Object not found"));
    }
}
