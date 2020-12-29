package com.project.repository.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "account")
public class Account extends BaseEntity {

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("passWord")
    private String passWord;
}
