package com.example.joblisting.controller;

import com.example.joblisting.repository.PostRepository;
import com.example.joblisting.model.Post;
import com.example.joblisting.repository.SearchRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PostController {

    @Autowired
    PostRepository repo;

    @Autowired
    SearchRepository srepo;

    @GetMapping("/")
    public void redirectToSwagger(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui/index.html");
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return repo.findAll();
    }

    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text){
        return srepo.findByText(text);
    }


    @PostMapping("/post")
    public Post addPost(@RequestBody Post post){
       return repo.save(post);
    }


}
