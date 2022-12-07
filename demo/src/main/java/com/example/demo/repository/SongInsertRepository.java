package com.example.demo.repository;

import com.example.demo.model.Song;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class SongInsertRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertWithQuery(Song song){
        entityManager.createNativeQuery("INSERT INTO song (id, album_id, author_id, name, duration_time, lyrics, views) VALUES (?,?,?,?,?,?,?)")
                .setParameter(1, song.getId())
                .setParameter(2, song.getAlbum().getId())
                .setParameter(3, song.getAuthor().getId())
                .setParameter(4, song.getName())
                .setParameter(5, song.getDurationTime())
                .setParameter(6, song.getLyrics())
                .setParameter(7, song.getViews())
                .executeUpdate();
    }

}
