package com.bigDataMysql.service;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.bigDataMysql.model.Account;
import com.bigDataMysql.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    // INSERT
    public long add(int number) {
        List<Account> accounts = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            accounts.add(new Account("password" + i, "email" + i + "@example.com", "name" + i, "lastName" + i));
        }
        long startTime = System.currentTimeMillis();
        accountRepository.saveAll(accounts);
        long stopTime = System.currentTimeMillis();
        return stopTime - startTime;
    }

    // SELECT
    public long select(int number) {
        long startTime = System.currentTimeMillis();
        List<Account> accounts = accountRepository.findAll(PageRequest.of(0, number)).getContent();
        long stopTime = System.currentTimeMillis();
        return stopTime - startTime;
    }

    // UPDATE
    public long update(int number) {
        List<Account> accounts = accountRepository.findAll(PageRequest.of(0, number)).getContent();
        for (Account account : accounts) {
            account.setPassword("updatedPassword");
        }
        long startTime = System.currentTimeMillis();
        accountRepository.saveAll(accounts);
        long stopTime = System.currentTimeMillis();
        return stopTime - startTime;
    }

    // DELETE
    public long delete(int number) {
        List<Account> accounts = accountRepository.findAll(PageRequest.of(0, number)).getContent();
        long startTime = System.currentTimeMillis();
        accountRepository.deleteAll(accounts);
        long stopTime = System.currentTimeMillis();
        return stopTime - startTime;
    }

    // METODO COMPLETO (INSERT -> SELECT -> UPDATE -> DELETE)
    public void benchmark(int number) {
        long insertTime = add(number);
        long selectTime = select(number);
        long updateTime = update(number);
        long deleteTime = delete(number);

        System.out.println("Benchmark MySql per " + number + " operazioni:");
        System.out.println("INSERT: " + formatTime(insertTime));
        System.out.println("SELECT: " + formatTime(selectTime));
        System.out.println("UPDATE: " + formatTime(updateTime));
        System.out.println("DELETE: " + formatTime(deleteTime));
    }

    private String formatTime(long timeMillis) {
        double elapsedTimeInSeconds = timeMillis / 1000.0;
        DecimalFormat df = new DecimalFormat("0.00000");
        return df.format(elapsedTimeInSeconds) + " sec";
    }
}
