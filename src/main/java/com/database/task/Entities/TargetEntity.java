package com.database.task.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class TargetEntity {

    @Id
    @Column(name = "role_Id")
    private Long departmentId;

    @Column(name = "role_Name")
    private String departmentName;

    @Column(name = "is_active")
    private Boolean active;
}
