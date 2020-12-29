package com.project.repository;

import com.project.repository.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface AccountRepository extends JpaRepository<Account, Integer>, JpaSpecificationExecutor {
    Optional<Account> findByUserNameAndPassWord(String userName, String passWord);
}
