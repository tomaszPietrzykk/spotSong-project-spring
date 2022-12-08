package com.example.demo.model;



import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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