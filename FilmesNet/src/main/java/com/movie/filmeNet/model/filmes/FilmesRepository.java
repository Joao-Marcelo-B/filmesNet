package com.movie.filmeNet.model.filmes;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmesRepository extends JpaRepository<Filmes, Long> {
    List<Filmes> findByGenero_Id(Long id);
}
