package com.mongodb.springboot2.repository;

import com.mongodb.springboot2.domain.Post;
import org.springframework.data.mongodb.repository.*;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String text);

    List<Post> findByTitleContainingIgnoreCase(String text);


    @Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , "
            + "{ $or: [ { 'title': { $regex: ?0, $options: 'i' } }, "
            + "{ 'body': { $regex: ?0, $options: 'i' } }, "
            + "{ 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
