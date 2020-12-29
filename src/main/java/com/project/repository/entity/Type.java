package com.project.repository.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "type")
public class Type extends BaseEntity {
    @JsonProperty("type_name")
    private String typeName;

}
