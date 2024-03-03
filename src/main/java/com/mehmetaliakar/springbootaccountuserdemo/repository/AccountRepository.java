package com.mehmetaliakar.springbootaccountuserdemo.repository;

import com.mehmetaliakar.springbootaccountuserdemo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
