package com.database.task.service;

import com.database.task.Entities.SourceEntity;
import com.database.task.service.DataTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class DataTransferServiceImpl implements DataTransferService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // RowMapper to map SQL results to SourceEntity
    private final RowMapper<SourceEntity> sourceEntityRowMapper = new RowMapper<SourceEntity>() {
        @Override
        public SourceEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            SourceEntity sourceEntity = new SourceEntity();
            sourceEntity.setDepId(rs.getLong("RoleId")); // Mapping "RoleId" to depId
            sourceEntity.setDepartment(rs.getString("RoleName")); // Mapping "RoleName" to department
            sourceEntity.setIsActive(rs.getBoolean("IsActive")); // Mapping "IsActive"
            return sourceEntity;
        }
    };

    @Override
    public void transferData() {
        // Fetch data from vms_roles table
        String selectSql = "SELECT RoleId, RoleName, IsActive FROM vms_roles";
        List<SourceEntity> sourceEntities = jdbcTemplate.query(selectSql, sourceEntityRowMapper);

        // Insert data into roles table
        String insertSql = "INSERT INTO roles (role_Id, role_Name, is_active) VALUES (?, ?, ?)";

        for (SourceEntity sourceEntity : sourceEntities) {
            jdbcTemplate.update(insertSql,
                    sourceEntity.getDepId(),
                    sourceEntity.getDepartment(),
                    sourceEntity.getIsActive());
        }
    }
}
