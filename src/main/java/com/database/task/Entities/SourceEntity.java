package com.database.task.Entities;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "vms_roles")
public class SourceEntity {

    @Id
    @Column(name = "RoleId")
    private Long depId;

    @Column(name = "RoleName")
    private String department;

    @Column(name = "IsActive")
    private Boolean isActive;

    // Other fields can be added if needed, but only the required ones are listed here
}
