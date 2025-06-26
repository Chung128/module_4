package com.example.form_input.service;


import com.example.form_input.model.Use;
import com.example.form_input.repository.IUseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UseService implements IUseService{
    private IUseRepository useRepository;

    @Autowired
    public UseService(IUseRepository useRepository) {
        this.useRepository = useRepository;
    }

    @Override
    public Page<Use> findAll(Pageable pageable) {
        return useRepository.findAll(pageable);
    }

    @Override
    public void save(Use use) {
        useRepository.save(use);
    }

    @Override
    public Use findById(int id) {
        return useRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(int id) {
        useRepository.deleteById(id);
    }

    @Override
    public Page<Use> searchByName(String searchByName, Pageable pageable) {
        return useRepository.searchByName(searchByName,pageable);
    }
}
