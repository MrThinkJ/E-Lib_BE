package com.dtu.elibrary.controller;

import com.dtu.elibrary.payload.BookAddDto;
import com.dtu.elibrary.payload.BookDto;
import com.dtu.elibrary.payload.BookResponse;
import com.dtu.elibrary.service.BookService;
import com.dtu.elibrary.utils.AppConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public ResponseEntity<BookResponse> getAllBook(@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int pageNo,
                                                   @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int pageSize,
                                                   @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY) String sortBy,
                                                   @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION) String sortDir){
        BookResponse bookResponse = bookService.getAllBook(pageNo, pageSize, sortBy, sortDir);
        return ResponseEntity.ok(bookResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable int id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<BookResponse> findBookByTitle(@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int pageNo,
                                                       @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int pageSize,
                                                       @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY) String sortBy,
                                                       @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION) String sortDir,
                                                       @RequestParam(value = "title") String title){
        BookResponse bookResponse = bookService.findBookByName(pageNo, pageSize, sortBy, sortDir, title);
        return ResponseEntity.ok(bookResponse);
    }

    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BookDto> addNewBook(@ModelAttribute BookAddDto bookDto,
                                              @RequestParam MultipartFile image){
        return new ResponseEntity<>(bookService.addNewBook(bookDto, image), HttpStatus.CREATED);
    }


}
