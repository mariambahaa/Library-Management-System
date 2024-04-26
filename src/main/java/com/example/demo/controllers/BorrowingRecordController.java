package com.example.demo.controllers;

import com.example.demo.models.BorrowingRecord;
import com.example.demo.service.BorrowingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BorrowingRecordController {

    @Autowired
    BorrowingRecordService borrowingRecordService;

    @PostMapping("/borrow/{bookId}/patron/{patronId}")
    public ResponseEntity<BorrowingRecord> borrowBook(@PathVariable Long bookId, @PathVariable Long patronId){
        return ResponseEntity.ok(borrowingRecordService.borrowBook(bookId, patronId));
    }

    @PutMapping("/return/{bookId}/patron/{patronId}")
    public ResponseEntity<BorrowingRecord> returnBook(@PathVariable Long bookId, @PathVariable Long patronId){
        return ResponseEntity.ok(borrowingRecordService.returnBook(bookId, patronId));
    }
}
