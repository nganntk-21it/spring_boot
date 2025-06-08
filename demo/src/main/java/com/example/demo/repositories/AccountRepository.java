package com.example.demo.repositories;

import com.example.demo.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {
    AccountEntity findByAccountAndPassword(String account, String password);
}
