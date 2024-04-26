package com.example.demo.repositories;

import com.example.demo.models.Patron;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatronRepository extends CrudRepository<Patron, Long> {
}
