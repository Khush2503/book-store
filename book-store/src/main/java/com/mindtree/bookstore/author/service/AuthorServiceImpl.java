package com.mindtree.bookstore.author.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.bookstore.author.repository.AuthorRepository;
import com.mindtree.bookstore.entity.Author;
import com.mindtree.bookstore.enums.ApiErrorCode;
import com.mindtree.bookstore.exception.ApplicationException;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public Author getAuthor(int authorId) {
		Optional<Author> author = authorRepository.findById(authorId);
		if (author.isPresent()) {
			return author.get();
		} else {
			throw new ApplicationException(ApiErrorCode.DEFAULT_404, "Author not found");
		}
	}

}
