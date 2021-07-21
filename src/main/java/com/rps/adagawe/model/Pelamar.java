package com.rps.adagawe.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Pelamar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Tanggal lahir wajib diisi.")
    @Column(name = "tanggal_lahir")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tanggalLahir;

    @NotEmpty(message = "Jenis kelamin wajib diisi.")
    @Column(name = "jenis_kelamin")
    private char jenisKelamin;

    @NotEmpty(message = "Kota wajib diisi.")
    private String kota;

    @NotEmpty(message = "Alamat wajib diisi.")
    private String alamat;

    @NotEmpty(message = "No. Telepon wajib diisi.")
    @Column(name = "no_telepon")
    private String noTelepon;

    private String headline;

    @NotEmpty(message = "CV wajib diisi.")
    @Column(name = "dokumen_cv")
    private String dokumenCv;

    @NotEmpty
    @Column(name = "id_user_login")
    private int idUserLogin;

    @Column(name = "row_status")
    private Integer rowStatus;

    @ManyToOne
    @JoinColumn(name = "id_user_login", insertable = false, updatable = false)
    private UserLogin userLogin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public char getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(char jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getDokumenCv() {
        return dokumenCv;
    }

    public void setDokumenCv(String dokumenCv) {
        this.dokumenCv = dokumenCv;
    }

    public int getIdUserLogin() {
        return idUserLogin;
    }

    public void setIdUserLogin(int idUserLogin) {
        this.idUserLogin = idUserLogin;
    }

    public Integer getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(Integer rowStatus) {
        this.rowStatus = rowStatus;
    }

    public UserLogin getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    @Override
    public String toString() {
        return "Pelamar{" +
                "id=" + id +
                ", tanggalLahir=" + tanggalLahir +
                ", jenisKelamin=" + jenisKelamin +
                ", kota='" + kota + '\'' +
                ", alamat='" + alamat + '\'' +
                ", noTelepon='" + noTelepon + '\'' +
                ", headline='" + headline + '\'' +
                ", dokumenCv='" + dokumenCv + '\'' +
                ", idUserLogin=" + idUserLogin +
                ", rowStatus=" + rowStatus +
                ", userLogin=" + userLogin +
                '}';
    }
}
