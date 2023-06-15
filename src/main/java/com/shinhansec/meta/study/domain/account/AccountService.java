package com.shinhansec.meta.study.domain.account;

import com.shinhansec.meta.study.common.module.PasswordCheck;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Slf4j
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PasswordCheck passwordCheck;

    public Account findById(Integer id) {
        return accountRepository.findById(id).orElse(new Account());
    }

    public Account save(Account account) {
        if (passwordCheck.check(account.getPassword())) {
            return accountRepository.save(account);
        }
        return account;
    }

    public Account update(Integer id, String accountNo, String name, String password) {

        Account account = new Account();
        account.setId(id);
        account.setAccountNo(accountNo);
        account.setName(name);
        account.setPassword(password);

        return accountRepository.save(account);
    }

    public void remove(Integer id) {
        accountRepository.deleteById(id);
    }

    @Transactional
    public long removeByAccountNo(String accountNo) {
        return accountRepository.deleteAllByAccountNo(accountNo);
    }

    public ArrayList findAll() {
        return (ArrayList) accountRepository.findAll();
    }
}
