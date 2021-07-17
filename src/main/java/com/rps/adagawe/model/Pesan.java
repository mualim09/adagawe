package com.rps.adagawe.model;

import javax.persistence.*;

@Entity
public class Pesan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "pesan_dari")
    private Integer idPesanDari;

    @ManyToOne
    @JoinColumn(name = "pesan_dari", insertable = false, updatable = false)
    private UserLogin pesanDari;

    @Column(name = "pesan_untuk")
    private Integer idPesanUntuk;

    @ManyToOne
    @JoinColumn(name = "pesan_untuk", insertable = false, updatable = false)
    private UserLogin pesanUntuk;

    @Column(name = "pesan_terakhir")
    private String pesanTerakhir;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdPesanDari() {
        return idPesanDari;
    }

    public void setIdPesanDari(Integer idPesanDari) {
        this.idPesanDari = idPesanDari;
    }

    public UserLogin getPesanDari() {
        return pesanDari;
    }

    public void setPesanDari(UserLogin pesanDari) {
        this.pesanDari = pesanDari;
    }

    public Integer getIdPesanUntuk() {
        return idPesanUntuk;
    }

    public void setIdPesanUntuk(Integer idPesanUntuk) {
        this.idPesanUntuk = idPesanUntuk;
    }

    public UserLogin getPesanUntuk() {
        return pesanUntuk;
    }

    public void setPesanUntuk(UserLogin pesanUntuk) {
        this.pesanUntuk = pesanUntuk;
    }

}
