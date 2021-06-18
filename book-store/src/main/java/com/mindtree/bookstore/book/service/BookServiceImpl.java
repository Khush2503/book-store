package com.mindtree.bookstore.book.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.bookstore.book.repository.BookRepository;
import com.mindtree.bookstore.entity.Author;
import com.mindtree.bookstore.entity.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> getBooksByAuthor(Author author) {
		List<Book> bookList = bookRepository.getBooksByAuthor(author, true, LocalDate.now());
		return bookList;
	}

}
