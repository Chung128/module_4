package com.example.thong_tin_bai_hat.service;


import com.example.thong_tin_bai_hat.model.Song;
import com.example.thong_tin_bai_hat.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {
    private ISongRepository songRepository;

    @Autowired
    public SongService(ISongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public Song findById(int id) {
        return songRepository.findById(id).orElse(null);
    }
}
