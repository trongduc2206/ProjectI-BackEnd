package com.project.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.domain.GeneralResponse;
import lombok.Data;

import java.util.List;

@Data
public class ObjectResponseDto extends GeneralResponse {
    @JsonProperty("data")
    private List<ObjectLongLatResponse> data;
}
