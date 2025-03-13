package com.bigDataMysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bigDataMysql.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
