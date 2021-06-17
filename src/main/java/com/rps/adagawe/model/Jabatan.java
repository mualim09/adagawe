package com.rps.adagawe.model;

import javax.persistence.*;

@Entity
public class Jabatan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nama_jabatan")
    private String namaJabatan;

    private String deskripsi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaJabatan() {
        return namaJabatan;
    }

    public void setNamaJabatan(String namaJabatan) {
        this.namaJabatan = namaJabatan;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    @Override
    public String toString() {
        return "Jabatan{" +
                "id=" + id +
                ", namaJabatan='" + namaJabatan + '\'' +
                ", deskripsi='" + deskripsi + '\'' +
                '}';
    }
}
