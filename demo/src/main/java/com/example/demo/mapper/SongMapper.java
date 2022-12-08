package com.example.demo.mapper;

import com.example.demo.model.DTO.SongDto;
import com.example.demo.model.Song;


import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SongMapper {

    SongDto toSongDto(Song song);

    List<SongDto> toSongsDto(List<Song> songs);

}
