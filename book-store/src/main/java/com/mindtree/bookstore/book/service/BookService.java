package com.mindtree.bookstore.book.service;

import java.util.List;

import com.mindtree.bookstore.entity.Author;
import com.mindtree.bookstore.entity.Book;

public interface BookService {

	
	/**
	 * @param author
	 * @return List<Book>
	 */
	public List<Book> getBooksByAuthor(Author author);
}
