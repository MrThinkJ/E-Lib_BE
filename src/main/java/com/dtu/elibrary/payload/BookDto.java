package com.dtu.elibrary.payload;

import com.dtu.elibrary.model.Author;
import com.dtu.elibrary.model.Publisher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private int id;
    private String title;
    private String description;
    private int quantity;
    private double price;
    private String image;
    private LocalDate createDate;
    private LocalDate publishedYear;
    private Publisher publisher;
    private Author author;
}