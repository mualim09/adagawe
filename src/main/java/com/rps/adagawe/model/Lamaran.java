package com.rps.adagawe.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
public class Lamaran {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_pelamar", nullable = false)
    private Pelamar pelamar;

    @ManyToOne
    @JoinColumn(name = "id_perusahaan", nullable = false)
    private Perusahaan perusahaan;

    @Column(name = "tanggal_melamar")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tanggalMelamar;

    @NotEmpty(message = "Pesan wajib diisi.")
    @Column(name = "pesan_pelamar")
    private String pesan;

    @Column(name = "status_lamaran")
    private Integer statusLamaran;

    @Column(name = "telah_ditolak")
    private Integer telahDitolak;

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

    public Perusahaan getPerusahaan() {
        return perusahaan;
    }

    public void setPerusahaan(Perusahaan perusahaan) {
        this.perusahaan = perusahaan;
    }

    public Date getTanggalMelamar() {
        return tanggalMelamar;
    }

    public void setTanggalMelamar(Date tanggalMelamar) {
        this.tanggalMelamar = tanggalMelamar;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public Integer getStatusLamaran() {
        return statusLamaran;
    }

    public void setStatusLamaran(Integer statusLamaran) {
        this.statusLamaran = statusLamaran;
    }

    public Integer getTelahDitolak() {
        return telahDitolak;
    }

    public void setTelahDitolak(Integer telahDitolak) {
        this.telahDitolak = telahDitolak;
    }
}
