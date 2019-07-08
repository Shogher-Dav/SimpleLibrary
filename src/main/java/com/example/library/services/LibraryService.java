package com.example.library.services;

import java.util.List;

import com.example.library.entities.Book;

public interface LibraryService {
	
	public List<String> getBooksByAuthor( String author);
	
	public void deleteBook(Integer id);
	
	public Book addBook(Book book);
	
	public Book updateBook(Book book, Integer id);

}
