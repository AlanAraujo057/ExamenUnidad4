package com.example.Examen4B.ReportService;

import com.example.Examen4B.dto.CreateReportDTO;
import com.example.Examen4B.model.Report;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.*;

@Service
public class ProductReportAPI {

    private final Map<Long, Report> storage = new LinkedHashMap<Long,Report>();
    private final AtomicLong idGen= new AtomicLong(1);

    public ProductReportAPI(){
        save(new CreateReportDTO("Papas","el producto ya caduco", "10/12/2025"));
        save(new CreateReportDTO("Coca","el producto llego en malas condiciones", "10/12/2025"));
        save(new CreateReportDTO("Leche","el producto ya caduco", "10/12/2025"));
    }

    public Report save(CreateReportDTO dto) {
        Long id = idGen.getAndIncrement();
        Report u = new Report(id, dto.getNombre(), dto.getDescripcion(), dto.getFecha());
        storage.put(id, u);
        return u;
    }

    public Optional<Report> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public List<Report> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Optional<Report> update(Long id, CreateReportDTO dto) {
        Report existing = storage.get(id);
        if (existing == null) return Optional.empty();
        existing.setNombre(dto.getNombre());
        existing.setDescripcion(dto.getDescripcion());
        return Optional.of(existing);
    }
    public boolean delete(Long id) {
        return storage.remove(id) != null;
    }
}
