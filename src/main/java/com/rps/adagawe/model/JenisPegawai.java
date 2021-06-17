package com.rps.adagawe.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "JenisPegawai")
public class JenisPegawai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name = "jenis_pegawai")
    private String jenisPegawai;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJenisPegawai() {
        return jenisPegawai;
    }

    public void setJenisPegawai(String jenisPegawai) {
        this.jenisPegawai = jenisPegawai;
    }

    @Override
    public String toString() {
        return "JenisPegawai{" +
                "id=" + id +
                ", jenisPegawai='" + jenisPegawai + '\'' +
                '}';
    }
}
