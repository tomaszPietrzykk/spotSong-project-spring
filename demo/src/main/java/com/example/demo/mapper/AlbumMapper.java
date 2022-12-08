package com.example.demo.mapper;

import com.example.demo.model.Album;
import com.example.demo.model.DTO.AlbumDto;


import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlbumMapper {

    AlbumDto toAlbumDto(Album album);

    List<AlbumDto> toAlbumsDto(List<Album> albums);

}
