package com.example.demo.controllers;

import com.example.demo.models.Patron;
import com.example.demo.service.PatronService;
import com.example.demo.service.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patrons")
public class PatronController {

    @Autowired
    PatronService patronService;

    // GET /api/patrons
    @GetMapping
    public ResponseEntity<List<Patron>> getAllPatrons() {
        return ResponseEntity.ok(patronService.findAllPatrons());
    }

    // GET /api/patrons/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Patron> getPatronById(@PathVariable Long id) {
        Patron patron = patronService.getPatronById(id);
        if (patron != null) {
            return ResponseEntity.ok(patron);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST /api/patrons
    @PostMapping
    public ResponseEntity<Patron> createPatron(@RequestBody @Validated Patron patron) {
        return ResponseEntity.ok(patronService.addPatron(patron));
    }

    // PUT /api/patrons/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Patron> updatePatron(@PathVariable Long id, @RequestBody Patron patron) {
        return ResponseEntity.ok(patronService.updatePatron(id, patron));
    }

    // DELETE /api/patrons/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatron(@PathVariable Long id) {
        patronService.deletePatron(id);
        return ResponseEntity.noContent().build();
    }
}
