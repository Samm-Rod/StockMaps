package com.stockmap.app.entities.repositories;

import com.stockmap.app.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, String> {

        List<Users> findAll();
        Users findByCpfCnpj(String cpf);


}
