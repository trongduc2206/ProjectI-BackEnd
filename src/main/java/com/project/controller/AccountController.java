package com.project.controller;

import com.project.controller.response.CheckAccountResponse;
import com.project.controller.response.SignUpResponse;
import com.project.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(value = "*")
@Slf4j
@RestController
@RequestMapping("/internal/account/v1/accounts")
public class AccountController extends BaseController{
    private AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping("/{userName}/{passWord}")
    public CheckAccountResponse checkAccountResponse(@PathVariable String userName, @PathVariable String passWord){
        return accountService.checkAccount(userName, passWord);
    }
    @GetMapping("/{userName}/{passWord}/{confirmPassword}")
    public SignUpResponse checkSignup(@PathVariable String userName,@PathVariable String passWord,@PathVariable String confirmPassword){
        return accountService.checkSignup(userName, passWord, confirmPassword);
    }
}
