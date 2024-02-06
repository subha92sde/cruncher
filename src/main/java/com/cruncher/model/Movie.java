package com.cruncher.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.Year;

@Entity
@Table(name = "tbl_movie", schema = "zoro")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", unique = true)
    @NotNull
    private String title;

    @Column(name = "imdb_rating")
    @NotNull
    private BigDecimal imdbRating;

    @Column(name = "year_of_release", columnDefinition = "smallint")
    @Convert(converter = YearAttributeConverter.class)
    @NotNull
    private Year yearOfRelease;
}
