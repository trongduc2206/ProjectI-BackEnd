package com.project.service;


import com.project.controller.response.CheckAccountResponse;
import com.project.controller.response.SignUpResponse;
import com.project.repository.entity.Account;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AccountService {
    CheckAccountResponse checkAccount(String userName, String passWord);

    SignUpResponse checkSignup(String userName, String passWord, String confirmPassword);

}
