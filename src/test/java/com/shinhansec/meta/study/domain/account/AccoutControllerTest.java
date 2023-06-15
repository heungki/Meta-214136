package com.shinhansec.meta.study.domain.account;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class AccoutControllerTest {

    @Autowired
    AccountService accountService;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        log.info("setup");
        Account account = new Account();
        account.setAccountNo("01234567890");
        account.setName("Shinhan");
        account.setPassword("0000");
        accountService.save(account);
    }
    @Test
    void accounts() throws Exception {
        mockMvc.perform(get("/account/list"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void account() throws Exception {

       mockMvc.perform(get("/account")
                        .param("id", "1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void save() throws Exception {
        mockMvc.perform(post("/account")
                .content("{\n" +
                        "    \"accountNo\" : \"22222\",\n" +
                        "    \"name\" : \"TEST\",\n" +
                        "    \"password\" : \"11111\"\n" +
                        "}"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void update() {
    }

    @Test
    void remove() {
    }
}