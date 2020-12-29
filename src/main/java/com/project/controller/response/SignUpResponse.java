package com.project.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.domain.GeneralResponse;
import lombok.Data;

@Data
public class SignUpResponse extends GeneralResponse {
    @JsonProperty("result")
    private Boolean result;


}
