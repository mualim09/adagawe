package com.rps.adagawe.helper;

import com.rps.adagawe.model.Admin;
import com.rps.adagawe.model.UserLogin;
import com.rps.adagawe.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdagaweService {

    @Autowired
    AdagaweRepository adagaweRepository;

    public UserLogin findUserLoginByEmail(String email) {
        return adagaweRepository.getUserLoginByEmail(email);
    }
}
