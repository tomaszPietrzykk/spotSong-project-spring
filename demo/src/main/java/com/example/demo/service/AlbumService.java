package com.example.demo.service;

import com.example.demo.mapper.AlbumMapper;
import com.example.demo.model.Album;
import com.example.demo.model.DTO.AlbumDto;
import com.example.demo.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class AlbumService {

    private final AlbumRepository albumRepository;

    private final AlbumMapper albumMapper;

    public List<AlbumDto> findAll(){
        List<Album> albums = StreamSupport.stream(albumRepository.findAll().spliterator(), false).toList();
        List<AlbumDto> albumDtos = albumMapper.toAlbumsDto(albums);
        return albumDtos;
    }

    public AlbumDto findById(Long id){
        return albumMapper.toAlbumDto(albumRepository.findById(id).orElseThrow());
    }

    public void deleteById(Long id){
        albumRepository.deleteById(id);
    }

}
