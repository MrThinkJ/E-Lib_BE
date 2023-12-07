package com.dtu.elibrary.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookAddDto {
    private String title;
    private String description;
    private int quantity;
    private double price;
//    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate publishedYear;
    private String publisherId;
    private String authorId;
    private List<Integer> categoryIds;
}
