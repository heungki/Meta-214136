package com.shinhansec.meta.study.domain.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    long deleteAllByAccountNo(String accountNo);
}
