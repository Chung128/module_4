package com.example.gia_vi_an_kem_voi_sandwich.service;

import org.springframework.stereotype.Service;

@Service
public class CondimentService implements ICondimentService {

    @Override
    public boolean validateCondiments(String[] condiments) {
        return condiments != null && condiments.length > 0;
    }
}
