package com.example.demo.mapper;

import com.example.demo.model.DTO.SongDto;
import com.example.demo.model.Song;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SongMapper {

    SongDto toSongDto(Song song);

    List<SongDto> toSongsDto(List<Song> songs);

}
