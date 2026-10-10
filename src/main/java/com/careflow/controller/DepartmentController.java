package com.careflow.controller;

import com.careflow.entity.Department;
import com.careflow.repository.DepartmentRepository;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private final DepartmentRepository repository;
    public DepartmentController(DepartmentRepository repository) { this.repository=repository; }

    @GetMapping
    public List<Department> all() { return repository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Department> one(@PathVariable Long id) {
        return repository.findById(id).map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Department> create(@RequestBody Department value) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(value));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> update(@PathVariable Long id, @RequestBody Department value) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        value.setId(id); return ResponseEntity.ok(repository.save(value));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.deleteById(id); return ResponseEntity.noContent().build();
    }
}
