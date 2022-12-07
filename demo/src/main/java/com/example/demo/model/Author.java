package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Entity
@Getter
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private String nickName;
    @NotNull
    private LocalDate birthday;

    @NotNull
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Album> albums = new ArrayList<>();

    @NotNull
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Song> songs = new ArrayList<>();
}