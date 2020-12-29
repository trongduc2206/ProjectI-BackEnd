package com.project.repository;

import com.project.repository.entity.Object;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ObjectRepository extends JpaRepository<Object, Integer>, JpaSpecificationExecutor<Object> {

    Optional<List<Object>> findByNameContaining(String name);
}
