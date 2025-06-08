package com.example.demo.services;

import com.example.demo.entities.AccountEntity;
import com.example.demo.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

//@Service
//@RequiredArgsConstructor
public interface AccountServices {
    AccountEntity login(String account, String password);
}
