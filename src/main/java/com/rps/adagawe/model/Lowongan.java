package com.rps.adagawe.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Lowongan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_perusahaan")
    private Integer idPerusahaan;

    @ManyToOne
    @JoinColumn(name = "id_perusahaan", insertable = false, updatable = false)
    private Perusahaan perusahaan;

    @NotNull(message = "Jenis pegawai wajib diisi.")
    @Column(name = "id_jenis_pegawai")
    private Integer idJenisPegawai;

    @ManyToOne
    @JoinColumn(name = "id_jenis_pegawai", insertable = false, updatable = false)
    private JenisPegawai jenisPegawai;

    @NotEmpty(message = "Judul Lowongan wajib diisi.")
    @Column(name = "judul_lowongan")
    private String judulLowongan;

    @NotEmpty(message = "Keterangan wajib diisi.")
    @Column(name = "keterangan")
    private String keterangan;

    @NotNull(message = "Jenjang minimal wajib diisi.")
    @Column(name = "jenjang_minimal")
    private Integer jenjangMinimal;

    @NotNull(message = "Gaji Minimal wajib diisi.")
    @Column(name = "gaji_minimal")
    private int gajiMinimal;

    @NotNull(message = "Gaji Maksimal wajib diisi.")
    @Column(name = "gaji_maksimal")
    private int gajiMaksimal;

    @NotEmpty(message = "Pengalaman kerja wajib diisi.")
    @Column(name = "pengalaman_kerja")
    private String pengalamanKerja;

    @NotEmpty(message = "Keahlian wajib diisi.")
    private String keahlian;

    @Column(name = "sembunyikan_gaji")
    private int sembunyikanGaji;

    private int status;

    @Column(name = "created_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdDate;

    @Column(name = "last_modified")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastModified;

    public Integer getIdJenisPegawai() {
        return idJenisPegawai;
    }

    public void setIdJenisPegawai(Integer idJenisPegawai) {
        this.idJenisPegawai = idJenisPegawai;
    }

    public Integer getJenjangMinimal() {
        return jenjangMinimal;
    }

    public void setJenjangMinimal(Integer jenjangMinimal) {
        this.jenjangMinimal = jenjangMinimal;
    }

    public Integer getIdPerusahaan() {
        return idPerusahaan;
    }

    public void setIdPerusahaan(Integer idPerusahaan) {
        this.idPerusahaan = idPerusahaan;
    }

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

    public JenisPegawai getJenisPegawai() {
        return jenisPegawai;
    }

    public void setJenisPegawai(JenisPegawai jenisPegawai) {
        this.jenisPegawai = jenisPegawai;
    }

    public String getJudulLowongan() {
        return judulLowongan;
    }

    public void setJudulLowongan(String judulLowongan) {
        this.judulLowongan = judulLowongan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public int getGajiMinimal() {
        return gajiMinimal;
    }

    public void setGajiMinimal(int gajiMinimal) {
        this.gajiMinimal = gajiMinimal;
    }

    public int getGajiMaksimal() {
        return gajiMaksimal;
    }

    public void setGajiMaksimal(int gajiMaksimal) {
        this.gajiMaksimal = gajiMaksimal;
    }

    public int getSembunyikanGaji() {
        return sembunyikanGaji;
    }

    public void setSembunyikanGaji(int sembunyikanGaji) {
        this.sembunyikanGaji = sembunyikanGaji;
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

    public String getPengalamanKerja() {
        return pengalamanKerja;
    }

    public void setPengalamanKerja(String pengalamanKerja) {
        this.pengalamanKerja = pengalamanKerja;
    }

    public String getKeahlian() {
        return keahlian;
    }

    public void setKeahlian(String keahlian) {
        this.keahlian = keahlian;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Lowongan{" +
                "id=" + id +
                ", perusahaan=" + perusahaan +
                ", judulLowongan='" + judulLowongan + '\'' +
                ", keterangan='" + keterangan + '\'' +
                ", gajiMinimal=" + gajiMinimal +
                ", gajiMaksimal=" + gajiMaksimal +
                ", pengalamanKerja='" + pengalamanKerja + '\'' +
                ", keahlian='" + keahlian + '\'' +
                ", sembunyikanGaji=" + sembunyikanGaji +
                ", createdDate=" + createdDate +
                ", lastModified=" + lastModified +
                ", status='" + status + '\'' +
                '}';
    }
}
