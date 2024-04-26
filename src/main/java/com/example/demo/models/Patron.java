package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table
public class Patron {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @NotBlank(message = "Email cannot be blank")
    @Column
    private String email;

    @Column
    private String mobileNumber;
}
