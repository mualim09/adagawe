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
    @JoinColumn(name = "id_lowongan", nullable = false)
    private Lowongan lowongan;

    @Column(name = "tanggal_melamar")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tanggalMelamar;

    @Column(name = "pesan_pelamar")
    private String pesanPelamar;

    @Column(name = "resume")
    private String resume;

    @Column(name = "status_lamaran")
    private Integer statusLamaran;

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

    public Lowongan getLowongan() {
        return lowongan;
    }

    public void setLowongan(Lowongan lowongan) {
        this.lowongan = lowongan;
    }

    public Date getTanggalMelamar() {
        return tanggalMelamar;
    }

    public void setTanggalMelamar(Date tanggalMelamar) {
        this.tanggalMelamar = tanggalMelamar;
    }

    public String getPesanPelamar() {
        return pesanPelamar;
    }

    public void setPesanPelamar(String pesanPelamar) {
        this.pesanPelamar = pesanPelamar;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Integer getStatusLamaran() {
        return statusLamaran;
    }

    public void setStatusLamaran(Integer statusLamaran) {
        this.statusLamaran = statusLamaran;
    }

    @Override
    public String toString() {
        return "Lamaran{" +
                "id=" + id +
                ", pelamar=" + pelamar +
                ", lowongan=" + lowongan +
                ", tanggalMelamar=" + tanggalMelamar +
                ", pesanPelamar='" + pesanPelamar + '\'' +
                ", resume='" + resume + '\'' +
                ", statusLamaran=" + statusLamaran +
                '}';
    }
}
