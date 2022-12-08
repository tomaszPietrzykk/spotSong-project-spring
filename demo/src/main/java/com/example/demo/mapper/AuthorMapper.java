package com.example.demo.mapper;

import com.example.demo.model.Author;
import com.example.demo.model.DTO.AuthorDto;


import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorDto toAuthorDto(Author author);

    List<AuthorDto> toAuthorsDto(List<Author> albums);
}
