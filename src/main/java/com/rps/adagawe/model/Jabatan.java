package com.rps.adagawe.model;


import lombok.Builder;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Jabatan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Nama Jabatan wajib diisi.")
    @Column(name = "nama_jabatan")
    private String namaJabatan;

    @NotEmpty(message = "Deskripsi wajib diisi.")
    private String deskripsi;

    @Builder.Default
    @Column(name = "row_status")
    private Integer rowStatus = 1;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(Integer rowStatus) {
        this.rowStatus = rowStatus;
    }

    @Override
    public String toString() {
        return "Jabatan{" +
                "id=" + id +
                ", namaJabatan='" + namaJabatan + '\'' +
                ", deskripsi='" + deskripsi + '\'' +
                ", rowStatus='" + rowStatus + '\'' +
                '}';
    }
}
