package com.rps.adagawe.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Pengalaman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_pelamar", nullable = false)
    private Pelamar pelamar;

    @ManyToOne
    @JoinColumn(name = "id_jabatan", nullable = false)
    private Jabatan jabatan;

    @ManyToOne
    @JoinColumn(name = "id_jenis_pegawai", nullable = false)
    private JenisPegawai jenisPegawai;

    @Column(name = "nama_perusahaan")
    private String namaPerusahaan;

    @Column(name = "mulai_kerja")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date mulaiKerja;

    @Column(name = "terakhir_kerja")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date terakhirKerja;

    private String deskripsi;

    @Column(name = "file_attachment")
    private String fileAttachment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public int getIdPelamar() {
//        return idPelamar;
//    }
//
//    public void setIdPelamar(int idPelamar) {
//        this.idPelamar = idPelamar;
//    }

    public Pelamar getPelamar() {
        return pelamar;
    }

    public void setPelamar(Pelamar pelamar) {
        this.pelamar = pelamar;
    }

//    public int getIdJabatan() {
//        return idJabatan;
//    }
//
//    public void setIdJabatan(int idJabatan) {
//        this.idJabatan = idJabatan;
//    }

    public Jabatan getJabatan() {
        return jabatan;
    }

    public void setJabatan(Jabatan jabatan) {
        this.jabatan = jabatan;
    }

//    public int getIdJenisPegawai() {
//        return idJenisPegawai;
//    }
//
//    public void setIdJenisPegawai(int idJenisPegawai) {
//        this.idJenisPegawai = idJenisPegawai;
//    }

    public JenisPegawai getJenisPegawai() {
        return jenisPegawai;
    }

    public void setJenisPegawai(JenisPegawai jenisPegawai) {
        this.jenisPegawai = jenisPegawai;
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }

    public void setNamaPerusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
    }

    public Date getMulaiKerja() {
        return mulaiKerja;
    }

    public void setMulaiKerja(Date mulaiKerja) {
        this.mulaiKerja = mulaiKerja;
    }

    public Date getTerakhirKerja() {
        return terakhirKerja;
    }

    public void setTerakhirKerja(Date terakhirKerja) {
        this.terakhirKerja = terakhirKerja;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getFileAttachment() {
        return fileAttachment;
    }

    public void setFileAttachment(String fileAttachment) {
        this.fileAttachment = fileAttachment;
    }

    @Override
    public String toString() {
        return "Pengalaman{" +
                "id=" + id +
                ", pelamar=" + pelamar +
                ", jabatan=" + jabatan +
                ", jenisPegawai=" + jenisPegawai +
                ", namaPerusahaan='" + namaPerusahaan + '\'' +
                ", mulaiKerja=" + mulaiKerja +
                ", terakhirKerja=" + terakhirKerja +
                ", deskripsi='" + deskripsi + '\'' +
                ", fileAttachment='" + fileAttachment + '\'' +
                '}';
    }
}
