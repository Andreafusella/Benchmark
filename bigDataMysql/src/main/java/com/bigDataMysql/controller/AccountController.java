package com.bigDataMysql.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bigDataMysql.service.AccountService;

@RestController
@RequestMapping("/api/mysql")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/benchmark")
    public ResponseEntity<String> runBenchmark(@RequestParam int count) {
        accountService.benchmark(count);
        return ResponseEntity.ok("Benchmark completato per " + count + " operazioni. Controlla la console per i dettagli.");
    }
}
