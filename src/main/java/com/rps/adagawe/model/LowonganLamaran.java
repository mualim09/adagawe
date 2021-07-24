package com.rps.adagawe.model;

import javax.persistence.*;

@Entity
public class LowonganLamaran {
    @Id
    @Column(name = "id")
    private int idLowongan;

    @Column(name = "jumlah_pelamar")
    private int jumlahPelamar;

    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Lowongan lowongan;

    public int getIdLowongan() {
        return idLowongan;
    }

    public void setIdLowongan(int idLowongan) {
        this.idLowongan = idLowongan;
    }

    public int getJumlahPelamar() {
        return jumlahPelamar;
    }

    public void setJumlahPelamar(int jumlahPelamar) {
        this.jumlahPelamar = jumlahPelamar;
    }

    public Lowongan getLowongan() {
        return lowongan;
    }

    public void setLowongan(Lowongan lowongan) {
        this.lowongan = lowongan;
    }
}
