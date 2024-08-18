package com.example.sei_lokasi.repository;

import com.example.sei_lokasi.model.ProyekLokasi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyekLokasiRepository extends JpaRepository<ProyekLokasi, Integer> {
}

