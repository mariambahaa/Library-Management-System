package com.example.demo.repositories;

import com.example.demo.models.BorrowingRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BorrowingRecordRepository extends CrudRepository<BorrowingRecord, Long> {
    Optional<BorrowingRecord> findByBookAndPatron(Long bookId, Long patronId);
}
