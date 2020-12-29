package com.project.repository.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigInteger;

@Entity
@Getter
@Setter
@Table(name = "object")
public class Object extends BaseEntity{
    @JsonProperty("type")
    private BigInteger type;

    @JsonProperty("name")
    private String name;

    @JsonProperty("longitude")
    private Double longitude;

    @JsonProperty("latitude")
    private Double latitude;

//    private Double distanceToCurrentPlc;
}
