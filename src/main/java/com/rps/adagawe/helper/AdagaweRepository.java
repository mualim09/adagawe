package com.rps.adagawe.helper;

import com.rps.adagawe.model.Admin;
import com.rps.adagawe.model.Pelamar;
import com.rps.adagawe.model.Perusahaan;
import com.rps.adagawe.model.UserLogin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdagaweRepository extends CrudRepository<UserLogin, Integer> {

    @Query("from UserLogin a where a.email = :email")
    UserLogin getUserLoginByEmail(String email);

    @Query("from Admin a where a.userLogin.id = :id")
    Admin getAdminByUserLogin(int id);

    @Query("from Pelamar a where a.userLogin.id = :id")
    Pelamar getPelamarByUserLogin(int id);

//    @Query(nativeQuery = true, value = "SELECT TOP 1 * from Perusahaan a " +
//            "JOIN UserLogin ul ON a.id_user_login = ul.id WHERE ul.id = :id")
    @Query("from Perusahaan a where a.userLogin.id = :id")
    Perusahaan getPerusahaanByUserLogin(int id);
}