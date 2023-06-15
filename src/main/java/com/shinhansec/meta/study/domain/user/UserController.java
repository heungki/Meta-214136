package com.shinhansec.meta.study.domain.user;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
@Validated
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @PostMapping("/user")
    public User save(@RequestBody @Valid User user) {
        return userService.save(user);
    }

    @DeleteMapping("/user")
    public void remove(@RequestParam Integer id) {
        userService.deleteById(id);
    }

    @PutMapping("/user")
    public User update(@RequestBody @Valid User user) {
        return userService.save(user);
    }
}
