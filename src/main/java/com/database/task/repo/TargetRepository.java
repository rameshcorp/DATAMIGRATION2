package com.database.task.repo;

import com.database.task.Entities.TargetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TargetRepository extends JpaRepository<TargetEntity, Long> {
    // Custom query methods can be defined here if necessary
}
