package com.example.demo.service;

import com.example.demo.models.BorrowingRecord;

public interface BorrowingRecordService {

    public BorrowingRecord borrowBook(Long bookId, Long patronId);
    public BorrowingRecord returnBook(Long bookId, Long patronId);
}
