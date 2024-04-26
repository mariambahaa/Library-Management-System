package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @NotBlank(message = "Title cannot be blank")
    @Column
    private String title;

    @Column
    private String author;

    @Column
    private int publicationYear;

    @Column
    private String isbn;
}
