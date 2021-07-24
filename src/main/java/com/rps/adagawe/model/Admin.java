package com.rps.adagawe.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_user_login")
    private Integer idUserLogin;

    @ManyToOne
    @JoinColumn(name = "id_user_login", insertable = false, updatable = false)
    private UserLogin userLogin;

    @NotNull
    @Column(name = "tanggal_lahir")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tanggalLahir;

    @NotNull
    @Column(name = "jenis_kelamin")
    private String jenisKelamin;

    @NotEmpty
    @Column(name = "no_telepon")
    private String noTelepon;

    @Column(name = "row_status")
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUserLogin() {
        return idUserLogin;
    }

    public void setIdUserLogin(int idUserLogin) {
        this.idUserLogin = idUserLogin;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public UserLogin getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }
}
