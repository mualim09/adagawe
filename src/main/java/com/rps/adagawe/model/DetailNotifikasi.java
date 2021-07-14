package com.rps.adagawe.model;

import javax.persistence.*;

@Entity
public class DetailNotifikasi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_notifikasi")
    private int idNotifikasi;

    @Column(name = "id_pelamar")
    private int idPelamar;

    @ManyToOne
    @JoinColumn(name = "id_notifikasi", insertable = false, updatable = false)
    private Notifikasi notifikasi;

    @ManyToOne
    @JoinColumn(name = "id_pelamar", insertable = false, updatable = false)
    private Pelamar pelamar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdNotifikasi() {
        return idNotifikasi;
    }

    public void setIdNotifikasi(int idNotifikasi) {
        this.idNotifikasi = idNotifikasi;
    }

    public int getIdPelamar() {
        return idPelamar;
    }

    public void setIdPelamar(int idPelamar) {
        this.idPelamar = idPelamar;
    }

    public Notifikasi getNotifikasi() {
        return notifikasi;
    }

    public void setNotifikasi(Notifikasi notifikasi) {
        this.notifikasi = notifikasi;
    }

    public Pelamar getPelamar() {
        return pelamar;
    }

    public void setPelamar(Pelamar pelamar) {
        this.pelamar = pelamar;
    }
}
