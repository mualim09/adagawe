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

    private String isi;

    private String tahap;

    @Column(name = "tanggal_tahapan")
    private Date tanggalTahapan;

    @Column(name = "hasil_tahap_sebelumnya")
    private int hasilTahapSebelumnya;

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

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public String getTahap() {
        return tahap;
    }

    public void setTahap(String tahap) {
        this.tahap = tahap;
    }

    public Date getTanggalTahapan() {
        return tanggalTahapan;
    }

    public void setTanggalTahapan(Date tanggalTahapan) {
        this.tanggalTahapan = tanggalTahapan;
    }

    public int getHasilTahapSebelumnya() {
        return hasilTahapSebelumnya;
    }

    public void setHasilTahapSebelumnya(int hasilTahapSebelumnya) {
        this.hasilTahapSebelumnya = hasilTahapSebelumnya;
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
}
