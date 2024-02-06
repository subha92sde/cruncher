package com.cruncher.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieResponseObjectDTO {
    private String id;
    private String title;
    private String imdbRating;
    private String yearOfRelease;
}
