package com.rps.adagawe.repository;

import com.rps.adagawe.model.Notifikasi;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NotifikasiRepository extends CrudRepository<Notifikasi, Integer> {
    List<Notifikasi> findAllByOrderByCreatedDateDesc();
}
