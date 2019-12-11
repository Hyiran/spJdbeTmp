package com.JdbcTemplate.enity;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
public class User {
    private int id;

    private String name;

    private int age;

    private double money;

    public User(String name, int age,double money) {
        this.name = name;
        this.age = age;
        this.money = money;
    }

}
