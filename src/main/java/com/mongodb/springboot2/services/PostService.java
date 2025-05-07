package com.mongodb.springboot2.services;

import com.mongodb.springboot2.domain.*;
import com.mongodb.springboot2.repository.*;
import com.mongodb.springboot2.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(()
                -> new ObjectNotFoundException("Object not found"));
    }
}
