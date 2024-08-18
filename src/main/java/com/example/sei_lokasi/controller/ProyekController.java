package com.example.sei_lokasi.controller;

import com.example.sei_lokasi.model.Proyek;
import com.example.sei_lokasi.repository.ProyekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyek")
public class ProyekController {

    @Autowired
    private ProyekRepository proyekRepository;

    @GetMapping
    public List<Proyek> getAllProyek() {
        return proyekRepository.findAll();
    }

    @PostMapping
    public Proyek createProyek(@RequestBody Proyek proyek) {
        return proyekRepository.save(proyek);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proyek> getProyekById(@PathVariable Integer id) {
        return proyekRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proyek> updateProyek(@PathVariable Integer id, @RequestBody Proyek proyekDetails) {
        return proyekRepository.findById(id)
                .map(proyek -> {
                    proyek.setNamaProyek(proyekDetails.getNamaProyek());
                    proyek.setClient(proyekDetails.getClient());
                    proyek.setTglMulai(proyekDetails.getTglMulai());
                    proyek.setTglSelesai(proyekDetails.getTglSelesai());
                    proyek.setPimpinanProyek(proyekDetails.getPimpinanProyek());
                    proyek.setKeterangan(proyekDetails.getKeterangan());
                    return ResponseEntity.ok(proyekRepository.save(proyek));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProyek(@PathVariable Integer id) {
        return proyekRepository.findById(id)
                .map(proyek -> {
                    proyekRepository.delete(proyek);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
