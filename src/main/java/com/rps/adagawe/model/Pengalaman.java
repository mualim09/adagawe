package com.rps.adagawe.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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

    @NotEmpty(message = "Nama perusahaan wajib diisi.")
    @Column(name = "nama_perusahaan")
    private String namaPerusahaan;

    @NotNull(message = "Mulai kerja wajib diisi.")
    @Column(name = "mulai_kerja")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date mulaiKerja;

    @NotNull(message = "Akhir kerja wajib diisi.")
    @Column(name = "terakhir_kerja")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date terakhirKerja;

    private String deskripsi;

    @Column(name = "file_attachment")
    private String fileAttachment;

    @Column(name = "row_status")
    private Integer rowStatus;

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

    public Jabatan getJabatan() {
        return jabatan;
    }

    public void setJabatan(Jabatan jabatan) {
        this.jabatan = jabatan;
    }

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

    public Integer getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(Integer rowStatus) {
        this.rowStatus = rowStatus;
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
                ", rowStatus='" + rowStatus + '\'' +
                '}';
    }
}
