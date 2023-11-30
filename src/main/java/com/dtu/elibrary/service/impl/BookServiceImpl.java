package com.dtu.elibrary.service.impl;

import com.dtu.elibrary.exception.ResourceNotFoundException;
import com.dtu.elibrary.model.Author;
import com.dtu.elibrary.model.Book;
import com.dtu.elibrary.model.Publisher;
import com.dtu.elibrary.payload.BookDto;
import com.dtu.elibrary.payload.BookResponse;
import com.dtu.elibrary.repository.AuthorRepository;
import com.dtu.elibrary.repository.BookRepository;
import com.dtu.elibrary.repository.PublisherRepository;
import com.dtu.elibrary.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    BookRepository bookRepository;
    AuthorRepository authorRepository;
    PublisherRepository publisherRepository;
    ModelMapper mapper;

    public BookServiceImpl(BookRepository bookRepository,
                           AuthorRepository authorRepository,
                           PublisherRepository publisherRepository,
                           ModelMapper mapper) {
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
        this.bookRepository = bookRepository;
        this.mapper = mapper;
    }

    @Override
    public BookResponse getAllBook(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Book> bookPage = bookRepository.findAll(pageable);
        return mapToResponse(bookPage);
    }

    @Override
    public BookResponse findBookByName(int pageNo, int pageSize, String sortBy, String sortDir, String title) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Book> bookPage = bookRepository.findByTitleContaining(title, pageable);
        return mapToResponse(bookPage);
    }

    @Override
    public BookDto getBookById(int id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("book", "id", String.valueOf(id)));
        return mapToDto(book);
    }

    @Override
    public BookDto addNewBook(BookDto bookDto) {
        Book book = mapToEntity(bookDto);
        Author author = authorRepository.findById(bookDto.getAuthorId()).orElseThrow(() -> new ResourceNotFoundException("author", "id", bookDto.getAuthorId()));
        book.setAuthor(author);
        Publisher publisher = publisherRepository.findById(bookDto.getPublisherId()).orElseThrow(() -> new ResourceNotFoundException("publisher", "id", bookDto.getPublisherId()));
        book.setPublisher(publisher);
        book.setCreateDate(LocalDate.now());
        book.setBorrowEntities(null);
        Book newBook = bookRepository.save(book);
        return mapToDto(newBook);
    }

    private BookResponse mapToResponse(Page<Book> bookPage){
        BookResponse bookResponse = new BookResponse();
        bookResponse.setContent(bookPage.getContent().stream().map(this::mapToDto).collect(Collectors.toList()));
        bookResponse.setPageNo(bookPage.getNumber());
        bookResponse.setPageSize(bookPage.getSize());
        bookResponse.setTotalPage(bookPage.getTotalPages());
        bookResponse.setLastPage(bookPage.isLast());
        bookResponse.setTotalElements(bookPage.getTotalElements());
        return bookResponse;
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
