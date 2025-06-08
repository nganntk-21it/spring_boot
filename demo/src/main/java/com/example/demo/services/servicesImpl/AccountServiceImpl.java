package com.example.demo.services.servicesImpl;

import com.example.demo.entities.AccountEntity;
import com.example.demo.repositories.AccountRepository;
import com.example.demo.services.AccountServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountServices {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountEntity login(String account, String password) {
        return accountRepository.findByAccountAndPassword(account, password);
    }
}
