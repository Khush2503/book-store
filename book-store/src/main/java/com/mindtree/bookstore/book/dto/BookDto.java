package com.mindtree.bookstore.book.dto;

import java.time.LocalDate;

import com.mindtree.bookstore.entity.Book;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookDto {

	private String title;

	private double price;

	private String format;

	private String publisher;

	private LocalDate publishDate;

	private String edition;

	private Integer pages;

	private String dimension;

	private String overview;

	private String synopsis;

	private String author;

	public BookDto(String title, double price, String format, String publisher, LocalDate publishDate, String edition,
			Integer pages, String dimension, String overview, String synopsis, String author) {
		super();
		this.title = title;
		this.price = price;
		this.format = format;
		this.publisher = publisher;
		this.publishDate = publishDate;
		this.edition = edition;
		this.pages = pages;
		this.dimension = dimension;
		this.overview = overview;
		this.synopsis = synopsis;
		this.author = author;
	}

	public BookDto(Book book) {
		this.title = book.getTitle();
		this.price = book.getPrice();
		this.format = book.getFormat();
		this.publisher = book.getPublisher();
		this.publishDate = book.getPublishDate();
		this.edition = book.getEdition();
		this.pages = book.getPages();
		this.dimension = book.getDimension();
		this.overview = book.getOverview();
		this.synopsis = book.getSynopsis();
		this.author = book.getAuthor().getName();
	}

}
