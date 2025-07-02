package com.example.thuc_hanh_quan_li_dien_thoai.service;

import com.example.thuc_hanh_quan_li_dien_thoai.model.SmartPhone;

import java.util.List;
import java.util.Optional;

public interface ISmartPhoneService {
    List<SmartPhone> findAll();

    Optional<SmartPhone> findById(Long id);

    void save(SmartPhone smartPhone);

    void remove(Long id);
}
