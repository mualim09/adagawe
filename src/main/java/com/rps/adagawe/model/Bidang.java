package com.rps.adagawe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bidang {
   @Id
   @Column(name = "nama_bidang")
   private String namaBidang;

   @Column(name = "jumlah_lowongan")
   private int jumlahLowongan;

   @Column(name = "jumlah_lamaran")
   private int jumlahLamaran;

    public String getNamaBidang() {
        return namaBidang;
    }

    public void setNamaBidang(String namaBidang) {
        this.namaBidang = namaBidang;
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
}
