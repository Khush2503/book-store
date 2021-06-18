package com.mindtree.bookstore.book.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.bookstore.entity.Author;
import com.mindtree.bookstore.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	@Query("SELECT book FROM Book book WHERE book.author = :author and book.isActive = :isActive "
			+ "and book.expirationDate >= :expirationDate")
	List<Book> getBooksByAuthor(Author author, boolean isActive, LocalDate expirationDate);
}
