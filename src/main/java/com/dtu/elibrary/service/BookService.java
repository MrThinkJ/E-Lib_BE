package com.dtu.elibrary.service;

import com.dtu.elibrary.payload.BookDto;
import com.dtu.elibrary.payload.BookResponse;

import java.util.Optional;

public interface BookService {

    BookResponse getAllBook(int pageNo, int pageSize, String sortBy, String sortDir);

    BookDto getBookById(int id);
}
