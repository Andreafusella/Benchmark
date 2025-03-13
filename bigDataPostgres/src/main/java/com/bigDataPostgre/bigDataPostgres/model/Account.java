package com.bigDataPostgre.bigDataPostgres.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String lastName;
    private String email;
    private String password;

    public Account(String password, String email, String name, String lastName) {
        this.password = password;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
    }
}
