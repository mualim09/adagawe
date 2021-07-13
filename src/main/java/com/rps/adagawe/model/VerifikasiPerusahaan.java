package com.rps.adagawe.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
public class VerifikasiPerusahaan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_perusahaan", nullable = false)
    private Perusahaan perusahaan;

    @NotEmpty(message = "NPWP wajib diisi.")
    @Column(name = "npwp")
    private String npwp;

    @Column(name = "tdp")
    private String tdp;

    @Column(name = "siu")
    private String siu;

    @Column(name = "hasil")
    private Integer hasil;

    @Column(name = "created_date")
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdDate;

    @Column(name = "last_modified")
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastModified;

    @Column(name = "diverifikasi_oleh")
    private String diverifikasiOleh;

    @Column(name = "komentar")
    private String komentar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Perusahaan getPerusahaan() {
        return perusahaan;
    }

    public void setPerusahaan(Perusahaan perusahaan) {
        this.perusahaan = perusahaan;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public String getTdp() {
        return tdp;
    }

    public void setTdp(String tdp) {
        this.tdp = tdp;
    }

    public String getSiu() {
        return siu;
    }

    public void setSiu(String siu) {
        this.siu = siu;
    }

    public Integer getHasil() {
        return hasil;
    }

    public void setHasil(Integer hasil) {
        this.hasil = hasil;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getDiverifikasiOleh() {
        return diverifikasiOleh;
    }

    public void setDiverifikasiOleh(String diverifikasiOleh) {
        this.diverifikasiOleh = diverifikasiOleh;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }
}
