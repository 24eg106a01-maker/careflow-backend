package com.careflow.controller;

import com.careflow.entity.LaboratoryTest;
import com.careflow.repository.LaboratoryTestRepository;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/laboratory")
public class LaboratoryTestController {
    private final LaboratoryTestRepository repository;
    public LaboratoryTestController(LaboratoryTestRepository repository) { this.repository=repository; }

    @GetMapping
    public List<LaboratoryTest> all() { return repository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<LaboratoryTest> one(@PathVariable Long id) {
        return repository.findById(id).map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LaboratoryTest> create(@RequestBody LaboratoryTest value) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(value));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LaboratoryTest> update(@PathVariable Long id, @RequestBody LaboratoryTest value) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        value.setId(id); return ResponseEntity.ok(repository.save(value));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.deleteById(id); return ResponseEntity.noContent().build();
    }
}
