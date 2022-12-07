package com.example.demo.model.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

/**
 * A DTO for the {@link com.example.demo.model.Author} entity
 */
@Data
public class AuthorDto implements Serializable {
    private final Long id;
    @NotNull
    private final String firstName;
    @NotNull
    private final String lastName;
    private final String nickName;
    @NotNull
    private final LocalDate birthday;
    @NotNull
    private final List<AlbumDto> albums;
    @NotNull
    private final List<SongDto> songs;

    /**
     * A DTO for the {@link com.example.demo.model.Album} entity
     */
    @Data
    public static class AlbumDto implements Serializable {
        private final Long id;
        @NotNull
        private final String name;
        @NotNull
        private final LocalDate releaseDate;
    }

    /**
     * A DTO for the {@link com.example.demo.model.Song} entity
     */
    @Data
    public static class SongDto implements Serializable {
        private final Long id;
        @NotNull
        private final String name;
        @NotNull
        private final Time durationTime;
        @NotNull
        private final String lyrics;
        @NotNull
        private final Integer views;
    }
}