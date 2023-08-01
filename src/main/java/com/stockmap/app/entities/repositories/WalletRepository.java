package com.stockmap.app.entities.repositories;

import com.stockmap.app.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

    List<Wallet> findAll();
    Wallet findById(long id);
    long countById(long id);
}
