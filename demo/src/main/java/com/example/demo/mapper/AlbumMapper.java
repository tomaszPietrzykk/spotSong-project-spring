package com.example.demo.mapper;

import com.example.demo.model.Album;
import com.example.demo.model.DTO.AlbumDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AlbumMapper {

    AlbumDto toAlbumDto(Album album);

    List<AlbumDto> toAlbumsDto(List<Album> albums);

}
