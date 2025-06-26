package com.example.thong_tin_bai_hat.service;

import com.example.thong_tin_bai_hat.model.Song;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    void save(Song song);

    Song findById(int id);
}
