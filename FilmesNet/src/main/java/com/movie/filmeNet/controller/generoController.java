package com.movie.filmeNet.controller;

import com.movie.filmeNet.model.filmes.DadosCadastroGenero;
import com.movie.filmeNet.model.filmes.Generos;
import com.movie.filmeNet.model.filmes.GenerosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/generos")
public class generoController {
    @Autowired
    private GenerosRepository repository;
    @GetMapping("/formulario")
    public String carregaFormulario()
    {
        return "generos/formulario";
    }
    @PostMapping
    public String cadastraGenero(DadosCadastroGenero dados)
    {
        Generos g1 = new Generos(dados);
        repository.save(g1);
        return "generos/formulario";
    }
    @GetMapping("/listagem")
    public String carregaListagemGenero(Model model)
    {
        model.addAttribute("lista",repository.findAll());
        return "generos/listagem";
    }
}
