package com.database.task.controller;

import com.database.task.service.DataTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataTransferController {

    @Autowired
    private DataTransferService dataTransferService;

    @PostMapping("/transfer-data")
    public String transferData() {
        dataTransferService.transferData();
        return "Data transfer complete using JdbcTemplate";
    }
}
