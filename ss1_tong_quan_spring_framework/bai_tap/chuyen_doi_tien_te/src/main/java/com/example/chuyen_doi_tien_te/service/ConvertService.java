package com.example.chuyen_doi_tien_te.service;


import org.springframework.stereotype.Service;

@Service
public class ConvertService {
    private static final double USD_RATE = 25000.0;

    public double convertUsdToVnd(double usd) {
        return usd * USD_RATE;
    }
}
