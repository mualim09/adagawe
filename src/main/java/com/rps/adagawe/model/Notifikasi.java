package com.rps.adagawe.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Notifikasi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_lamaran")
    private int idLamaran;

    private String tahap;

    private int hasil;

    private String tahapSelanjutnya;

    @Column(name = "tanggal_tahapan")
    private Date tanggalTahapan;

    @Column(name = "created_date")
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "id_lamaran", insertable = false, updatable = false)
    private Lamaran lamaran;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdLamaran() {
        return idLamaran;
    }

    public void setIdLamaran(int idLamaran) {
        this.idLamaran = idLamaran;
    }

    public String getTahap() {
        return tahap;
    }

    public void setTahap(String tahap) {
        this.tahap = tahap;
    }

    public int getHasil() {
        return hasil;
    }

    public void setHasil(int hasil) {
        this.hasil = hasil;
    }

    public String getTahapSelanjutnya() {
        return tahapSelanjutnya;
    }

    public void setTahapSelanjutnya(String tahapSelanjutnya) {
        this.tahapSelanjutnya = tahapSelanjutnya;
    }

    public Date getTanggalTahapan() {
        return tanggalTahapan;
    }

    public void setTanggalTahapan(Date tanggalTahapan) {
        this.tanggalTahapan = tanggalTahapan;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Lamaran getLamaran() {
        return lamaran;
    }

    public void setLamaran(Lamaran lamaran) {
        this.lamaran = lamaran;
    }

    @Override
    public String toString() {
        return "Notifikasi{" +
                "id=" + id +
                ", idLamaran=" + idLamaran +
                ", tahap='" + tahap + '\'' +
                ", hasil=" + hasil +
                ", tahapSelanjutnya='" + tahapSelanjutnya + '\'' +
                ", tanggalTahapan=" + tanggalTahapan +
                ", createdDate=" + createdDate +
                ", lamaran=" + lamaran +
                '}';
    }
}
