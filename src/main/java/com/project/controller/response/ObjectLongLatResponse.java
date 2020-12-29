package com.project.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.domain.GeneralResponse;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ObjectLongLatResponse  {
    @JsonProperty("name")
    String name;

    @JsonProperty("longitude")
    Double longitude;

    @JsonProperty("latitude")
    Double latitude;
}
