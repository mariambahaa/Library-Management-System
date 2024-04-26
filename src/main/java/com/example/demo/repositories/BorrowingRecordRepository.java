package com.example.demo.repositories;

import com.example.demo.models.BorrowingRecord;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BorrowingRecordRepository extends CrudRepository<BorrowingRecord, Long> {
    @Query("SELECT b FROM BorrowingRecord b WHERE b.book.id = :bookId AND b.patron.id = :patronId")
    Optional<BorrowingRecord> findByBookAndPatron(Long bookId, Long patronId);
}
