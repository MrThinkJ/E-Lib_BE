package com.dtu.elibrary.service.impl;

import com.dtu.elibrary.exception.ResourceNotFoundException;
import com.dtu.elibrary.model.Book;
import com.dtu.elibrary.payload.BookDto;
import com.dtu.elibrary.payload.BookResponse;
import com.dtu.elibrary.repository.BookRepository;
import com.dtu.elibrary.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    BookRepository bookRepository;
    ModelMapper mapper;

    public BookServiceImpl(BookRepository bookRepository, ModelMapper mapper) {
        this.bookRepository = bookRepository;
        this.mapper = mapper;
    }

    @Override
    public BookResponse getAllBook(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Book> bookPage = bookRepository.findAll(pageable);
        List<Book> bookList = bookPage.getContent();
        List<BookDto> content = bookList.stream().map(this::mapToDto).collect(Collectors.toList());

        BookResponse bookResponse = new BookResponse();
        bookResponse.setContent(content);
        bookResponse.setPageNo(bookPage.getNumber());
        bookResponse.setPageSize(bookPage.getSize());
        bookResponse.setTotalPage(bookPage.getTotalPages());
        bookResponse.setLastPage(bookPage.isLast());
        bookResponse.setTotalElements(bookPage.getTotalElements());

        return bookResponse;
    }

    @Override
    public BookDto getBookById(int id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("book", "id", id));
        return mapToDto(book);
    }

    private BookDto mapToDto(Book book){
        BookDto bookDto = mapper.map(book, BookDto.class);
        bookDto.setAuthorId(book.getAuthor().getAuthor());
        bookDto.setPublisherId(book.getPublisher().getPublisher());
        return bookDto;
    }

    private Book mapToEntity(BookDto bookDto){
        return mapper.map(bookDto, Book.class);
    }
}
