package com.maxgrayer.jsonimporter.repositories;

import java.util.List;

import com.maxgrayer.jsonimporter.models.PersistedSong;

import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<PersistedSong, Integer> {
    List<PersistedSong> findByYear(int year);

    PersistedSong findById(int id);
}
