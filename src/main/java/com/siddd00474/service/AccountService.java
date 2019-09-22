package com.siddd00474.service;

import com.siddd00474.entity.Account;
import com.siddd00474.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //list
    public List<Account> getList(){
        return accountRepository.findAll();
    }
    //add
    public Account createNewAccount(Account account){
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setCreatedAt(Calendar.getInstance().getTimeInMillis());
        account.setStatus(1);
        account.setRole(Account.Role.USER.getValue());
        accountRepository.save(account);
        return account;
    }
    // get detail
    public Account getByEmail(String email){
        return accountRepository.findById(email).orElse(null);
    }
}
