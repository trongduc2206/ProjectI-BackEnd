package com.project.repository.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_time", updatable = false)
    private Date createdTime;

    @Basic
    @UpdateTimestamp
    @Column(name = "modified_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedTime;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name="is_delete")
    private Boolean isDelete = false;

    @Column(name = "creator_id", updatable = false)
    private String creatorId;

    @Basic
    @Column(name = "description")
    private String description;
}
