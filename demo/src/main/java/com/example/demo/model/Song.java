package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Entity
@Setter
@Getter
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue()
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    @NotNull
    private String name;
    @NotNull
    private Time durationTime;
    @NotNull
    private String lyrics;
    @NotNull
    private Integer views;

}