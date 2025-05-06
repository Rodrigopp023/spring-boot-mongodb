package com.mongodb.springboot2.resources;

import com.mongodb.springboot2.domain.User;
import com.mongodb.springboot2.dto.UserDTO;
import com.mongodb.springboot2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().
                map(x -> new UserDTO(x)).
                collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
}
