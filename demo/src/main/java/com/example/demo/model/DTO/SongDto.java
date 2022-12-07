package com.example.demo.model.DTO;

import com.example.demo.model.Album;
import com.example.demo.model.Author;
import com.example.demo.model.Song;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;

/**
 * A DTO for the {@link Song} entity
 */
@Data
public class SongDto implements Serializable {
    private final Long id;
    @NotBlank
    private final AlbumDto album;
    @NotBlank
    private final AuthorDto author;
    @NotBlank
    private final String name;
    @NotBlank
    private final Time durationTime;
    @NotBlank
    private final String lyrics;
    @NotBlank
    private final Integer views;

    /**
     * A DTO for the {@link Album} entity
     */
    @Data
    public static class AlbumDto implements Serializable {
        private final Long id;
        @NotBlank
        private final String name;
        @NotNull
        private final LocalDate releaseDate;
    }

    /**
     * A DTO for the {@link Author} entity
     */
    @Data
    public static class AuthorDto implements Serializable {
        private final Long id;
        @NotBlank
        private final String firstName;
        @NotBlank
        private final String lastName;
        private final String nickName;
        @NotNull
        private final LocalDate birthday;
    }
}