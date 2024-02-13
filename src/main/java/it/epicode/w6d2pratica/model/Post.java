package it.epicode.w6d2pratica.model;

import lombok.Data;

import java.util.Random;

@Data
public class Post {

    private int id = new Random().nextInt(1, Integer.MAX_VALUE);
    private String categoria;
    private String titolo;
    private Autore autore;
    private String cover;
    private String contenuto;
    private int tempoDiLettura;

}
