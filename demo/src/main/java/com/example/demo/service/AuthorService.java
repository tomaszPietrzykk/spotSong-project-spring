package com.example.demo.service;

import com.example.demo.mapper.AuthorMapper;
import com.example.demo.model.Author;
import com.example.demo.model.DTO.AuthorDto;
import com.example.demo.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public List<AuthorDto> findAll(){
        List<Author> authors = StreamSupport.stream(authorRepository.findAll().spliterator(), false).toList();
        return authorMapper.toAuthorsDto(authors);
    }

    public AuthorDto findById(Long id){
        return authorMapper.toAuthorDto(authorRepository.findById(id).orElseThrow());
    }

    public void deleteById(Long id){
        authorRepository.deleteById(id);
    }

}
