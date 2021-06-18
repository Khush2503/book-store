package com.mindtree.bookstore.book.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.bookstore.author.service.AuthorService;
import com.mindtree.bookstore.book.dto.BookDto;
import com.mindtree.bookstore.book.service.BookService;
import com.mindtree.bookstore.entity.Author;
import com.mindtree.bookstore.entity.Book;

@RestController
@CrossOrigin
@RequestMapping("/author")
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private AuthorService authorService;

	@GetMapping("/{authorId}/books")
	public List<BookDto> getBooksByAuthor(@PathVariable int authorId) {
		Author author = authorService.getAuthor(authorId);
		List<Book> bookList = bookService.getBooksByAuthor(author);
		List<BookDto> booksByAuthor = bookList.stream().map(book -> new BookDto(book)).collect(Collectors.toList());
		return booksByAuthor;
	}

}
