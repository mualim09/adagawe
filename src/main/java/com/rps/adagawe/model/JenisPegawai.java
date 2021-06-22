package com.rps.adagawe.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class JenisPegawai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Nama Jenis Pegawai wajib diisi.")
    @Column(name = "jenis_pegawai")
    private String namajenisPegawai;

    @Column(name = "row_status")
    private Integer rowStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamajenisPegawai() {
        return namajenisPegawai;
    }

    public void setNamajenisPegawai(String jenisPegawai) {
        this.namajenisPegawai = jenisPegawai;
    }

    public Integer getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(Integer rowStatus) {
        this.rowStatus = rowStatus;
    }

    @Override
    public String toString() {
        return "JenisPegawai{" +
                "id=" + id +
                ", jenisPegawai='" + namajenisPegawai + '\'' +
                ", rowStatus='" + rowStatus + '\'' +
                '}';
    }
}
