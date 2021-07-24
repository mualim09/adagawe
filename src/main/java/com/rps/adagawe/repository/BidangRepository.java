package com.rps.adagawe.repository;

import com.rps.adagawe.model.Bidang;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BidangRepository extends CrudRepository<Bidang, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM view_LaporanBidang")
    List<Bidang> getAllBidang();
}
