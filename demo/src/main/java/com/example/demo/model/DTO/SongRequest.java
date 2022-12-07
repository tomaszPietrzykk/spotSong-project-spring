package com.example.demo.model.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Time;

@ToString
@Getter
@Setter
public class SongRequest {
    private String songName;
    private Time duration;
    private String author;
    private String album;
    private String lyrics;
}
