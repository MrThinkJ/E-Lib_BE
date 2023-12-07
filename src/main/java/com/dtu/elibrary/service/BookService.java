package com.dtu.elibrary.service;

import com.dtu.elibrary.payload.BookDto;
import com.dtu.elibrary.payload.BookResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface BookService {

    BookResponse getAllBook(int pageNo, int pageSize, String sortBy, String sortDir);
    BookResponse findBookByName(int pageNo, int pageSize, String sortBy, String sortDir, String name);

    BookDto addNewBook(BookDto bookDto, MultipartFile image);

    BookDto getBookById(int id);
}
