package com.example.ung_dung_muon_sach.exception;

import org.apache.logging.log4j.util.Supplier;

public class BorrowCodeNotFoundSupplier implements Supplier<RuntimeException> {
    private final String code;

    public BorrowCodeNotFoundSupplier(String code) {
        this.code = code;
    }

    @Override
    public RuntimeException get() {
        return new IllegalArgumentException("Không tìm thấy mã mượn sách: " + code);
    }
}
