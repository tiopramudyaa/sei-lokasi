package com.example.sei_lokasi.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Lokasi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nama_lokasi")
    private String namaLokasi;

    private String negara;
    private String provinsi;
    private String kota;

    @OneToMany(mappedBy = "lokasi", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProyekLokasi> proyekLokasi = new HashSet<>();

    // Constructor
    public Lokasi() {}

    // Getter dan Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaLokasi() {
        return namaLokasi;
    }

    public void setNamaLokasi(String namaLokasi) {
        this.namaLokasi = namaLokasi;
    }

    public String getNegara() {
        return negara;
    }

    public void setNegara(String negara) {
        this.negara = negara;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public Set<ProyekLokasi> getProyekLokasi() {
        return proyekLokasi;
    }

    public void setProyekLokasi(Set<ProyekLokasi> proyekLokasi) {
        this.proyekLokasi = proyekLokasi;
    }
}

