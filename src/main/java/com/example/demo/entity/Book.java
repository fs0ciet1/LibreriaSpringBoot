package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /*
    * utilizzo  @Column per specificare i dettagli della mappatura di un campo del db in un'entità.
     */
    @Column(name = "name")
    private String name;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "isbn_code")
    private String isbn_code;

    @Column(name = "add_date")
    private LocalDate addDate;

    @Column(name = "del_date")
    private LocalDate delDate;

    @Column(name = "plot")
    private String plot;

    @Column(name = "read_counter")
    private int readCounter;


}
