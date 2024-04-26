package com.example.demo.serviceimpl;

import com.example.demo.models.Book;
import com.example.demo.models.BorrowingRecord;
import com.example.demo.models.Patron;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.BorrowingRecordRepository;
import com.example.demo.repositories.PatronRepository;
import com.example.demo.service.BorrowingRecordService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BorrowingRecordServiceImpl implements BorrowingRecordService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    PatronRepository patronRepository;
    @Autowired
    BorrowingRecordRepository borrowingRecordRepository;

    @Override
    @Transactional
    public BorrowingRecord borrowBook(Long bookId, Long patronId) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        Patron patron = patronRepository.findById(patronId).orElseThrow();
        BorrowingRecord borrowingRecord = new BorrowingRecord(book, patron, LocalDate.now(), null);
        return borrowingRecordRepository.save(borrowingRecord);
    }

    @Override
    @Transactional
    public BorrowingRecord returnBook(Long bookId, Long patronId) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        Patron patron = patronRepository.findById(patronId).orElseThrow();
        BorrowingRecord borrowingRecord = borrowingRecordRepository.findByBookAndPatron(bookId, patronId).orElseThrow();
        borrowingRecord.setReturnDate(LocalDate.now());
        return borrowingRecordRepository.save(borrowingRecord);
    }
}
