package it.epicode.w6d2pratica.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.Random;

@Data
public class Autore {


    public Autore(String nome, String cognome, String email, LocalDate dataDiNascita, String avatar) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.avatar = "https://ui-avatars.com/api/?name=" + nome + "+" + cognome;
    }

    private int id = new Random().nextInt(1, Integer.MAX_VALUE);
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private String avatar;

}
