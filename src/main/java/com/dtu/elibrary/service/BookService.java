package com.dtu.elibrary.service;

import com.dtu.elibrary.model.Book;
import com.dtu.elibrary.payload.BookAddDto;
import com.dtu.elibrary.payload.BookDto;
import com.dtu.elibrary.payload.BookResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface BookService {

    BookResponse getAllBook(int pageNo, int pageSize, String sortBy, String sortDir);
    BookResponse findBookByName(int pageNo, int pageSize, String sortBy, String sortDir, String name);

    BookDto addNewBook(BookAddDto bookDto);

    BookDto getBookById(int id);
}
