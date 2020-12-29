package com.project.service.impl;

import com.project.controller.response.CheckAccountResponse;
import com.project.controller.response.SignUpResponse;
import com.project.domain.ResponseStatus;
import com.project.repository.AccountRepository;
import com.project.repository.entity.Account;
import com.project.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository ;

    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }


    public CheckAccountResponse  checkAccount(String userName, String passWord){
        CheckAccountResponse checkAccountResponse = new CheckAccountResponse();
            Optional<Account> accountOptional = accountRepository.findByUserNameAndPassWord(userName, passWord);
            if(accountOptional.isPresent()){
                checkAccountResponse.setResult(true);
                checkAccountResponse.setUserName(userName);
            }
            else checkAccountResponse.setResult(false);
            return checkAccountResponse;
    }

    public SignUpResponse checkSignup(String userName, String passWord, String confirmPassword){
        Account account = new Account();
        SignUpResponse signUpResponse = new SignUpResponse();

        if(!passWord.equals(confirmPassword)){
            signUpResponse.setStatus(new ResponseStatus("002","Mật khẩu xác nhận khác mật khẩu"));
            signUpResponse.setResult(false);

        }else {
            Optional<Account> optionalAccount = accountRepository.findByUserNameAndPassWord(userName, passWord);
            if (optionalAccount.isPresent()) {
                signUpResponse.setResult(false);
                signUpResponse.setStatus(new ResponseStatus("001", "Tài khoản đã tồn tại"));
            }
            else {
                signUpResponse.setStatus(new ResponseStatus("000", "success"));
                signUpResponse.setResult(true);
                account.setUserName(userName);
                account.setPassWord(passWord);
                accountRepository.save(account);
            }
        }
        return signUpResponse;
    }
}
