package com.bigDataPostgre.bigDataPostgres.repository;

import com.bigDataPostgre.bigDataPostgres.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
