package com.rps.adagawe.helper;

import com.rps.adagawe.model.Admin;
import com.rps.adagawe.model.Pelamar;
import com.rps.adagawe.model.Perusahaan;
import com.rps.adagawe.model.UserLogin;
import com.rps.adagawe.repository.AdminRepository;
import com.rps.adagawe.repository.PelamarRepository;
import com.rps.adagawe.repository.PerusahaanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdagaweService {

    @Autowired
    AdagaweRepository adagaweRepository;

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    PelamarRepository pelamarRepository;

    @Autowired
    PerusahaanRepository perusahaanRepository;

    public UserLogin findUserLoginByEmail(String email) {
        return adagaweRepository.getUserLoginByEmail(email);
    }

    public Admin findAdminByUserLogin(int id) {
        return adagaweRepository.getAdminByUserLogin(id);
    }

    public Pelamar findPelamarByUserLogin(int id) { return adagaweRepository.getPelamarByUserLogin(id); }

    public Perusahaan findPerusahaanByUserLogin(int id) {
        return adagaweRepository.getPerusahaanByUserLogin(id);
    }

    public void updateAdmin(Admin admin) { adminRepository.save(admin); }

    public void updatePelamar(Pelamar pelamar) { pelamarRepository.save(pelamar); }

    public void updatePerusahaan(Perusahaan perusahaan) { perusahaanRepository.save(perusahaan); }

    public int findTotalLamaran() {
        return adagaweRepository.getTotalLowongan();
    }

    public int findTotalUserByRole(int id) {
        return adagaweRepository.getTotalUserByUserRole(id);
    }

    public int findTotalLowonganByPerusahaan(int id) {
        return adagaweRepository.getTotalLowonganByPerusahaan(id);
    }

    public int findTotalLowonganAktifByPerusahaan(int id) { return adagaweRepository.getTotalLowonganAktifByPerusahaan(id); }
}
