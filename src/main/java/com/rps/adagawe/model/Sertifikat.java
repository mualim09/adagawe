package com.rps.adagawe.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Sertifikat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_pelamar", nullable = false)
    private Pelamar pelamar;

    @Column(name = "judul")
    private String judul;

    @Column(name = "no_sertifikat")
    private String noSertifikat;

    @NotNull
    @Column(name = "berlaku_mulai")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date berlakuMulai;

    @NotNull
    @Column(name = "berlaku_sampai")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date berlakuSampai;

    @NotEmpty
    @Column(name = "file_attachment")
    private String fileAttachment;

    @Column(name = "row_status")
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pelamar getPelamar() {
        return pelamar;
    }

    public void setPelamar(Pelamar pelamar) {
        this.pelamar = pelamar;
    }

    public String getNoSertifikat() {
        return noSertifikat;
    }

    public void setNoSertifikat(String noSertifikat) {
        this.noSertifikat = noSertifikat;
    }

    public Date getBerlakuMulai() {
        return berlakuMulai;
    }

    public void setBerlakuMulai(Date berlakuMulai) {
        this.berlakuMulai = berlakuMulai;
    }

    public Date getBerlakuSampai() {
        return berlakuSampai;
    }

    public void setBerlakuSampai(Date berlakuSampai) {
        this.berlakuSampai = berlakuSampai;
    }

    public String getFileAttachment() {
        return fileAttachment;
    }

    public void setFileAttachment(String fileAttachment) {
        this.fileAttachment = fileAttachment;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }
}