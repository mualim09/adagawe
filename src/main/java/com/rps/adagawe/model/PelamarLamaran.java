package com.rps.adagawe.model;

import javax.persistence.*;

@Entity
public class PelamarLamaran {
    @Id
    @Column(name = "id_lamaran")
    private int idLamaran;

    @ManyToOne
    @JoinColumn(name = "id_lowongan", updatable = false, insertable = false)
    private Lowongan lowongan;

    @ManyToOne
    @JoinColumn(name = "id_lamaran", updatable = false, insertable = false)
    private Lamaran lamaran;

    @Column(name = "id_pelamar")
    private int idPelamar;

    @ManyToOne
    @JoinColumn(name = "id_pelamar", updatable = false, insertable = false)
    private Pelamar pelamar;

    @Column(name = "status_lamaran")
    private int statusLamaran;

    public int getIdLamaran() {
        return idLamaran;
    }

    public void setIdLamaran(int idLamaran) {
        this.idLamaran = idLamaran;
    }

    public Lowongan getLowongan() {
        return lowongan;
    }

    public void setLowongan(Lowongan lowongan) {
        this.lowongan = lowongan;
    }

    public Lamaran getLamaran() {
        return lamaran;
    }

    public void setLamaran(Lamaran lamaran) {
        this.lamaran = lamaran;
    }

    public int getIdPelamar() {
        return idPelamar;
    }

    public void setIdPelamar(int idPelamar) {
        this.idPelamar = idPelamar;
    }

    public Pelamar getPelamar() {
        return pelamar;
    }

    public void setPelamar(Pelamar pelamar) {
        this.pelamar = pelamar;
    }

    public int getStatusLamaran() {
        return statusLamaran;
    }

    public void setStatusLamaran(int statusLamaran) {
        this.statusLamaran = statusLamaran;
    }
}
