package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.exception.BorrowCodeNotFoundSupplier;
import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.model.BorrowCode;
import com.example.ung_dung_muon_sach.repository.IBorrowCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BorrowCodeService implements IBorrowCodeService {
    private IBookService bookService;
    private IBorrowCodeRepository borrowCodeRepository;

    @Autowired
    public BorrowCodeService(IBookService bookService, IBorrowCodeRepository borrowCodeRepository) {
        this.bookService = bookService;
        this.borrowCodeRepository = borrowCodeRepository;
    }

    @Override
    public List<BorrowCode> findAll() {
        return borrowCodeRepository.findAll();
    }

    @Override
    public void save(BorrowCode song) {
        borrowCodeRepository.save(song);
    }

    @Override
    public BorrowCode findById(int id) {
        return borrowCodeRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(int id) {
        borrowCodeRepository.deleteById(id);
    }

    @Override
    public BorrowCode borrowBook(int bookId) {
        Book book = bookService.findById(bookId);
        if (book.getNumber() <= 0) {
            throw new IllegalStateException("Sách đã hết.");
        }

        book.setNumber(book.getNumber() - 1);
        bookService.save(book);

        BorrowCode code = new BorrowCode();
        code.setCode(generateRandomCode());
        code.setBook(book);
        code.setReturned(false);
        return borrowCodeRepository.save(code);
    }

    @Override
    public void returnBook(String code) {
        BorrowCode borrowCode = borrowCodeRepository.findByCode(code)
                .orElseThrow(new BorrowCodeNotFoundSupplier(code)); //  KHÔNG cần dùng `->`

        if (!borrowCode.isReturned()) {
            Book book = borrowCode.getBook();
            book.setNumber(book.getNumber() + 1);
            bookService.save(book);

            borrowCode.setReturned(true);
            borrowCodeRepository.delete(borrowCode);
        }
    }

    private String generateRandomCode() {
        return String.format("%05d", new Random().nextInt(100000));
    }
}
