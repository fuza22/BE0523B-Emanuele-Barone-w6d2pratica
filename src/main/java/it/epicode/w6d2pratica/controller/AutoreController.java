package it.epicode.w6d2pratica.controller;

import it.epicode.w6d2pratica.model.Autore;
import it.epicode.w6d2pratica.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autore")
public class AutoreController {

    @Autowired
    AutoreService autoreService;

    @GetMapping("")
    public List<Autore> getAll(){

        return autoreService.cercaTuttiGliAutori();

    }


    @GetMapping("/{id}")
    public Autore getAutoreById(@PathVariable int id){

        return autoreService.cercaAutorePerId(id);

    }

    @PostMapping("")
    public void saveAutore(@RequestBody Autore autore){

        autoreService.salvaAutore(autore);

    }

    @PutMapping("/{id}")
    public Autore updateAutore(@PathVariable int id, @RequestBody Autore autore){

        return autoreService.aggiornaAutore(id, autore);

    }

    @DeleteMapping("/{id}")
    public void deleteAutore(@PathVariable int id){

        autoreService.eliminaAutore(id);

    }


}
