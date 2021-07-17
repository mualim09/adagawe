package com.rps.adagawe.model;

import javax.persistence.*;

@Entity
public class Percakapan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_pesan")
    private Integer idPesan;

    @ManyToOne
    @JoinColumn(name = "id_pesan", insertable = false, updatable = false)
    private Pesan pesan;

    @Column(name = "isi_pesan")
    private String isiPesan;

    private Integer dilihat;

    private Integer create_time;

    @Column(name = "role")
    private int role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdPesan() {
        return idPesan;
    }

    public void setIdPesan(Integer idPesan) {
        this.idPesan = idPesan;
    }

    public Pesan getPesan() {
        return pesan;
    }

    public void setPesan(Pesan pesan) {
        this.pesan = pesan;
    }

    public String getIsiPesan() {
        return isiPesan;
    }

    public void setIsiPesan(String isiPesan) {
        this.isiPesan = isiPesan;
    }

    public Integer getDilihat() {
        return dilihat;
    }

    public void setDilihat(Integer dilihat) {
        this.dilihat = dilihat;
    }

    public Integer getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Integer create_time) {
        this.create_time = create_time;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
