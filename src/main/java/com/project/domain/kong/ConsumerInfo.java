package com.project.domain.kong;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ConsumerInfo implements Serializable {


    private static final long serialVersionUID = 6216567423433297675L;

    private String id;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty("created_at")
    private Date createdAt;

    private String username;

    @JsonProperty("custom_id")
    private String customId;

    private List<String> tags;
}
