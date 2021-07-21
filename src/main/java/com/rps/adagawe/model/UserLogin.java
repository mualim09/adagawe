package com.rps.adagawe.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "UserLogin")
public class UserLogin implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;

    private String password;

    @Builder.Default
    @Column(name = "row_status")
    private int status = 1;

    @Builder.Default
    @Column(name = "user_role")
    private UserRole userRole = UserRole.Pelamar;

    @Builder.Default
    private Boolean locked = false;

    @Builder.Default
    private Boolean enabled = false;

    @Column(name = "nama")
    private String nama;

    @Column(name = "foto_profil")
    private String fotoProfil;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getFotoProfil() {
        return fotoProfil;
    }

    public void setFotoProfil(String fotoProfil) {
        this.fotoProfil = fotoProfil;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", userRole=" + userRole +
                ", locked=" + locked +
                ", enabled=" + enabled +
                ", nama='" + nama + '\'' +
                ", fotoProfil='" + fotoProfil + '\'' +
                '}';
    }
}
