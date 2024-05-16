package com.cydeo.entity;

import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity //Create Table
@Data
@NoArgsConstructor
//I don't need to @AddTable to change name because I need to match the name from Data SQL
public class Movie extends BaseEntity {

    private String name;
    @Column(columnDefinition =  "DATE") //To show the type, if we don't assign it to db portion it will be string
    private LocalDate releaseDate;// ==>release_date
    private Integer duration;
    @Column(columnDefinition = "text")//To have more than 256 character
    private String summary;
    @Enumerated(EnumType.STRING)
    private MovieType type;
    @Enumerated(EnumType.STRING)
    private MovieState state;
    private BigDecimal price;
    @ManyToMany
    @JoinTable(name = "movie genre rel",//Modifying the table which is created by the Spring
    joinColumns = @JoinColumn (name = "movie_id"),//Modifying the column which is created by the Spring
    inverseJoinColumns = @JoinColumn (name = "genre_id"))//Modifying the other side of PK-column created by the Spring
    private List<Genre> genreList; //If it's @ManyToMany rel then we need to add list to it

    // We need constructor if we need to work with the repository and create obj from this class and save with the repo, rn for the data I'll just use the data SQL
}
