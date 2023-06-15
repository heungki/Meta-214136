package com.shinhansec.meta.study.domain.account;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@Slf4j
class AccountServiceTest {

    @Autowired
    AccountService accountService;

    @BeforeEach
    void setUp() {
        log.info("setUp..");
        Account account = new Account();
        account.setAccountNo("01234567890");
        account.setName("Shinhan");
        account.setPassword("0000");
        accountService.save(account);
    }

    @AfterEach
    void tearDown() {
        log.info("tearDown..");
    }

    @Test
    void findById() {
        log.info("findById");
        // 처음가져오기
        Account account = accountService.findById(1);
        assertEquals(1, account.getId());

        // 없는데이터 가져오기
        account = accountService.findById(10);
        assertNull(account.getId());
    }

    @Test
    void save() {
        log.info("save");
        Account account = new Account();
        account.setAccountNo("999999999");
        account.setName("Lee");
        account.setPassword("0");

        Account savedAccount = accountService.save(account);
        assertNull(savedAccount.getId());
        assertEquals(account.getName(), savedAccount.getName());
        assertEquals(account.getAccountNo(), savedAccount.getAccountNo());
        assertEquals(account.getPassword(), savedAccount.getPassword());


        // password 가 동일4자리는 안되게 해야함.

    }

    @Test
    void 패스워드_동일4자리_테스트() {
        Account account = new Account();
        account.setAccountNo("999999999");
        account.setName("Lee");
        account.setPassword("0000");

        Account savedAccount = accountService.save(account);
        assertNull(savedAccount.getId());
        assertEquals(account.getName(), savedAccount.getName());
        assertEquals(account.getAccountNo(), savedAccount.getAccountNo());
        assertEquals(account.getPassword(), savedAccount.getPassword());
    }

    @Test
    void update() {
        log.info("update");
        Account account = new Account();
        account.setId(1);
        account.setAccountNo("999999999");
        account.setName("Lee");
        account.setPassword("9999");

        Account savedAccount = accountService.save(account);
        assertEquals(1, savedAccount.getId());
        assertEquals(account.getName(), savedAccount.getName());
        assertEquals(account.getAccountNo(), savedAccount.getAccountNo());
        assertEquals(account.getPassword(), savedAccount.getPassword());
    }


    @Test
    void findAll() {
        log.info("findAll");
        ArrayList<Account> list = accountService.findAll();
        log.info("list size {}", list.size());
    }
}