package com.example.demo.service;

import com.example.demo.mapper.SongMapper;
import com.example.demo.model.Album;
import com.example.demo.model.Author;
import com.example.demo.model.DTO.SongDto;
import com.example.demo.model.DTO.SongRequest;
import com.example.demo.model.Song;
import com.example.demo.repository.AlbumRepository;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.SongRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class SongService {

    private final AlbumRepository albumRepository;
    private final AuthorRepository authorRepository;
    private final SongRepository songRepository;
    private final SongMapper songMapper;

    public List<SongDto> findAll() {
        List<Song> songs = StreamSupport.stream(songRepository.findAll().spliterator(), false).toList();
        return songMapper.toSongsDto(songs);
    }

    public SongDto findById(Long id) {
        return songMapper.toSongDto(songRepository.findById(id).orElseThrow());
    }

    public void deleteById(Long id) {
        songRepository.deleteById(id);
    }

    public void save(SongRequest songRequest) {
        Album album = albumRepository.findByName(songRequest.getAlbum());
        Author author = authorRepository.findByNickName(songRequest.getAuthor());
        Song song = createSong(songRequest, album, author);
        songRepository.save(song);
    }

    private Song createSong(SongRequest songRequest, Album album, Author author) {
        Song song = new Song();
        song.setId(10L);
        song.setAlbum(album);
        song.setAuthor(author);
        song.setName(songRequest.getSongName());
        song.setDurationTime(songRequest.getDuration());
        song.setLyrics(songRequest.getLyrics());
        song.setViews(0);
        return song;
    }

}
