package com.shinhansec.meta.study.domain.account;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@Slf4j
@RequestMapping("/account")
public class AccoutController {

    @Autowired
    AccountService accountService;

    @GetMapping("/v1/list")
    public ArrayList accounts() {
        return accountService.findAll();
    }

    @GetMapping({"/v2/list","/list"})
    public ArrayList accountsV2() {
        return accountService.findAll();
    }

    @GetMapping
    public Account account(@RequestParam Integer id) {
        return accountService.findById(id);
    }

    @PostMapping
    public Account save(@RequestBody Account account) {
        return accountService.save(account);
    }

    @PutMapping
    public Account update(@RequestParam Integer id,@RequestParam String accountNo,@RequestParam String name,@RequestParam String password) {
        return accountService.update(id, accountNo, name, password);
    }

    @DeleteMapping
    public void remove(@RequestParam Integer id) {
        accountService.remove(id);
    }

//    @DeleteMapping
//    public long removeByAccountNo(@RequestParam String accountNo) {
//        return accountService.removeByAccountNo(accountNo);
//    }
}
