package com.JdbcTemplate.bean;

import lombok.Data;

@Data
public class JsonResult {
    private String status = null;

    private Object result = null;

    public JsonResult status(String status) {
        this.status = status;
        return this;
    }
}
