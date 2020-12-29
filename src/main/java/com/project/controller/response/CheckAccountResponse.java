package com.project.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.domain.GeneralResponse;
import lombok.Data;

@Data
public class CheckAccountResponse extends GeneralResponse {
    @JsonProperty("result")
    private Boolean result;

    @JsonProperty("userName")
    private String userName;
}
