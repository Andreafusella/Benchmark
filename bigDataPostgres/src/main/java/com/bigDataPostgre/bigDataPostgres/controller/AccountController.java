package com.bigDataPostgre.bigDataPostgres.controller;

import com.bigDataPostgre.bigDataPostgres.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/postgre")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/benchmark")
    public ResponseEntity<String> runBenchmark(@RequestParam int count) {
        accountService.benchmark(count);
        return ResponseEntity.ok("Benchmark completato per " + count + " operazioni. Controlla la console per i dettagli.");
    }
}
