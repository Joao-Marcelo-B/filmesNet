package com.movie.filmeNet.controller;


import com.movie.filmeNet.model.filmes.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/filmes")
public class filmesController {

    @Autowired
    private FilmesRepository repository;
    @Autowired
    private GenerosRepository repositoryGenero;

    @GetMapping("/listagem")
    public String listaFilmes(Model model){
        model.addAttribute("lista", repository.findAll());
        return "/filmes/listagem";
    }

    @PostMapping("/formulario")
    public String cadastraFilme(CadastroFilme dados)
    {
        Filmes F1 = new Filmes(dados);
        repository.save(F1);
        return "redirect:/filmes/formulario";
    }

    @DeleteMapping
    @Transactional
    public String removeFilme(Long id) {
        repository.deleteById(id);
        return "redirect:/filmes/listagem";
    }

    @GetMapping("/formulario")
    public String carregaFormulario(Long id, Model model){
        if(id != null){
            Filmes F1 = repository.getReferenceById(id);
            model.addAttribute("filme", F1);
        }
        model.addAttribute("listaGenero", repositoryGenero.findAll());
        return "/filmes/formulario";
    }

    @PutMapping("/formulario")
    @Transactional
    public String alterarFilme(DadosAlteracaoFilme dados){
        Filmes filme = repository.getReferenceById((dados.id()));
        filme.atualizaDados(dados);
        repository.save(filme);
        return "redirect:/filmes/listagem";
    }
}
