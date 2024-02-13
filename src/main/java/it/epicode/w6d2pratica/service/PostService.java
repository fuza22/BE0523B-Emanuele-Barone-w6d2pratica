package it.epicode.w6d2pratica.service;

import it.epicode.w6d2pratica.model.Autore;
import it.epicode.w6d2pratica.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PostService {

    private List<Post> posts = new ArrayList<>();

    @Autowired
    AutoreService autoreService;


    public List<Post> cercaTuttiIPost(){

        return posts;

    }


    public Post cercaPostPerId(int id) throws NoSuchElementException {

        Optional<Post> p = posts.stream().filter(post -> post.getId() == id).findAny();

        if(p.isPresent()){

            return p.get();

        }else{

            throw new NoSuchElementException("Post non presente");

        }

    }

    public void salvaPost(Post p) throws NoSuchElementException{

        if(p.getAutore() == null){

            throw new NoSuchElementException("Inserire un autore prima di proseguire");

        }else{

            posts.add(p);

        }

    }


    public Post aggiornaPost(int id, Post post) throws NoSuchElementException{

        Post p = cercaPostPerId(id);
        Autore a = autoreService.cercaAutorePerId(post.getAutore().getId());

        p.setAutore(post.getAutore());
        p.setCategoria(post.getCategoria());
        p.setContenuto(post.getContenuto());
        p.setTitolo(post.getTitolo());
        p.setTempoDiLettura(post.getTempoDiLettura());

        return p;


    }

    public void eliminaPost(int id) throws NoSuchElementException{

        Post p = cercaPostPerId(id);
        posts.remove(p);

    }


}
