package com.movie.filmeNet.model.filmes;

import com.movie.filmeNet.model.filmes.DadosCadastroGenero;
import com.movie.filmeNet.model.filmes.Filmes;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="generos")
public class Generos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToMany(mappedBy = "genero")
    private List<Filmes> listaFilmes = new ArrayList<>();

    public Generos() {
    }
    public Generos(DadosCadastroGenero dados) {
        this.nome = dados.nome();
    }
    //Métodos
    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public List<Filmes> getListaFilmes() {
        return listaFilmes;
    }
}