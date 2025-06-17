package com.example.tu_dien_anh_viet.service;

import com.example.tu_dien_anh_viet.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService {
    @Autowired
    private final DictionaryRepository repository;

    public DictionaryService(DictionaryRepository repository) {
        this.repository = repository;

    }
    public String translate(String word, String direction) {
        return repository.translate(word, direction);
    }
}
