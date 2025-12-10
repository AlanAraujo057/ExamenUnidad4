package com.example.Examen4B.controller;

import com.example.Examen4B.ReportService.ProductReportAPI;
import com.example.Examen4B.dto.CreateReportDTO;
import com.example.Examen4B.model.Report;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reports")
public class ReportController   {

        private final ProductReportAPI service;

        public ReportController(ProductReportAPI service) {
            this.service = service;
        }
        @GetMapping
        public List<Report> list() {
            return service.findAll();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Object> getById(@PathVariable("id") Long id) {
            return service.findById(id)
                    .map(u -> ResponseEntity.ok((Object) u))
                    .orElse(
                            ResponseEntity.status(HttpStatus.NOT_FOUND)
                                    .body(Map.of("error", "Producto no encontrado"))
                    );
        }
        @PostMapping
        public ResponseEntity<Report> create(@RequestBody @Valid CreateReportDTO dto) {
            Report created = service.save(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        }
        @PutMapping("/{id}")
        public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody @Valid CreateReportDTO dto) {
            return service.update(id, dto)
                    .map(u -> ResponseEntity.ok((Object) u))
                    .orElse(
                            ResponseEntity.status(HttpStatus.NOT_FOUND)
                                    .body(Map.of("error", "Reporte no encontrado"))
                    );
        }
        @DeleteMapping("/{id}")
        public void delete(@PathVariable Long id) {
            service.delete(id);
        }
    }
