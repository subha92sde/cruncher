package com.cruncher.service;

import com.cruncher.dto.MovieResponseObjectDTO;
import com.cruncher.model.Movie;
import com.cruncher.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public ResponseEntity<?> getAllMovies(int pageNumber, int pageSize) {
        Page<Movie> movies;
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        try {
            movies = movieRepository.findAll(pageable);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getCause().getCause().getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (!movies.hasContent()) {
            return new ResponseEntity<>(movies.getContent(), HttpStatus.OK);
        }

        Page<MovieResponseObjectDTO> response = movies.map(entity -> {
            MovieResponseObjectDTO dto = MovieService.convertMovieToMovieResponseObjectDTO(entity);
            return dto;
        });
        return new ResponseEntity<>(response.getContent(), HttpStatus.OK);
    }

    private static MovieResponseObjectDTO convertMovieToMovieResponseObjectDTO(Movie entity) {
        MovieResponseObjectDTO dto = new MovieResponseObjectDTO();
        dto.setId(String.valueOf(entity.getId()));
        dto.setTitle(entity.getTitle());
        dto.setImdbRating(String.valueOf(entity.getImdbRating()));
        dto.setYearOfRelease(String.valueOf(entity.getYearOfRelease()));
        return dto;
    }
}
