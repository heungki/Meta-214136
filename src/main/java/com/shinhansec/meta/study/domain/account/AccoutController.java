package com.shinhansec.meta.study.domain.account;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@Slf4j
@RequestMapping("/account")
@Validated
public class AccoutController {

    AccountService accountService;

    @Autowired
    public void setAccountService(AccountService accountService){
        this.accountService = accountService;
    }

    @Operation(summary = "계좌조회", description = "계좌목록을 조회함. ", tags = { "Account Controller" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = Account.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
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
    public Account save(@RequestBody @Valid Account account) {
        return accountService.save(account);
    }

    @PutMapping
    public Account update(@RequestParam Integer id, @RequestParam String accountNo, @RequestParam @Valid @Size(min=3, max=3) String name, @RequestParam  @Nullable String password) {
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
