package com.example.sei_lokasi.model;

import jakarta.persistence.*;

@Entity
public class ProyekLokasi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proyek_id")
    private Proyek proyek;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lokasi_id")
    private Lokasi lokasi;

    // Constructor
    public ProyekLokasi() {}

    // Getter dan Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Proyek getProyek() {
        return proyek;
    }

    public void setProyek(Proyek proyek) {
        this.proyek = proyek;
    }

    public Lokasi getLokasi() {
        return lokasi;
    }

    public void setLokasi(Lokasi lokasi) {
        this.lokasi = lokasi;
    }
}

