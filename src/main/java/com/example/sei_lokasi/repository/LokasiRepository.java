package com.example.sei_lokasi.repository;


import com.example.sei_lokasi.model.Lokasi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LokasiRepository extends JpaRepository<Lokasi, Integer> {
}

