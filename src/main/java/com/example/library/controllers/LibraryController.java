package com.example.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.entities.Book;
import com.example.library.services.LibraryService;

@RestController
public class LibraryController {
	
	
	@Autowired
	LibraryService libraryService;
	
	@GetMapping("/book/{author}")
	  public List<String> getBooks(@PathVariable String author){
	    return libraryService.getBooksByAuthor(author);
	  }
	
	@PostMapping("/addbook")
	  public Book addBook(@RequestBody Book book) {
	    return libraryService.addBook(book);
	  }
	
	@DeleteMapping("/deletebook/{id}")
	  public void deleteBook( @PathVariable Integer id){
	    libraryService.deleteBook(id);
	  }
	
	@PutMapping("/update/{id}")
	  public Book updateBook( @PathVariable Integer id, @RequestBody Book book){
	   return  libraryService.updateBook(book, id);
	  }
	

}
