package com.example.demo.serviceimpl;

import com.example.demo.models.Patron;
import com.example.demo.repositories.PatronRepository;
import com.example.demo.service.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PatronServiceImpl implements PatronService {

    @Autowired
    PatronRepository patronRepository;

    @Override
    public List<Patron> findAllPatrons() {
        Iterable<Patron> patrons = patronRepository.findAll();
        return StreamSupport.stream(patrons.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Patron getPatronById(Long id) {
        Optional<Patron> patron = patronRepository.findById(id);
        if (patron.isPresent()) {
            return patron.get();
        } else {
            return null;
        }
    }

    @Override
    public Patron addPatron(Patron patron) {
        return patronRepository.save(patron);
    }

    @Override
    public Patron updatePatron(Long id, Patron patron) {
        patron.setId(id);
        return patronRepository.save(patron);
    }

    @Override
    public void deletePatron(Long id) {
        patronRepository.deleteById(id);
    }
}
