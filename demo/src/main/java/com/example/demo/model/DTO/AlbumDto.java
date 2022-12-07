package com.example.demo.model.DTO;

import com.example.demo.model.Album;
import com.example.demo.model.Author;
import com.example.demo.model.Song;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

/**
 * A DTO for the {@link Album} entity
 */
@Data
public class AlbumDto implements Serializable {
    private final Long id;
    @NotNull
    private final String name;
    @NotNull
    private final LocalDate releaseDate;
    private final AuthorDto author;
    private final List<SongDto> songs;

    /**
     * A DTO for the {@link Author} entity
     */
    @Data
    public static class AuthorDto implements Serializable {
        private final Long id;
        @NotNull
        private final String firstName;
        @NotNull
        private final String lastName;
        private final String nickName;
        @NotNull
        private final LocalDate birthday;
    }

    /**
     * A DTO for the {@link Song} entity
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