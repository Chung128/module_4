package com.example.thuc_hanh_quan_li_dien_thoai.service;

import com.example.thuc_hanh_quan_li_dien_thoai.model.SmartPhone;
import com.example.thuc_hanh_quan_li_dien_thoai.repository.ISmartPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SmartPhoneService implements ISmartPhoneService{
    private ISmartPhoneRepository smartPhoneRepository;

    @Autowired
    public SmartPhoneService(ISmartPhoneRepository smartPhoneRepository) {
        this.smartPhoneRepository = smartPhoneRepository;
    }

    @Override
    public List<SmartPhone> findAll() {
        return smartPhoneRepository.findAll();
    }

    @Override
    public Optional<SmartPhone> findById(Long id) {
        return smartPhoneRepository.findById(id);
    }

    @Override
    public void save(SmartPhone smartPhone) {
        smartPhoneRepository.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
        smartPhoneRepository.deleteById(id);
    }
}
