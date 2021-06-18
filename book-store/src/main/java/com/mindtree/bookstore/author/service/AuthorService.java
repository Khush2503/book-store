package com.mindtree.bookstore.author.service;

import com.mindtree.bookstore.entity.Author;

public interface AuthorService {

	/**
	 * @param authorId
	 * @return Author
	 */
	public Author getAuthor(int authorId);
}
