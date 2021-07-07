package com.rps.adagawe.service;

import com.rps.adagawe.model.Admin;
import com.rps.adagawe.model.UserLogin;
import com.rps.adagawe.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public List<Admin> getAll() {
        return (List<Admin>) adminRepository.findAll();
    }

    public void save(Admin Admin) {
        adminRepository.save(Admin);
    }

    public Admin getAdminById(Integer id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Admin Id:" + id));
    }

    public UserLogin findUserLoginByEmail(String email) {
        return adminRepository.getAdminByUserLogin(email);
    }

    public Admin getAdminByUserLogin(Integer id) {
        return adminRepository.getAdminByIdUserLogin(id);
    }

}
