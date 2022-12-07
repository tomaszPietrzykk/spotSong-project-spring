package com.example.demo.mapper;

import com.example.demo.model.Author;
import com.example.demo.model.DTO.AuthorDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorDto toAuthorDto(Author author);

    List<AuthorDto> toAuthorsDto(List<Author> albums);
}
