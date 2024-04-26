package com.example.demo.service;

import com.example.demo.models.Patron;

import java.util.List;

public interface PatronService {

    public List<Patron> findAllPatrons();
    public Patron getPatronById(Long id);
    public Patron addPatron(Patron patron);
    public Patron updatePatron(Long id, Patron patron);
    public void deletePatron(Long id);
}
