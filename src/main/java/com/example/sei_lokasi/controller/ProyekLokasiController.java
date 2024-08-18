package com.example.sei_lokasi.controller;


import com.example.sei_lokasi.model.ProyekLokasi;
import com.example.sei_lokasi.repository.ProyekLokasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/proyek-lokasi")
public class ProyekLokasiController {

    @Autowired
    private ProyekLokasiRepository proyekLokasiRepository;

    @GetMapping("/{id}")
    public ResponseEntity<ProyekLokasi> getProyekLokasiById(@PathVariable Integer id) {
        return proyekLokasiRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProyekLokasi createProyekLokasi(@RequestBody ProyekLokasi proyekLokasi) {
        return proyekLokasiRepository.save(proyekLokasi);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProyekLokasi> updateProyekLokasi(@PathVariable Integer id, @RequestBody ProyekLokasi proyekLokasiDetails) {
        return proyekLokasiRepository.findById(id)
                .map(proyekLokasi -> {
                    proyekLokasi.setProyek(proyekLokasiDetails.getProyek());
                    proyekLokasi.setLokasi(proyekLokasiDetails.getLokasi());
                    return ResponseEntity.ok(proyekLokasiRepository.save(proyekLokasi));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProyekLokasi(@PathVariable Integer id) {
        return proyekLokasiRepository.findById(id)
                .map(proyekLokasi -> {
                    proyekLokasiRepository.delete(proyekLokasi);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

