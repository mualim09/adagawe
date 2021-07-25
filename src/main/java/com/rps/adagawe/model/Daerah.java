package com.rps.adagawe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Daerah {
    @Id
    private String kota;

    @Column(name = "jumlah_lowongan")
    private int jumlahLowongan;

    @Column(name = "jumlah_lamaran")
    private int jumlahLamaran;

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public int getJumlahLowongan() {
        return jumlahLowongan;
    }

    public void setJumlahLowongan(int jumlahLowongan) {
        this.jumlahLowongan = jumlahLowongan;
    }

    public int getJumlahLamaran() {
        return jumlahLamaran;
    }

    public void setJumlahLamaran(int jumlahLamaran) {
        this.jumlahLamaran = jumlahLamaran;
    }

    @Override
    public String toString() {
        return "Daerah{" +
                "kota='" + kota + '\'' +
                ", jumlahLowongan=" + jumlahLowongan +
                ", jumlahLamaran=" + jumlahLamaran +
                '}';
    }
}
