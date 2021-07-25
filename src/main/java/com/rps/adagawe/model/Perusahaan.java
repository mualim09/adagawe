package com.rps.adagawe.model;

import lombok.Builder;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;

@Entity
public class Perusahaan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_user_login")
    private Integer idUserLogin;

    @ManyToOne
    @JoinColumn(name = "id_user_login", insertable = false, updatable = false)
    private UserLogin userLogin;

    @NotEmpty(message = "Alamat wajib diisi.")
    @Column(name = "alamat_lengkap")
    private String alamatLengkap;

    @NotEmpty(message = "Provinsi wajib diisi.")
    private String provinsi;

    @NotEmpty(message = "Kota wajib diisi.")
    private String kota;

    @Builder.Default
    @Column(name = "telah_terverifikasi")
    private Integer telahTerverifikasi = 0;

    @NotEmpty(message = "Bidang Perusahaan wajib diisi.")
    @Column(name = "bidang_perusahaan")
    private String bidangPerusahaan;

    @Builder.Default
    @Column(name = "row_status")
    private Integer rowStatus = 1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdUserLogin() {
        return idUserLogin;
    }

    public void setIdUserLogin(Integer idUserLogin) {
        this.idUserLogin = idUserLogin;
    }

    public UserLogin getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    public String getAlamatLengkap() {
        return alamatLengkap;
    }

    public void setAlamatLengkap(String alamatLengkap) {
        this.alamatLengkap = alamatLengkap;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public Integer getTelahTerverifikasi() {
        return telahTerverifikasi;
    }

    public void setTelahTerverifikasi(Integer telahTerverifikasi) {
        this.telahTerverifikasi = telahTerverifikasi;
    }

    public String getBidangPerusahaan() {
        return bidangPerusahaan;
    }

    public void setBidangPerusahaan(String bidangPerusahaan) {
        this.bidangPerusahaan = bidangPerusahaan;
    }

    public Integer getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(Integer rowStatus) {
        this.rowStatus = rowStatus;
    }

    @Override
    public String toString() {
        return "Perusahaan{" +
                "id=" + id +
                ", alamatLengkap=" + alamatLengkap +
                ", provinsi=" + provinsi +
                ", kota='" + kota + '\'' +
                ", telahTerverifikasi='" + telahTerverifikasi + '\'' +
                ", bidangPerusahaan='" + bidangPerusahaan + '\'' +
                ", rowStatus='" + rowStatus + '\'' +
                ", userLogin='" + userLogin + '\'' +
                '}';
    }

}
