package com.example.library.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.library.entities.Book;
import com.example.library.repositories.BookRepository;

@Service
public class LibraryServiceImpl implements LibraryService {
	
	@Autowired
	private BookRepository bookRepo;

	@Override
	public List<String> getBooksByAuthor(String author) {
		
		return bookRepo.getByAuthor(author);
	}

	@Override
	public void deleteBook(Integer id) {
		bookRepo.deleteById(id);
		
	}

	@Override
	public Book addBook(Book book) {
		return bookRepo.save(book);
	}

	@Override
	public Book updateBook(Book book, Integer id) {
		Book updatedBook = bookRepo.findById(id)
		            .orElseThrow(() -> new ResourceNotFoundException());
		
		updatedBook.setTitle(book.getTitle());
		updatedBook.setAuthor(book.getAuthor());
		
		return bookRepo.save(updatedBook);
	}

}
