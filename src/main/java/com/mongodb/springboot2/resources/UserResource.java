package com.mongodb.springboot2.resources;

import com.mongodb.springboot2.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity <List<User>> findAll() {
        User maria = new User("1", "Maria Brown", "maria@gmail.com");
        User alex = new User("2", "Alex Green", "alex@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria, alex));
        return ResponseEntity.ok().body(list);
    }
}
