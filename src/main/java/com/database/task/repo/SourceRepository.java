package com.database.task.repo;

import com.database.task.Entities.SourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SourceRepository extends JpaRepository<SourceEntity, Long> {
    // Custom query methods can be defined here if necessary
}
