package it.epicode.w6d2pratica.controller;

import it.epicode.w6d2pratica.model.Post;
import it.epicode.w6d2pratica.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("")
    public List<Post> getAll(){

        return postService.cercaTuttiIPost();

    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable int id){

        return postService.cercaPostPerId(id);

    }

    @PostMapping("")
    public void savePost(@RequestBody Post post){

        postService.salvaPost(post);

    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable int id, @RequestBody Post p){

        return postService.aggiornaPost(id, p);

    }


    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable int id){

        postService.eliminaPost(id);

    }


}
