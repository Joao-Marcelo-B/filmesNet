package com.movie.filmeNet.model.filmes;

import jakarta.persistence.*;

@Entity
@Table(name="filmes")
public class Filmes
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "idGenero")
    private Generos genero;

    public Filmes() {

    }

    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public Generos getGenero() {
        return genero;
    }
    public Filmes(CadastroFilme dados) {
        this.nome = dados.nome();
        this.genero = dados.genero();
    }

    public void atualizaDados(DadosAlteracaoFilme dados)
    {
        this.nome = dados.nome();
        this.genero = dados.genero();
    }
}