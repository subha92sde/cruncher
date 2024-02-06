package com.cruncher.controller;

import com.cruncher.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieRestController {
    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/movie/get-all", method = RequestMethod.GET)
    public ResponseEntity<?> getAllMovies(Pageable pageable) {
        int pageNumber = pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        return movieService.getAllMovies(pageNumber,pageSize);
    }
}
