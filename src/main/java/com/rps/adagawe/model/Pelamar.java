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

    @NotEmpty(message = "Nama pelamar wajib diisi.")
    @Column(name = "nama_pelamar")
    private String namaPelamar;

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

    @NotEmpty(message = "CV wajib diisi.")
    @Column(name = "dokumen_cv")
    private String dokumenCv;

    @NotEmpty
    @Column(name = "id_user_login")
    private int idUserLogin;

    @NotEmpty(message = "Foto Profil wajib diisi.")
    @Column(name = "foto_profil")
    private String fotoProfil;

    @Column(name = "row_status")
    private Integer rowStatus;

    @ManyToOne
    @JoinColumn(name = "id_user_login", insertable = false, updatable = false)
    private UserLogin userLogin;

    @Column(name = "pendidikan_terakhir", insertable = false, updatable = false)
    private String pendidikanTerakhir;

    @Column(insertable = false, updatable = false)
    private Integer umur;

    @Column(name = "id_lamaran", insertable = false, updatable = false)
    private Integer idLamaran;

    @Column(name = "status_lamaran", insertable = false, updatable = false)
    private Integer statusLamaran;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaPelamar() {
        return namaPelamar;
    }

    public void setNamaPelamar(String namaPelamar) {
        this.namaPelamar = namaPelamar;
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

    public String getFotoProfil() {
        return fotoProfil;
    }

    public void setFotoProfil(String fotoProfil) {
        this.fotoProfil = fotoProfil;
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

    public String getPendidikanTerakhir() {
        return pendidikanTerakhir;
    }

    public void setPendidikanTerakhir(String pendidikanTerakhir) {
        this.pendidikanTerakhir = pendidikanTerakhir;
    }

    public Integer getUmur() {
        return umur;
    }

    public void setUmur(Integer umur) {
        this.umur = umur;
    }

    public Integer getIdLamaran() {
        return idLamaran;
    }

    public void setIdLamaran(Integer idLamaran) {
        this.idLamaran = idLamaran;
    }

    public Integer getStatusLamaran() {
        return statusLamaran;
    }

    public void setStatusLamaran(Integer statusLamaran) {
        this.statusLamaran = statusLamaran;
    }

    @Override
    public String toString() {
        return "Pelamar{" +
                "id=" + id +
                ", namaPelamar='" + namaPelamar + '\'' +
                ", tanggalLahir=" + tanggalLahir +
                ", jenisKelamin=" + jenisKelamin +
                ", kota='" + kota + '\'' +
                ", alamat='" + alamat + '\'' +
                ", noTelepon='" + noTelepon + '\'' +
                ", dokumenCv='" + dokumenCv + '\'' +
                ", idUserLogin=" + idUserLogin +
                ", fotoProfil='" + fotoProfil + '\'' +
                ", rowStatus=" + rowStatus +
                ", userLogin=" + userLogin +
                ", pendidikanTerakhir='" + pendidikanTerakhir + '\'' +
                ", umur=" + umur +
                ", idLamaran=" + idLamaran +
                '}';
    }
}
