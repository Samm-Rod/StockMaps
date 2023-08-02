package com.stockmap.app.entities.repositories;

import com.stockmap.app.entities.Assets;
import com.stockmap.app.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssetsRepository extends JpaRepository<Assets, String> {


    List<Assets> findAll();
    Assets findById(long id);
    long countById(long id);

}
