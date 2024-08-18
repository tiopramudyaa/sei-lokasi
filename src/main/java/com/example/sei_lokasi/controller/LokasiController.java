package com.example.sei_lokasi.controller;


import com.example.sei_lokasi.model.Lokasi;
import com.example.sei_lokasi.repository.LokasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lokasi")
public class LokasiController {

    @Autowired
    private LokasiRepository lokasiRepository;

    @GetMapping
    public List<Lokasi> getAllLokasi() {
        return lokasiRepository.findAll();
    }

    @PostMapping
    public Lokasi createLokasi(@RequestBody Lokasi lokasi) {
        return lokasiRepository.save(lokasi);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lokasi> getLokasiById(@PathVariable Integer id) {
        return lokasiRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lokasi> updateLokasi(@PathVariable Integer id, @RequestBody Lokasi lokasiDetails) {
        return lokasiRepository.findById(id)
                .map(lokasi -> {
                    lokasi.setNamaLokasi(lokasiDetails.getNamaLokasi());
                    lokasi.setNegara(lokasiDetails.getNegara());
                    lokasi.setProvinsi(lokasiDetails.getProvinsi());
                    lokasi.setKota(lokasiDetails.getKota());
                    return ResponseEntity.ok(lokasiRepository.save(lokasi));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteLokasi(@PathVariable Integer id) {
        return lokasiRepository.findById(id)
                .map(lokasi -> {
                    lokasiRepository.delete(lokasi);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

