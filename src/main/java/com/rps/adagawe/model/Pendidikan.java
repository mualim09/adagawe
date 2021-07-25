package com.rps.adagawe.model;

import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Pendidikan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_pelamar", nullable = false)
    private Pelamar pelamar;

    @ManyToOne
    @JoinColumn(name = "id_jenjang", nullable = false)
    private Jenjang jenjang;

    @NotEmpty(message = "Nama Jurusan wajib diisi.")
    @Column(name = "nama_jurusan")
    private String namaJurusan;

    @NotEmpty(message = "Nama Universitas wajib diisi.")
    @Column(name = "nama_universitas")
    private String namaUniversitas;

    @NotNull(message = "Tahun Mulai wajib diisi.")
    @Column(name = "tahun_mulai")
    private String tahunMulai;

    @NotNull(message = "Tahun Selesai wajib diisi.")
    @Column(name = "tahun_selesai")
    private String tahunSelesai;

    @Builder.Default
    @Column(name = "row_status")
    private Integer rowStatus = 1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pelamar getPelamar() {
        return pelamar;
    }

    public void setPelamar(Pelamar pelamar) {
        this.pelamar = pelamar;
    }

    public Jenjang getJenjang() {
        return jenjang;
    }

    public void setJenjang(Jenjang jenjang) {
        this.jenjang = jenjang;
    }

    public String getNamaJurusan() {
        return namaJurusan;
    }

    public void setNamaJurusan(String namaJurusan) {
        this.namaJurusan = namaJurusan;
    }

    public String getNamaUniversitas() {
        return namaUniversitas;
    }

    public void setNamaUniversitas(String namaUniversitas) {
        this.namaUniversitas = namaUniversitas;
    }

    public String getTahunMulai() {
        return tahunMulai;
    }

    public void setTahunMulai(String tahunMulai) {
        this.tahunMulai = tahunMulai;
    }

    public String getTahunSelesai() {
        return tahunSelesai;
    }

    public void setTahunSelesai(String tahunSelesai) {
        this.tahunSelesai = tahunSelesai;
    }

    public Integer getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(Integer rowStatus) {
        this.rowStatus = rowStatus;
    }

    @Override
    public String toString() {
        return "Pendidikan{" +
                "id=" + id +
                ", pelamar=" + pelamar +
                ", jenjang=" + jenjang +
                ", namaJurusan=" + namaJurusan +
                ", namaUniversitas='" + namaUniversitas + '\'' +
                ", tahunMulai=" + tahunMulai +
                ", tahunSelesai=" + tahunSelesai +
                ", rowStatus='" + rowStatus + '\'' +
                '}';
    }
}
