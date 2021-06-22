package com.rps.adagawe.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Jenjang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Nama Jenjang wajib diisi.")
    @Column(name = "nama_jenjang")
    private String namaJenjang;

    @NotEmpty(message = "Deskripsi wajib diisi.")
    private String deskripsi;

    @NotEmpty(message = "Tingkatan Jenjang wajib diisi.")
    @Column(name = "tingkatan_jenjang")
    private Integer tingkatanJenjang;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaJenjang() {
        return namaJenjang;
    }

    public void setNamaJenjang(String namaJenjang) {
        this.namaJenjang = namaJenjang;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Integer getTingkatanJenjang() {
        return tingkatanJenjang;
    }

    public void setTingkatanJenjang(Integer tingkatanJenjang) {
        this.tingkatanJenjang = tingkatanJenjang;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
